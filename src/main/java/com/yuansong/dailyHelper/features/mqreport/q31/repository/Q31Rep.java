package com.yuansong.dailyHelper.features.mqreport.q31.repository;

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
public class Q31Rep {

    private static final Logger logger = LoggerFactory.getLogger(Q31Rep.class);

    private static final String SQL_QUERY = "" +
            "select INSU_ADMDVS, SETL_TYPE, count(DISTINCT PSN_NO) REN_SHU, count(*) REN_CI, " +
            "   sum(MEDFEE_SUMAMT) MEDFEE_SUMAMT, sum(hifp_pay) hifp_pay," +
            "   sum(other_pay) other_pay, " +
            "   sum(ziFu) zifu, sum(ziFei) zifei " +
            "from ( " +
            "   select INSU_ADMDVS, " +
            "       CASE " +
            "           WHEN substr( FIX_BLNG_ADMDVS, 1, 2 ) = '13' THEN '省内' " +
            "           WHEN substr( FIX_BLNG_ADMDVS, 1, 2 ) <> '13' THEN '省外' " +
            "           ELSE '其他人员' " +
            "       END SETL_TYPE, PSN_NO, " +
            "       MEDFEE_SUMAMT,hifp_pay, (HIFMI_PAY+MAF_PAY) other_pay," +
            "       (MEDFEE_SUMAMT - hifp_pay - (HIFMI_PAY+MAF_PAY) - FULAMT_OWNPAY_AMT) zifu, " +
            "       FULAMT_OWNPAY_AMT zifei " +
            "   from setl_d a " +
            "   where INSU_ADMDVS like '1311%' " +
            "       and setl_time >= ? " +
            "       and SETL_TIME < ? " +
            "       and VALI_FLAG='1' " +
            "       and INSUTYPE='390' " +
            "       and a.REFD_SETL_FLAG='0' " +
            "       and med_type  in ('11') " +
            "       and FIX_BLNG_ADMDVS NOT LIKE '1311%' " +
            "   UNION ALL " +
            "   select INSU_ADMDVS, '省内直接结算' SETL_TYPE, PSN_NO, " +
            "       MEDFEE_SUMAMT,hifp_pay, (HIFMI_PAY+MAF_PAY) other_pay," +
            "       (MEDFEE_SUMAMT - hifp_pay - (HIFMI_PAY+MAF_PAY) - FULAMT_OWNPAY_AMT) zifu, " +
            "       FULAMT_OWNPAY_AMT zifei " +
            "   from setl_d a " +
            "   where INSU_ADMDVS like '1311%' " +
            "       and setl_time >= ? " +
            "       and SETL_TIME < ? " +
            "       and VALI_FLAG='1' " +
            "       and INSUTYPE='390' " +
            "       and a.REFD_SETL_FLAG='0' " +
            "       and med_type  in ('11') " +
            "       and FIX_BLNG_ADMDVS NOT LIKE '1311%' " +
            "       AND substr( FIX_BLNG_ADMDVS, 1, 2 ) = '13' AND PAY_LOC <> '1' " +
            ") a " +
            "group by INSU_ADMDVS, SETL_TYPE " +
            "order by INSU_ADMDVS, SETL_TYPE;";

    private final JdbcTemplate jdbcTemplate;

    public Q31Rep(@Qualifier(Constant.BEAN_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Q31Do> getList(Q31Query query) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(query.getMonth().getTime());
        cal.set(
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),
                0,0,0);
        cal.add(Calendar.MONTH, 1);
        String maxSetlTime = DateTool.GetDateTimeStr(cal.getTime());
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        String minSetlTime = DateTool.GetDateTimeStr(cal.getTime());
        logger.debug(MessageFormat.format("Q31 SQL {0} {1} {2}",SQL_QUERY, minSetlTime,maxSetlTime));
        return jdbcTemplate.query(SQL_QUERY,
                new Q31RowMapper(),
                minSetlTime,maxSetlTime,minSetlTime,maxSetlTime);
    }

}
