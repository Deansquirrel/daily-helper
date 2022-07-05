package com.yuansong.dailyHelper.features.mqreport.q23.repository;

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
public class Q23Rep {

    private static final Logger logger = LoggerFactory.getLogger(Q23Rep.class);

    private static final String SQL_QUERY = "" +
            "select INSU_ADMDVS, DEDC_HOSP_LV, " +
            "   sum(MEDFEE_SUMAMT) MEDFEE_SUMAMT, sum(hifp_pay) hifp_pay," +
            "   sum(other_pay) other_pay, sum(ACCT_PAY) ACCT_PAY," +
            "   sum(ziFu) zifu, sum(ziFei) zifei, " +
            "   sum(if(ACCT_PAY - zifu > 0, ACCT_PAY - zifu, 0)) muluwai," +
            "   count(*) T_COUNT " +
            "from ( " +
            "   select INSU_ADMDVS, " +
            "       (case " +
            "           when DEDC_HOSP_LV in ('1','2','3','9') then DEDC_HOSP_LV " +
            "           else '3' " +
            "       end) DEDC_HOSP_LV, " +
            "       MEDFEE_SUMAMT,hifp_pay, (HIFMI_PAY+MAF_PAY) other_pay," +
            "       (MEDFEE_SUMAMT - hifp_pay - (HIFMI_PAY+MAF_PAY) - FULAMT_OWNPAY_AMT) zifu, " +
            "       FULAMT_OWNPAY_AMT zifei,ACCT_PAY " +
            "   from setl_d a " +
            "   where INSU_ADMDVS like '1311%' " +
            "       and setl_time >= ? " +
            "       and SETL_TIME < ? " +
            "       and VALI_FLAG='1' " +
            "       and INSUTYPE='390' " +
            "       and a.REFD_SETL_FLAG='0' " +
            "       and med_type  in ('51','12','11') " +
            ") a " +
            "group by INSU_ADMDVS, DEDC_HOSP_LV " +
            "order by INSU_ADMDVS, DEDC_HOSP_LV;";

    private final JdbcTemplate jdbcTemplate;

    public Q23Rep(@Qualifier(Constant.BEAN_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Q23Do> getList(Q23Query query) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(query.getMonth().getTime());
        cal.set(
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),
                0,0,0);
        cal.add(Calendar.MONTH, 1);
        String maxSetlTime = DateTool.GetDateTimeStr(cal.getTime());
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        String minSetlTime = DateTool.GetDateTimeStr(cal.getTime());
        logger.debug(MessageFormat.format("Q23 SQL {0} {1} {2}",SQL_QUERY, minSetlTime,maxSetlTime));
        return jdbcTemplate.query(SQL_QUERY,
                new Q23RowMapper(),
                minSetlTime,maxSetlTime);
    }

}
