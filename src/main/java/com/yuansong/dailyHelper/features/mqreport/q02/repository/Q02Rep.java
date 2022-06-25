package com.yuansong.dailyHelper.features.mqreport.q02.repository;

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
public class Q02Rep {

    private static final Logger logger = LoggerFactory.getLogger(Q02Rep.class);

    private static final String SQL_QUERY = "" +
            "select INSU_ADMDVS ,EMP_TYPE , " +
            "   sum(EMP_CLCTSTD) EMP_CLCTSTD, sum(PSN_CLCTSTD) PSN_CLCTSTD, " +
            "   sum(EMP_CLCT_AMT) EMP_CLCT_AMT, sum(PSN_CLCT_AMT) PSN_CLCT_AMT, " +
            "   sum(EMP_CLCT_INTO_ACCT_AMT) EMP_CLCT_INTO_ACCT_AMT, " +
            "   sum(EMP_CLCT_INTO_RETR_ACCT_AMT) EMP_CLCT_INTO_RETR_ACCT_AMT " +
            "FROM ( " +
            "   select b.INSU_ADMDVS INSU_ADMDVS, " +
            "       CASE " +
            "           WHEN b.EMP_TYPE IN ('10','99','9008') THEN '企业' " +
            "           WHEN b.EMP_TYPE IN ('50','55','56','57','70','9001','9002','9003','9004','9005','91','82','90','9009') THEN '事业' " +
            "           WHEN b.EMP_TYPE IN ('30') THEN '机关' " +
            "           WHEN b.EMP_TYPE IN ('80','81','9006','9007','9901','9939') THEN '其他' " +
            "           ELSE '企业' " +
            "       END EMP_TYPE, " +
            "       EMP_CLCTSTD, PSN_CLCTSTD, EMP_CLCT_AMT, PSN_CLCT_AMT, EMP_CLCT_INTO_ACCT_AMT, " +
            "       (case when INSUTYPE_RETR_FLAG='1' then EMP_CLCT_INTO_ACCT_AMT else 0 end) EMP_CLCT_INTO_RETR_ACCT_AMT " +
            "   from staf_psn_clct_detl_d a,insu_emp_info_b b " +
            "   where insutype='310' " +
            "       and revs_flag='Z' " +
            "       and clct_flag='1' " +
            "       and (CLCT_TIME >= ? and CLCT_TIME < ?) " +
            "       and a.EMP_NO=b.EMP_NO " +
            "       and b.INSU_ADMDVS like '1311%' " +
            ") a " +
            "group by INSU_ADMDVS,EMP_TYPE " +
            "order by INSU_ADMDVS,EMP_TYPE;";

    private final JdbcTemplate jdbcTemplate;

    public Q02Rep(@Qualifier(Constant.BEAN_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Q02Do> getList(Q02Query query) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(query.getMonth().getTime());
        cal.set(
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),
                0,0,0);
        cal.add(Calendar.MONTH, 1);
        String maxClctTime = DateTool.GetDateTimeStr(cal.getTime());
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        String minClctTime = DateTool.GetDateTimeStr(cal.getTime());
        logger.debug(MessageFormat.format("Q02 SQL {0} {1} {2}",SQL_QUERY, minClctTime,maxClctTime));
        return jdbcTemplate.query(SQL_QUERY,
                new Q02RowMapper(),
                minClctTime,maxClctTime);
    }

}
