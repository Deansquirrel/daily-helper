package com.yuansong.dailyHelper.features.mqreport.q40.repository;

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
public class Q40Rep {

    private static final Logger logger = LoggerFactory.getLogger(Q40Rep.class);

    private static final String SQL_QUERY = "" +
            "SELECT INSU_ADMDVS, EMP_TYPE, count( DISTINCT a.EMP_NO ) EMP_COUNT,count(*) PSN_COUNT " +
            "FROM ( " +
            "   SELECT b.INSU_ADMDVS, " +
            "       CASE " +
            "           WHEN b.EMP_TYPE IN ('10','99','9008') THEN '企业' " +
            "           WHEN b.EMP_TYPE IN ('50','55','56','57','70','9001','9002','9003','9004','9005','91','82','90','9009') THEN '事业' " +
            "           WHEN b.EMP_TYPE IN ('30') THEN '机关' " +
            "           WHEN b.EMP_TYPE IN ('80','81','9006','9007','9901','9939') THEN '其他' " +
            "           ELSE '企业' " +
            "       END EMP_TYPE, a.EMP_NO, a.PSN_NO " +
            "   FROM staf_psn_clct_detl_d a,insu_emp_info_b b,psn_info_b c " +
            "   where INSUTYPE='330' " +
            "       and b.INSU_ADMDVS like '1311%' " +
            "       and ACCRYM_BEGN>= ? " +
            "       and ACCRYM_BEGN<= ? " +
            "       and clct_flag='1' " +
            "       and REVS_FLAG='Z' " +
            "       and CLCT_TIME < ? " +
            "       and a.EMP_NO=b.EMP_NO " +
            "       and a.PSN_NO=c.PSN_NO " +
            ") a " +
            "GROUP BY INSU_ADMDVS, EMP_TYPE " +
            "ORDER BY INSU_ADMDVS, EMP_TYPE;";

    private final JdbcTemplate jdbcTemplate;

    public Q40Rep(@Qualifier(Constant.BEAN_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Q40Do> getList(Q40Query query) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(query.getMonth().getTime());
        cal.add(Calendar.MONTH, 1);
        String clctTime = DateTool.GetDateTimeStr(cal.getTime());
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        String minAccrymBegn = DateTool.GetStr(cal.getTime(), "yyyyMM");
        cal.set(Calendar.MONTH, Calendar.DECEMBER);
        String maxAccrymBegn = DateTool.GetStr(cal.getTime(), "yyyyMM");
        logger.debug(MessageFormat.format("Q40 SQL {0} {1} {2} {3}",SQL_QUERY, minAccrymBegn,maxAccrymBegn,clctTime));
        return jdbcTemplate.query(SQL_QUERY,
                new Q40RowMapper(),
                minAccrymBegn,maxAccrymBegn,clctTime);
    }

}
