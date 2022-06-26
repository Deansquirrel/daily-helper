package com.yuansong.dailyHelper.features.mqreport.q12.repository;

import com.github.deansquirrel.tools.common.DateTool;
import com.github.deansquirrel.tools.common.SQLTool;
import com.github.deansquirrel.tools.db.Constant;
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

@Repository
public class Q12Rep {

    private static final Logger logger = LoggerFactory.getLogger(Q12Rep.class);

    private static final String SQL_QUERY = "" +
            "SELECT INSU_ADMDVS,(" +
            "   case " +
            "       when left(PSN_TYPE,2)='11' then '在职' " +
            "       when left(PSN_TYPE,2)='12' then '退休' " +
            "       else '在职' " +
            "   end) PSN_TYPE, MDTRT_ID, SETL_ID " +
            "FROM setl_d " +
            "WHERE INSU_ADMDVS LIKE '1311%'  " +
            "   and SETL_TIME >= ? " +
            "   and SETL_TIME < ? " +
            "   AND VALI_FLAG = '1' " +
            "   AND INSUTYPE = '310' " +
            "   AND REFD_SETL_FLAG = '0' " +
            "   AND MED_TYPE IN ('52','21','13','24','23','22','92','9104','9105','9203','9202','9203','9105','9204','9104','9204','9106','9104','9202','9201','9104','9110','9106','9206','9201','9205','9109') " +
            "ORDER BY INSU_ADMDVS,(" +
            "   case " +
            "       when left(PSN_TYPE,2)='11' then '在职'" +
            "       when left(PSN_TYPE,2)='12' then '退休'" +
            "       else '在职' " +
            "   end) ;";
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

    public Q12Rep(@Qualifier(Constant.BEAN_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Q12Do> getList(Q12Query query) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(query.getMonth().getTime());
        cal.set(
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),
                0,0,0);
        cal.add(Calendar.MONTH, 1);
        String maxSetlTime = DateTool.GetDateTimeStr(cal.getTime());
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        String minSetlTime = DateTool.GetDateTimeStr(cal.getTime());
        logger.debug(MessageFormat.format("Q12 SQL {0} {1} {2}",SQL_QUERY, minSetlTime,maxSetlTime));
        Map<String, Q12Do> map = new HashMap<>();
        jdbcTemplate.query(SQL_QUERY, new RowCallbackHandler() {
            Q12Do nd = null;
            long c = 0L;
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                if(c % 100 == 0) {
                    logger.debug(MessageFormat.format("Q12 RowCallbackHandler {}", c));
                }
                c = c + 1;
                nd = getCurr(SQLTool.getString(rs, "MDTRT_ID"),
                        SQLTool.getString(rs,"SETL_ID"));
                if(nd == null) {
                    return;
                }
                nd.setInsuAdmdvs(SQLTool.getString(rs, "INSU_ADMDVS"));
                nd.setPsnType(SQLTool.getString(rs, "PSN_TYPE"));
                String k = MessageFormat.format("{0}-{1}",nd.getInsuAdmdvs(),nd.getPsnType());
                if(map.containsKey(k)) {
                    Q12Do d = map.get(k);
                    map.put(k, d.add(nd));
                } else {
                    map.put(k, nd);
                }
            }
        }, minSetlTime, maxSetlTime);
        return new ArrayList<>(map.values());
    }

    private Q12Do getCurr(String mdtrtId, String setlId) {
        if(mdtrtId == null || setlId == null || "".equals(mdtrtId) || "".equals(setlId)) {
            return null;
        }
        return jdbcTemplate.queryForObject(SQL_QUERY_SIGNAL, new Q12SignalRowMapper(), mdtrtId, setlId);
    }

}
