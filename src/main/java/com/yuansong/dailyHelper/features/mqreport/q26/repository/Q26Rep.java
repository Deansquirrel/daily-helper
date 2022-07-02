package com.yuansong.dailyHelper.features.mqreport.q26.repository;

import com.github.deansquirrel.tools.common.DateTool;
import com.github.deansquirrel.tools.common.SQLTool;
import com.github.deansquirrel.tools.db.Constant;
import com.github.deansquirrel.tools.db.IToolsDbHelper;
import com.github.deansquirrel.tools.db.TargetSource;
import com.google.gson.Gson;
import com.yuansong.dailyHelper.global.DHConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Repository
public class Q26Rep {

    private static final Logger logger = LoggerFactory.getLogger(Q26Rep.class);

    private static final String SQL_QUERY = "" +
            "SELECT INSU_ADMDVS, " +
            "       (case " +
            "           when DEDC_HOSP_LV in ('1','2','3','9') then DEDC_HOSP_LV " +
            "           else '3' " +
            "       end) DEDC_HOSP_LV, " +
            "   MDTRT_ID, SETL_ID " +
            "FROM setl_d " +
            "WHERE INSU_ADMDVS LIKE '1311%'  " +
            "   and SETL_TIME >= ? " +
            "   and SETL_TIME < ? " +
            "   AND VALI_FLAG = '1' " +
            "   AND INSUTYPE = '390' " +
            "   AND REFD_SETL_FLAG = '0' " +
            "   AND MED_TYPE IN ('52','21','13','24','23','22','92','9104','9105','9203','9202','9203','9105','9204','9104','9204','9106','9104','9202','9201','9104','9110','9106','9206','9201','9205','9109') " +
            " ;";
    private static final String SQL_QUERY_SIGNAL = "" +
            "SELECT " +
            "   SUM(CASE WHEN SELFPAY_PROP <>1 and left(LIST_TYPE,1)='1' THEN DET_ITEM_FEE_SUMAMT ELSE 0 END) `A01`, " +
            "   SUM(CASE WHEN SELFPAY_PROP =1 and left(LIST_TYPE,1)='1' THEN DET_ITEM_FEE_SUMAMT ELSE 0 END) `A02`, " +
            "   SUM(CASE WHEN SELFPAY_PROP <>1 and left(LIST_TYPE,1) in ('2','3') and MED_CHRGITM_TYPE<>'01' THEN DET_ITEM_FEE_SUMAMT ELSE 0 END) `B01`, " +
            "   SUM(CASE WHEN SELFPAY_PROP =1 and left(LIST_TYPE,1) in ('2','3') and MED_CHRGITM_TYPE<>'01' THEN DET_ITEM_FEE_SUMAMT ELSE 0 END)  `B02`, " +
            "   SUM(CASE WHEN SELFPAY_PROP <>1 and left(LIST_TYPE,1) in ('2','3') and MED_CHRGITM_TYPE='01' THEN DET_ITEM_FEE_SUMAMT ELSE 0 END) `C01`, " +
            "   SUM(CASE WHEN SELFPAY_PROP =1 and left(LIST_TYPE,1) in ('2','3') and MED_CHRGITM_TYPE='01' THEN DET_ITEM_FEE_SUMAMT ELSE 0 END) `C02` " +
            "FROM fee_list_d " +
            "WHERE MDTRT_ID = ? " +
            "   AND SETL_ID = ? ;";

    private final JdbcTemplate jdbcTemplate;
    private final IToolsDbHelper toolsDbHelper;

    private Map<String, Q26Do> map = null;
    private boolean isRunning = false;
    private long tCount = 0L;

    private synchronized void start() {
        while(this.isRunning) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
        }
        this.isRunning = true;
        this.map = new HashMap<>();
        this.tCount = 0L;
    }

    private synchronized void stop() {
        this.isRunning = false;
        this.map = null;
        this.tCount = 0L;
    }

    private synchronized void addCount() {
        this.tCount = this.tCount + 1;
    }

    private synchronized void minusCount() {
        this.tCount = this.tCount - 1;
    }

    private synchronized void updateMap(Q26Do nd) {
        if(this.map == null) {
            return;
        }
        String k = MessageFormat.format("{0}-{1}", nd.getInsuAdmdvs(), nd.getDedcHospLv());
        if(map.containsKey(k)) {
            Q26Do d = map.get(k);
            map.put(k, d.add(nd));
        } else {
            map.put(k, nd);
        }
    }

    public Q26Rep(@Qualifier(Constant.BEAN_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate, IToolsDbHelper toolsDbHelper) {
        this.jdbcTemplate = jdbcTemplate;
        this.toolsDbHelper = toolsDbHelper;
    }

    public List<Q26Do> getList(Q26Query query) {
        this.start();
        try{
            int cpuCount = Runtime.getRuntime().availableProcessors();
            ExecutorService threadPool = Executors.newFixedThreadPool(cpuCount * 2);

            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(query.getMonth().getTime());
            cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),
                    0,0,0);
            cal.add(Calendar.MONTH, 1);
            String maxSetlTime = DateTool.GetDateTimeStr(cal.getTime());
            cal.set(Calendar.MONTH, Calendar.JANUARY);
            String minSetlTime = DateTool.GetDateTimeStr(cal.getTime());
            logger.debug(MessageFormat.format("Q26 SQL {0} {1} {2}",SQL_QUERY, minSetlTime,maxSetlTime));
            jdbcTemplate.query(SQL_QUERY, new RowCallbackHandler() {
                long c = 0L;
                @Override
                public void processRow(ResultSet rs) throws SQLException {
                    c = c +1;
                    if(c % 2000 == 0) {
                        logger.debug(String.valueOf(c) + "-" + String.valueOf(tCount));
                    }
                    String insuAdmdvs = SQLTool.getString(rs, "INSU_ADMDVS");
                    String dedcHospLv = SQLTool.getString(rs, "DEDC_HOSP_LV");
                    String mdtrtId = SQLTool.getString(rs, "MDTRT_ID");
                    String setlId = SQLTool.getString(rs,"SETL_ID");
                    addCount();
                    while(tCount > cpuCount * 3L) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException ignored) {
                        }
                    }
                    threadPool.submit(() -> {
                        toolsDbHelper.setDataSourceKey(DHConstant.DB_CONN_STR_TIDB_ONE);
                        try {
                            if (insuAdmdvs == null || dedcHospLv == null || mdtrtId == null || setlId == null) {
                                return;
                            }
                            Q26Do d = jdbcTemplate.queryForObject(SQL_QUERY_SIGNAL, new Q26SignalRowMapper(), mdtrtId, setlId);
                            if (d == null) {
                                return;
                            }
                            d.setInsuAdmdvs(insuAdmdvs);
                            d.setDedcHospLv(dedcHospLv);
                            updateMap(d);
                        }finally {
                            minusCount();
                            toolsDbHelper.remove();
                        }
                    });
                }
            }, minSetlTime, maxSetlTime);
            threadPool.shutdown();
            while(!threadPool.isTerminated()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {
                }
            }
            List<Q26Do> list = new ArrayList<>(map.values());
            Collections.sort(list);
            return list;
        }finally {
            this.stop();
        }
    }
}
