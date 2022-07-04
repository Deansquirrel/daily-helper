package com.yuansong.dailyHelper.features.mqreport.q38.repository;

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
public class Q38Rep {

    private static final Logger logger = LoggerFactory.getLogger(Q38Rep.class);

    private static final String SQL_QUERY = "" +
            "SELECT INSU_ADMDVS, EMP_TYPE, COUNT(DISTINCT PSN_NO) T_COUNT " +
            "FROM ( " +
            "   SELECT a.INSU_ADMDVS, " +
            "       CASE " +
            "           WHEN d.EMP_TYPE IN ('10','99','9008') THEN '企业' " +
            "           WHEN d.EMP_TYPE IN ('50','55','56','57','70','9001','9002','9003','9004','9005','91','82','90','9009') THEN '事业' " +
            "           WHEN d.EMP_TYPE IN ('30') THEN '机关' " +
            "           WHEN d.EMP_TYPE IN ('80','81','9006','9007','9901','9939') THEN '其他' " +
            "           ELSE '企业' " +
            "       END EMP_TYPE, a.PSN_NO " +
            "   FROM setl_d a " +
            "   LEFT JOIN mdtrt_d b ON a.MDTRT_ID = b.MDTRT_ID AND a.PSN_NO = b.PSN_NO " +
            "   LEFT JOIN insu_emp_info_b d ON b.EMP_NO = d.EMP_NO " +
            "   WHERE 1=1 " +
            "       AND a.SETL_TIME >= ? " +
            "       AND a.SETL_TIME < ? " +
            "       AND a.VALI_FLAG = '1' " +
            "       AND a.REFD_SETL_FLAG = '0' " +
            "       AND a.HIFOB_PAY <> 0 " +
            "       AND a.INSU_ADMDVS LIKE '1311%' " +
            "       AND (a.FIXMEDINS_CODE LIKE 'H1311%' OR a.FIXMEDINS_CODE LIKE 'P1311%') " +
            ") a " +
            "GROUP BY INSU_ADMDVS, EMP_TYPE " +
            "ORDER BY INSU_ADMDVS, EMP_TYPE;";

    private final JdbcTemplate jdbcTemplate;

    public Q38Rep(@Qualifier(Constant.BEAN_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Q38Do> getList(Q38Query query) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(query.getMonth().getTime());
        cal.set(
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),
                0,0,0);
        cal.add(Calendar.MONTH, 1);
        String maxSetlTime = DateTool.GetDateStr(cal.getTime());
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        String minSetlTime = DateTool.GetDateStr(cal.getTime());

        logger.debug(MessageFormat.format("Q38 SQL {0} {1} {2}",SQL_QUERY, minSetlTime,maxSetlTime));
        return jdbcTemplate.query(SQL_QUERY,
                new Q38RowMapper(),
                minSetlTime,maxSetlTime);
    }

}
