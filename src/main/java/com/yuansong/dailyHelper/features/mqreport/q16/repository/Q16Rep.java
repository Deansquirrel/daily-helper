package com.yuansong.dailyHelper.features.mqreport.q16.repository;

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
public class Q16Rep {

    private static final Logger logger = LoggerFactory.getLogger(Q16Rep.class);

    private static final String SQL_QUERY = "" +
            "select INSU_ADMDVS, " +
            "   sum(MEDFEE_SUMAMT) MEDFEE_SUMAMT, sum(hifp_pay) hifp_pay, sum(HIFMI_PAY) HIFMI_PAY, " +
            "   sum(other_pay) other_pay, sum(ACCT_PAY) ACCT_PAY," +
            "   sum(ziFu) zifu, sum(ziFei) zifei, " +
            "   sum(if(ACCT_PAY - zifu > 0, ACCT_PAY - zifu, 0)) muluwai," +
            "   count(*) T_COUNT " +
            "from ( " +
            "   select INSU_ADMDVS, " +
            "       MEDFEE_SUMAMT,hifp_pay,HIFMI_PAY, (CVLSERV_PAY+HIFOB_PAY) other_pay," +
            "       (MEDFEE_SUMAMT - hifp_pay - (CVLSERV_PAY+HIFOB_PAY) - FULAMT_OWNPAY_AMT) zifu, " +
            "       FULAMT_OWNPAY_AMT zifei,ACCT_PAY " +
            "   from setl_d a " +
            "   where INSU_ADMDVS like '1311%' " +
            "       and setl_time >= ? " +
            "       and SETL_TIME < ? " +
            "       and VALI_FLAG='1' " +
            "       and INSUTYPE='390' " +
            "       and a.REFD_SETL_FLAG='0' " +
            "       and med_type  in ('14') " +
            "       and MAF_PAY <> 0  " +
            ") a " +
            "group by INSU_ADMDVS " +
            "order by INSU_ADMDVS ;";

    private final JdbcTemplate jdbcTemplate;

    public Q16Rep(@Qualifier(Constant.BEAN_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Q16Do> getList(Q16Query query) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(query.getMonth().getTime());
        cal.set(
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),
                0,0,0);
        cal.add(Calendar.MONTH, 1);
        String maxSetlTime = DateTool.GetDateTimeStr(cal.getTime());
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        String minSetlTime = DateTool.GetDateTimeStr(cal.getTime());
        logger.debug(MessageFormat.format("Q16 SQL {0} {1} {2}",SQL_QUERY, minSetlTime,maxSetlTime));
        return jdbcTemplate.query(SQL_QUERY,
                new Q16RowMapper(),
                minSetlTime,maxSetlTime);
    }

}