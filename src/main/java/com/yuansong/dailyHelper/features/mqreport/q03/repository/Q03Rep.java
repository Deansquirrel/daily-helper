package com.yuansong.dailyHelper.features.mqreport.q03.repository;

import com.github.deansquirrel.tools.common.DateTool;
import com.github.deansquirrel.tools.db.Constant;
import com.yuansong.dailyHelper.features.mqreport.q02.repository.Q02RowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.List;

@Repository
public class Q03Rep {

    private static final Logger logger = LoggerFactory.getLogger(Q03Rep.class);

    private static final String SQL_QUERY = "" +
            "SELECT b.INSU_ADMDVS, sum( CLCT_SUMAMT ) CLCT_SUMAMT " +
//            "FROM staf_psn_clct_detl_d a force INDEX (psn_no), psn_insu_d b " +
            "FROM staf_psn_clct_detl_d a, psn_insu_d b " +
            "WHERE a.insutype = '310' " +
            "   AND revs_flag = 'Z' " +
            "   AND clct_flag = '1' " +
            "   AND ( CLCT_TIME >= ? AND CLCT_TIME < ? ) " +
            "   AND CLCT_TYPE IN ( '32', '33' ) " +
            "   AND b.INSUTYPE = '310' " +
//            "   AND a.psn_no = b.psn_no " +
            "   AND a.PSN_INSU_RLTS_ID = b.PSN_INSU_RLTS_ID " +
            "   AND b.INSU_ADMDVS LIKE '1311%' " +
            "   and a.POOLAREA_NO like '1311%' " +
            "GROUP BY b.INSU_ADMDVS " +
            "ORDER BY b.INSU_ADMDVS;";

    private final JdbcTemplate jdbcTemplate;

    public Q03Rep(@Qualifier(Constant.BEAN_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Q03Do> getList(Q03Query query) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(query.getMonth().getTime());
        cal.set(
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),
                0,0,0);
        cal.add(Calendar.MONTH, 1);
        String maxClctTime = DateTool.GetDateTimeStr(cal.getTime());
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        String minClctTime = DateTool.GetDateTimeStr(cal.getTime());
        logger.debug(MessageFormat.format("Q03 SQL {0} {1} {2}",SQL_QUERY, minClctTime,maxClctTime));
        return jdbcTemplate.query(SQL_QUERY,
                new Q03RowMapper(),
                minClctTime,maxClctTime);
    }

}
