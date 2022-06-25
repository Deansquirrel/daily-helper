package com.yuansong.dailyHelper.features.mqreport.q03.repository;

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
public class Q03Rep {

    private static final Logger logger = LoggerFactory.getLogger(Q03Rep.class);

    private static final String SQL_QUERY = "" +
            "";

    private final JdbcTemplate jdbcTemplate;

    public Q03Rep(@Qualifier(Constant.BEAN_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Q03Do> getList(Q03Query query) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(query.getMonth().getTime());
        cal.add(Calendar.MONTH, 1);
        String clctTime = DateTool.GetDateStr(cal.getTime());
        cal.add(Calendar.MONTH,-6);
        String accrymEnd = DateTool.GetStr(cal.getTime(), "yyyyMM");
        logger.debug(MessageFormat.format("Q03 SQL {0} {1} {2}",SQL_QUERY, clctTime,accrymEnd));
        return jdbcTemplate.query(SQL_QUERY,
                new Q03RowMapper(),
                clctTime,accrymEnd);
    }

}
