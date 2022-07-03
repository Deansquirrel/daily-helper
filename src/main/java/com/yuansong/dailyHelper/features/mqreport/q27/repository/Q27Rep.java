package com.yuansong.dailyHelper.features.mqreport.q27.repository;

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
public class Q27Rep {

    private static final Logger logger = LoggerFactory.getLogger(Q27Rep.class);

    private static final String SQL_QUERY = "" +
            "SELECT INSU_ADMDVS, DISE_TYPE, count(DISTINCT PSN_NO) REN_SHU, count(*) REN_CI, " +
            "   sum(MEDFEE_SUMAMT) MEDFEE_SUMAMT,sum(hifp_pay) hifp_pay, sum(HIFMI_PAY) HIFMI_PAY, sum(MAF_PAY) other_pay, " +
            "   SUM(ziFu) zifu,SUM(ziFei) zifei " +
            "FROM ( " +
            "   SELECT INSU_ADMDVS, " +
            "       CASE " +
            "           when DISE_NO = 'HBLB101' then '两病-高血压' " +
            "           when DISE_NO = 'HBLB201' then '两病-糖尿病' " +
            "           when DISE_NO in ('M01600','M01603') then '慢病-糖尿病' " +
            "           when DISE_NO in ('M03900','M03902') then '慢病-高血压' " +
            "           else '' " +
            "       end DISE_TYPE, PSN_NO, " +
            "       MEDFEE_SUMAMT ,hifp_pay , HIFMI_PAY , MAF_PAY , FULAMT_OWNPAY_AMT ziFei, " +
            "       (MEDFEE_SUMAMT - hifp_pay - (MAF_PAY) - FULAMT_OWNPAY_AMT) ziFu " +
            "   from setl_d " +
            "   where MED_TYPE = '14' " +
            "       and INSUTYPE = '390' " +
            "       and SETL_TIME >= ? " +
            "       and SETL_TIME < ? " +
            "       and INSU_ADMDVS like '1311%' " +
            "       and DISE_NO IN ( 'HBLB101', 'HBLB201' ,'M03900', 'M01600','M03902','M01603') " +
            "       AND VALI_FLAG = '1' " +
            "       AND REFD_SETL_FLAG = '0' " +
            ") A " +
            "GROUP BY INSU_ADMDVS,DISE_TYPE " +
            "ORDER BY INSU_ADMDVS,DISE_TYPE;";

    private final JdbcTemplate jdbcTemplate;

    public Q27Rep(@Qualifier(Constant.BEAN_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Q27Do> getList(Q27Query query) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(query.getMonth().getTime());
        cal.set(
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),
                0,0,0);
        cal.add(Calendar.MONTH, 1);
        String maxSetlTime = DateTool.GetDateTimeStr(cal.getTime());
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        String minSetlTime = DateTool.GetDateTimeStr(cal.getTime());
        logger.debug(MessageFormat.format("Q27 SQL {0} {1} {2}",SQL_QUERY, minSetlTime,maxSetlTime));
        return jdbcTemplate.query(SQL_QUERY,
                new Q27RowMapper(),
                minSetlTime,maxSetlTime);
    }

}
