package com.yuansong.dailyHelper.features.mqreport.q01.repository;

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
public class Q01Rep {

    private static final Logger logger = LoggerFactory.getLogger(Q01Rep.class);

    private static final String SQL_QUERY = "" +
            "SELECT a.insu_admdvs, " +
            "   CASE " +
            "       WHEN a.EMP_TYPE IN ('10','99','9008') THEN '企业' " +
            "       WHEN a.EMP_TYPE IN ('50','55','56','57','70','9001','9002','9003','9004','9005','91','82','90','9009') THEN '事业' " +
            "       WHEN a.EMP_TYPE IN ('30') THEN '机关' " +
            "       WHEN a.EMP_TYPE IN ('80','81','9006','9007','9901','9939') THEN '其他' " +
            "       ELSE '企业' " +
            "   END EMP_TYPE, count( DISTINCT a.EMP_NO ) EMP_COUNT, count(*) PSN_COUNT, " +
            "   sum( CASE WHEN INSUTYPE_RETR_FLAG = '1' THEN 1 ELSE 0 END ) RETR_COUNT, " +
            "   sum( CASE WHEN INSUTYPE_RETR_FLAG = '1' AND gend = 2 THEN 1 ELSE 0 END ) RETR_FEMALE_COUNT, " +
            "   sum( CASE WHEN gend = 2 THEN 1 ELSE 0 END ) FEMALE_COUNT " +
            "FROM insu_emp_info_b a, psn_info_b b, psn_insu_d c " +
            "WHERE a.EMP_NO = c.EMP_NO " +
            "   AND b.psn_no = c.psn_no " +
            "   AND c.INSUTYPE = '310' " +
            "   AND c.PSN_INSU_STAS IN (1) " +
            "   AND a.insu_admdvs LIKE '1311%' " +
            "   AND EXISTS ( " +
            "       SELECT 1 " +
            "       FROM staf_psn_clct_detl_d d FORCE INDEX (psn_no) " +
            "       WHERE c.psn_no = d.psn_no " +
            "           AND d.insutype = '310' " +
            "           AND d.clct_flag = '1' " +
            "           AND d.REVS_FLAG = 'Z' " +
            "           AND d.CLCT_TYPE = 10 " +
            "           AND CLCT_TIME < ? " +
            "           AND d.ACCRYM_END >= ? " +
            "   ) " +
            "GROUP BY a.insu_admdvs, " +
            "   CASE " +
            "       WHEN a.EMP_TYPE IN ('10','99','9008') THEN '企业' " +
            "       WHEN a.EMP_TYPE IN ('50','55','56','57','70','9001','9002','9003','9004','9005','91','82','90','9009') THEN '事业' " +
            "       WHEN a.EMP_TYPE IN ('30') THEN '机关' " +
            "       WHEN a.EMP_TYPE IN ('80','81','9006','9007','9901','9939') THEN '其他' " +
            "       ELSE '企业' " +
            "   END " +
            "order by a.insu_admdvs, " +
            "   CASE " +
            "       WHEN a.EMP_TYPE IN ('10','99','9008') THEN '企业' " +
            "       WHEN a.EMP_TYPE IN ('50','55','56','57','70','9001','9002','9003','9004','9005','91','82','90','9009') THEN '事业' " +
            "       WHEN a.EMP_TYPE IN ('30') THEN '机关' " +
            "       WHEN a.EMP_TYPE IN ('80','81','9006','9007','9901','9939') THEN '其他' " +
            "       ELSE '企业' " +
            "   END;";

    private final JdbcTemplate jdbcTemplate;

    public Q01Rep(@Qualifier(Constant.BEAN_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Q01Do> getList(Q01Query query) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(query.getMonth().getTime());
        cal.add(Calendar.MONTH, 1);
        String clctTime = DateTool.GetDateStr(cal.getTime());
        cal.add(Calendar.MONTH,-6);
        String accrymEnd = DateTool.GetStr(cal.getTime(), "yyyyMM");
        logger.debug(MessageFormat.format("Q01 SQL {0} {1} {2}",SQL_QUERY, clctTime,accrymEnd));
        return jdbcTemplate.query(SQL_QUERY,
                new Q01RowMapper(),
                clctTime,accrymEnd);
    }

}
