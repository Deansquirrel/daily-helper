package com.yuansong.dailyHelper.features.mqreport.q26.repository;

import com.github.deansquirrel.tools.common.DateTool;
import com.github.deansquirrel.tools.common.ExceptionTool;
import com.github.deansquirrel.tools.common.SQLTool;
import com.github.deansquirrel.tools.db.Constant;
import com.github.deansquirrel.tools.db.IToolsDbHelper;
import com.yuansong.dailyHelper.global.DHConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

@Repository
public class Q26Rep {

    private static final Logger logger = LoggerFactory.getLogger(Q26Rep.class);

    private final IToolsDbHelper iToolsDbHelper;

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
            "SELECT MDTRT_ID, SETL_ID," +
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

    public Q26Rep(IToolsDbHelper iToolsDbHelper, @Qualifier(Constant.BEAN_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.iToolsDbHelper = iToolsDbHelper;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Q26Do> getList(Q26Query query) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(query.getMonth().getTime());
        cal.set(
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),
                0,0,0);
        cal.add(Calendar.MONTH, 1);
        String maxSetlTime = DateTool.GetDateTimeStr(cal.getTime());
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        String minSetlTime = DateTool.GetDateTimeStr(cal.getTime());
        logger.debug(MessageFormat.format("Q26 SQL {0} {1} {2}",SQL_QUERY, minSetlTime,maxSetlTime));
        //最大线程数量
        int maxThreads =Runtime.getRuntime().availableProcessors() * 4;
        //结果数据
        Map<String, Q26Do> map = new HashMap<>();
        //缓冲队列
        BlockingQueue<Q26DetailQueryInfo> queue = new ArrayBlockingQueue<>(maxThreads * 2);
        //线程池
        ThreadPoolTaskExecutor pool = getPool(maxThreads);
        //消费线程
        Thread handleThread = new Thread(()->{
            while(true) {
                if(!queue.isEmpty() && pool.getActiveCount() < maxThreads) {
                    pool.execute(()->{
                        try {
                            handleInfo(queue.take(), map);
                        } catch (InterruptedException ignored) {
                        }
                    });
                }

                if(Thread.currentThread().isInterrupted()) {
                    logger.debug("消费线程退出");
                    return;
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ignored) {
                }
            }
        });
        //启动消费线程
        handleThread.start();

        jdbcTemplate.query(SQL_QUERY, new RowCallbackHandler() {
            long c = 0L;
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                c = c + 1;
                if(c % 2000 == 0) {
                    logger.debug(MessageFormat.format("Q26 RowCallbackHandler {0}", c));
                }
                Q26DetailQueryInfo info = new Q26DetailQueryInfo();
                info.mdtrtId = SQLTool.getString(rs, "MDTRT_ID");
                info.setlId = SQLTool.getString(rs,"SETL_ID");
                info.insuAdmdvs = SQLTool.getString(rs, "INSU_ADMDVS");
                info.dedcHospLv = SQLTool.getString(rs, "DEDC_HOSP_LV");
                try {
                    queue.put(info);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, minSetlTime, maxSetlTime);
        logger.debug("processRow over");
        //等待线程执行完成
        while(pool.getActiveCount() > 0 || !queue.isEmpty()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ignored) {
            }
        }
        //停止消费线程
        handleThread.interrupt();
        //关闭线程池
        pool.shutdown();
        //等待线程池关闭
        while(!pool.getThreadPoolExecutor().isTerminated()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ignored) {
            }
        }
        //返回数据
        List<Q26Do> list = new ArrayList<>(map.values());
        Collections.sort(list);
        return list;
    }
    private void handleInfo(Q26DetailQueryInfo info, Map<String, Q26Do> map) {
        if(info == null || map == null) {
            return;
        }
        while(true) {
            try{
                Q26Do nd = getCurr(info.mdtrtId, info.setlId);
                if(nd == null) {
                    return;
                }
                String k = MessageFormat.format("{0}-{1}",
                        info.insuAdmdvs, info.dedcHospLv);
                synchronized (map){
                    if(map.containsKey(k)) {
                        map.put(k, map.get(k).add(nd));
                    } else {
                        nd.setInsuAdmdvs(info.insuAdmdvs);
                        nd.setDedcHospLv(info.dedcHospLv);
                        map.put(k, nd);
                    }
                }
                return;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
            }
            try {
                Thread.sleep(60000);
            } catch (InterruptedException ignored) {
            }
        }
    }

    private Q26Do getCurr(String mdtrtId, String setlId) {
        if(mdtrtId == null || setlId == null || "".equals(mdtrtId) || "".equals(setlId)) {
            return null;
        }
        iToolsDbHelper.setDataSourceKey(DHConstant.DB_CONN_STR_TIDB_ONE);
        try{
            return jdbcTemplate.queryForObject(SQL_QUERY_SIGNAL, new Q26SignalRowMapper(), mdtrtId, setlId);
        } finally {
            iToolsDbHelper.remove();
        }
    }

    private ThreadPoolTaskExecutor getPool(int count) {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        pool.setCorePoolSize(count);
        pool.setMaxPoolSize(count);
        pool.setQueueCapacity(count);
        pool.setKeepAliveSeconds(10);
        pool.setThreadNamePrefix("Q26RowDataHandler-");
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        pool.initialize();
        pool.setAllowCoreThreadTimeOut(true);
        pool.setKeepAliveSeconds(30);
        return pool;
    }

    private static class Q26DetailQueryInfo {
        private String mdtrtId;
        private String setlId;
        private String insuAdmdvs;
        private String dedcHospLv;

    }

}
