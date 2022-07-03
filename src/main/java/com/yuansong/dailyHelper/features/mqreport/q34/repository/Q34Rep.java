package com.yuansong.dailyHelper.features.mqreport.q34.repository;

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
public class Q34Rep {

    private static final Logger logger = LoggerFactory.getLogger(Q34Rep.class);
    private static final String SQL_QUERY = "" +
            "select insu_admdvs,count(distinct psn_no) URR_INSU " +
            "from setl_d " +
            "where left(insu_admdvs,4)='1311' " +
            "   and setl_time >= ? " +
            "   and SETL_TIME < ? " +
            "   and VALI_FLAG='1' " +
            "   and INSUTYPE='390' " +
            "   and REFD_SETL_FLAG='0' " +
            "   and FIX_BLNG_ADMDVS NOT LIKE '1311%' " +
            "Group by insu_admdvs " +
            "ORDER BY insu_admdvs;";

    private final JdbcTemplate jdbcTemplate;

    public Q34Rep(@Qualifier(Constant.BEAN_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Q34Do> getList(Q34Query query) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(query.getMonth().getTime());
        cal.set(
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),
                0,0,0);
        cal.add(Calendar.MONTH, 1);
        String maxSetlTime = DateTool.GetDateTimeStr(cal.getTime());
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        String minSetlTime = DateTool.GetDateTimeStr(cal.getTime());
        logger.debug(MessageFormat.format("Q34 SQL {0} {1} {2}",SQL_QUERY, minSetlTime,maxSetlTime));
        return jdbcTemplate.query(SQL_QUERY,
                new Q34RowMapper(),
                minSetlTime,maxSetlTime);
    }

}
