package com.yuansong.dailyHelper.features.mqreport.q10.repository;

import com.github.deansquirrel.tools.common.DateTool;
import com.github.deansquirrel.tools.db.Constant;
import com.yuansong.dailyHelper.features.mqreport.q09.repository.Q09RowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.List;

@Repository
public class Q10Rep {

    private static final Logger logger = LoggerFactory.getLogger(Q10Rep.class);

    private static final String SQL_QUERY = "" +
            "select insu_admdvs,count(distinct psn_no) URR_INSU " +
            "from setl_d " +
            "where left(insu_admdvs,4)='1311' " +
            "   and setl_time >= ? " +
            "   and SETL_TIME < ? " +
            "   and VALI_FLAG='1' " +
            "   and INSUTYPE='310' " +
            "   and REFD_SETL_FLAG='0' " +
            "   and med_type in ('14','9102','9103','9114','9101','9114','9113','9115','9112') " +
            "Group by insu_admdvs " +
            "ORDER BY insu_admdvs;";

    private final JdbcTemplate jdbcTemplate;

    public Q10Rep(@Qualifier(Constant.BEAN_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Q10Do> getList(Q10Query query) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(query.getMonth().getTime());
        cal.set(
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),
                0,0,0);
        cal.add(Calendar.MONTH, 1);
        String maxSetlTime = DateTool.GetDateTimeStr(cal.getTime());
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        String minSetlTime = DateTool.GetDateTimeStr(cal.getTime());
        logger.debug(MessageFormat.format("Q10 SQL {0} {1} {2}",SQL_QUERY, minSetlTime,maxSetlTime));
        return jdbcTemplate.query(SQL_QUERY,
                new Q10RowMapper(),
                minSetlTime,maxSetlTime);
    }

}
