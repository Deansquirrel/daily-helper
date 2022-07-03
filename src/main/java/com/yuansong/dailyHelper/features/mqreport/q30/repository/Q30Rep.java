package com.yuansong.dailyHelper.features.mqreport.q30.repository;

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
public class Q30Rep {

    private static final Logger logger = LoggerFactory.getLogger(Q30Rep.class);

    private static final String SQL_QUERY = "" +
            "select INSU_ADMDVS, PSN_TYPE, SETL_TYPE, count(DISTINCT PSN_NO) REN_SHU, count(*) REN_CI, " +
            "   sum(MEDFEE_SUMAMT) MEDFEE_SUMAMT, sum(hifp_pay) hifp_pay," +
            "   sum(other_pay) other_pay, " +
            "   sum(ziFu) zifu, sum(ziFei) zifei " +
            "from ( " +
            "   select INSU_ADMDVS, " +
            "       (case " +
            "           when left(PSN_TYPE,2)='11' then '在职' " +
            "           when left(PSN_TYPE,2)='12' then '退休' " +
            "           else '在职' " +
            "       end) PSN_TYPE, " +
            "       CASE " +
            "           WHEN substr( FIX_BLNG_ADMDVS, 1, 2 ) = '13' THEN '省内' " +
            "           WHEN substr( FIX_BLNG_ADMDVS, 1, 2 ) = '13' AND PAY_LOC <> '1' THEN '省内直接结算' " +
            "           WHEN substr( FIX_BLNG_ADMDVS, 1, 2 ) <> '13' THEN '省外' " +
            "           ELSE '其他人员' " +
            "       END SETL_TYPE, PSN_NO, " +
            "       MEDFEE_SUMAMT,hifp_pay, (CVLSERV_PAY+HIFOB_PAY) other_pay," +
            "       (MEDFEE_SUMAMT - hifp_pay - (CVLSERV_PAY+HIFOB_PAY) - FULAMT_OWNPAY_AMT) zifu, " +
            "       FULAMT_OWNPAY_AMT zifei " +
            "   from setl_d a " +
            "   where INSU_ADMDVS like '1311%' " +
            "       and setl_time >= ? " +
            "       and SETL_TIME < ? " +
            "       and VALI_FLAG='1' " +
            "       and INSUTYPE='310' " +
            "       and a.REFD_SETL_FLAG='0' " +
            "       and med_type  in ('21','13','24','23','22','92','9104','9105','9203','9202','9203','9105','9204','9104','9204','9106','9104','9202','9201','9104','9110','9106','9206','9201','9205','9109') " +
            "       and FIX_BLNG_ADMDVS NOT LIKE '1311%' " +
            ") a " +
            "group by INSU_ADMDVS, PSN_TYPE, SETL_TYPE " +
            "order by INSU_ADMDVS, PSN_TYPE, SETL_TYPE;";

    private final JdbcTemplate jdbcTemplate;

    public Q30Rep(@Qualifier(Constant.BEAN_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Q30Do> getList(Q30Query query) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(query.getMonth().getTime());
        cal.set(
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),
                0,0,0);
        cal.add(Calendar.MONTH, 1);
        String maxSetlTime = DateTool.GetDateTimeStr(cal.getTime());
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        String minSetlTime = DateTool.GetDateTimeStr(cal.getTime());
        logger.debug(MessageFormat.format("Q30 SQL {0} {1} {2}",SQL_QUERY, minSetlTime,maxSetlTime));
        return jdbcTemplate.query(SQL_QUERY,
                new Q30RowMapper(),
                minSetlTime,maxSetlTime);
    }

}
