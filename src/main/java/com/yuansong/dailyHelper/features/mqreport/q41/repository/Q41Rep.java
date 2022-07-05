package com.yuansong.dailyHelper.features.mqreport.q41.repository;

import com.github.deansquirrel.tools.common.DateTool;
import com.github.deansquirrel.tools.db.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.mail.Message;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Repository
public class Q41Rep {

    private static final Logger logger = LoggerFactory.getLogger(Q41Rep.class);
    private static final String SQL_QUERY = "";
    private static final String SQL_QUERY_A = "" +
            "SELECT '居民普通门诊' MED_TYPE, INSU_ADMDVS, count(distinct PSN_NO) PSN_COUNT " +
            "FROM setl_d a " +
            "WHERE LEFT(insu_admdvs,4) = '1311' " +
            "   AND SETL_TIME >= ? " +
            "   AND SETL_TIME < ? " +
            "   AND VALI_FLAG = '1' " +
            "   AND INSUTYPE = '390' " +
            "   AND a.REFD_SETL_FLAG = '0' " +
            "   AND med_type IN ( '11' ) " +
            "GROUP BY INSU_ADMDVS;";
    private static final String SQL_QUERY_B = "" +
            "SELECT '居民慢特病' MED_TYPE, INSU_ADMDVS, count(distinct PSN_NO) PSN_COUNT " +
            "FROM setl_d a " +
            "WHERE LEFT(insu_admdvs,4) = '1311' " +
            "   AND SETL_TIME >= ? " +
            "   AND SETL_TIME < ? " +
            "   AND VALI_FLAG = '1' " +
            "   AND INSUTYPE = '390' " +
            "   AND a.REFD_SETL_FLAG = '0' " +
            "   AND med_type IN ( '14' ) " +
            "GROUP BY INSU_ADMDVS;";
    private static final String SQL_QUERY_C = "" +
            "SELECT '居民住院' MED_TYPE, INSU_ADMDVS, count(distinct PSN_NO) PSN_COUNT " +
            "FROM setl_d a " +
            "WHERE LEFT(insu_admdvs,4) = '1311' " +
            "   AND SETL_TIME >= ? " +
            "   AND SETL_TIME < ? " +
            "   AND VALI_FLAG = '1' " +
            "   AND INSUTYPE = '390' " +
            "   AND a.REFD_SETL_FLAG = '0' " +
            "   AND med_type IN ( '21','13','24','23','22','92','9104','9105','9203','9202','9203','9105','9204','9104','9204','9106','9104','9202','9201','9104','9110','9106','9206','9201','9205','9109' ) " +
            "GROUP BY INSU_ADMDVS;";

    private final JdbcTemplate jdbcTemplate;

    public Q41Rep(@Qualifier(Constant.BEAN_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Q41Do> getList(Q41Query query) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(query.getMonth().getTime());
        cal.set(
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),
                0,0,0);
        cal.add(Calendar.MONTH, 1);
        String maxSetlTime = DateTool.GetDateTimeStr(cal.getTime());
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        String minSetlTime = DateTool.GetDateTimeStr(cal.getTime());
        logger.debug(MessageFormat.format("Q41 SQL A {0} {1} {2}",SQL_QUERY_A, minSetlTime, maxSetlTime));
        List<Q41Do> listA = jdbcTemplate.query(SQL_QUERY_A,new Q41RowMapper(), minSetlTime, maxSetlTime);
        logger.debug(MessageFormat.format("Q41 SQL B {0} {1} {2}",SQL_QUERY_B, minSetlTime, maxSetlTime));
        List<Q41Do> listB = jdbcTemplate.query(SQL_QUERY_B,new Q41RowMapper(), minSetlTime, maxSetlTime);
        logger.debug(MessageFormat.format("Q41 SQL C {0} {1} {2}",SQL_QUERY_C, minSetlTime, maxSetlTime));
        List<Q41Do> listC = jdbcTemplate.query(SQL_QUERY_C,new Q41RowMapper(), minSetlTime, maxSetlTime);
        listA.addAll(listB);
        listA.addAll(listC);
        Collections.sort(listA);
        return listA;
    }

}
