package com.yuansong.dailyHelper.features.mqreport.q39.repository;

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
public class Q39Rep {

    private static final Logger logger = LoggerFactory.getLogger(Q39Rep.class);

    private static final String SQL_QUERY = "" +
            "select INSUTYPE, INSU_ADMDVS, EMP_TYPE, count(DISTINCT PSN_NO) T_COUNT " +
            "from ( " +
            "   select r.INSUTYPE, p.INSU_ADMDVS, " +
            "   CASE " +
            "       WHEN d.EMP_TYPE IN ('10','99','9008') THEN '企业' " +
            "       WHEN d.EMP_TYPE IN ('50','55','56','57','70','9001','9002','9003','9004','9005','91','82','90','9009') THEN '事业' " +
            "       WHEN d.EMP_TYPE IN ('30') THEN '机关' " +
            "       WHEN d.EMP_TYPE IN ('80','81','9006','9007','9901','9939') THEN '其他' " +
            "       ELSE '企业' " +
            "   END EMP_TYPE, r.PSN_NO " +
            "   from staf_psn_clct_detl_d r " +
            "   LEFT JOIN psn_insu_d p ON r.PSN_NO = p.PSN_NO " +
            "   left join insu_emp_info_b d on r.EMP_NO = d.EMP_NO " +
            "   where r.INSUTYPE in ('330','320') " +
            "       and ACCRYM_END >= ? " +
            "       and ACCRYM_END < ? " +
            "       AND p.INSUTYPE IN ('320') " +
            "       AND p.INSU_ADMDVS LIKE '1311%' " +
            "       and p.INSU_ADMDVS = '131199' " +
            "       and r.CLCT_TYPE = 10 and r.CLCT_FLAG = 1 " +
            ") a " +
            "group by INSUTYPE, INSU_ADMDVS, EMP_TYPE " +
            "order by INSUTYPE, INSU_ADMDVS, EMP_TYPE;";

    private final JdbcTemplate jdbcTemplate;

    public Q39Rep(@Qualifier(Constant.BEAN_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Q39Do> getList(Q39Query query) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(query.getMonth().getTime());
        cal.add(Calendar.MONTH, 1);
        String maxAccrymEnd = DateTool.GetStr(cal.getTime(), "yyyyMM");
        cal.set(Calendar.MONTH,Calendar.JANUARY);
        String minAccrymEnd = DateTool.GetStr(cal.getTime(), "yyyyMM");
        logger.debug(MessageFormat.format("Q39 SQL {0} {1} {2}",SQL_QUERY, minAccrymEnd,maxAccrymEnd));
        return jdbcTemplate.query(SQL_QUERY,
                new Q39RowMapper(),
                minAccrymEnd,maxAccrymEnd);
    }

}
