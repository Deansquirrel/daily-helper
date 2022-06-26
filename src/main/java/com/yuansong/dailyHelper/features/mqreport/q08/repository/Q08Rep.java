package com.yuansong.dailyHelper.features.mqreport.q08.repository;

import com.github.deansquirrel.tools.common.DateTool;
import com.github.deansquirrel.tools.db.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.List;

@Repository
public class Q08Rep {

    private static final Logger logger = LoggerFactory.getLogger(Q08Rep.class);

    private static final String SQL_QUERY = "" +
            "select INSU_ADMDVS, PSN_TYPE, " +
            "   sum(MEDFEE_SUMAMT) MEDFEE_SUMAMT, sum(hifp_pay) hifp_pay," +
            "   sum(other_pay) other_pay, sum(self_pay) self_pay, sum(ACCT_PAY) ACCT_PAY," +
            "   (sum(MEDFEE_SUMAMT) - sum(hifp_pay) - sum(other_pay) - sum(self_pay)) zifu," +
            "   sum(if(ACCT_PAY - self_pay > 0, ACCT_PAY - self_pay, 0)) FULAMT_OWNPAY_AMT," +
            "   count(*) T_COUNT " +
            "from ( " +
            "   select INSU_ADMDVS, " +
            "       (case " +
            "           when left(PSN_TYPE,2)='11' then '在职' " +
            "           when left(PSN_TYPE,2)='12' then '退休' " +
            "           else '在职' " +
            "       end) PSN_TYPE, " +
            "       MEDFEE_SUMAMT,hifp_pay, (CVLSERV_PAY+HIFOB_PAY) other_pay," +
            "       (OVERLMT_SELFPAY+PRESELFPAY_AMT+ACT_PAY_DEDC) 自付, " +
            "       (MEDFEE_SUMAMT-hifp_pay-CVLSERV_PAY-HIFOB_PAY-OVERLMT_SELFPAY-PRESELFPAY_AMT-ACT_PAY_DEDC) self_pay, " +
            "       FULAMT_OWNPAY_AMT ,ACCT_PAY " +
            "   from setl_d a " +
            "   where INSU_ADMDVS like '1311%' " +
            "       and setl_time >= ? " +
            "       and SETL_TIME < ? " +
            "       and VALI_FLAG='1' " +
            "       and INSUTYPE='310' " +
            "       and a.REFD_SETL_FLAG='0' " +
            "       and (" +
            "           case " +
            "               when left(FIXMEDINS_CODE,1)='P' " +
            "                   and MED_TYPE in ('14','41','9102','9103','9114','9101','9114','9113','9115','9112') " +
            "               then 1 " +
            "               else 0 " +
            "           end)='1'  " +
            ") a " +
            "group by INSU_ADMDVS, PSN_TYPE " +
            "order by INSU_ADMDVS, PSN_TYPE;";

    private final JdbcTemplate jdbcTemplate;

    public Q08Rep(@Qualifier(Constant.BEAN_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Q08Do> getList(Q08Query query) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(query.getMonth().getTime());
        cal.set(
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),
                0,0,0);
        cal.add(Calendar.MONTH, 1);
        String maxSetlTime = DateTool.GetDateTimeStr(cal.getTime());
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        String minSetlTime = DateTool.GetDateTimeStr(cal.getTime());
        logger.debug(MessageFormat.format("Q08 SQL {0} {1} {2}",SQL_QUERY, minSetlTime,maxSetlTime));
        return jdbcTemplate.query(SQL_QUERY,
                new Q08RowMapper(),
                minSetlTime,maxSetlTime);
    }

}
