package com.yuansong.dailyHelper.features.mqreport.m06.repository;

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
public class M06Rep {

    private static final Logger logger = LoggerFactory.getLogger(M06Rep.class);

    private static final String SQL_QUERY = "" +
            "SELECT p.INSU_ADMDVS,COUNT(DISTINCT r.PSN_NO) URR_INSU " +
            "FROM staf_psn_clct_detl_d r " +
            "LEFT JOIN psn_insu_d p ON r.PSN_NO = p.PSN_NO " +
            "WHERE r.PSN_NO LIKE '13%' " +
            "   and p.PSN_INSU_STAS in (1) " +
            "   and p.INSUTYPE = '310' " +
            "   and r.INSUTYPE = '310' " +
            "   and p.INSU_ADMDVS like '1311%' " +
            "   and r.CLCT_TYPE = 10 " +
            "   and r.CLCT_FLAG = 1 " +
            "   and ACCRYM_END >= ? " +
            "   and CLCT_TIME < ? " +
            "   and REVS_FLAG = 'Z' " +
            "   and p.INSUTYPE_RETR_FLAG = 0 " +
            "GROUP BY p.INSU_ADMDVS " +
            "order by p.INSU_ADMDVS;";

    private final JdbcTemplate jdbcTemplate;

    public M06Rep(@Qualifier(Constant.BEAN_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<M06Do> getList(M06Query query) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(query.getMonth().getTime());
        cal.add(Calendar.MONTH, 1);
        String clctTime = DateTool.GetDateStr(cal.getTime());
        cal.add(Calendar.MONTH,-6);
        String accrymEnd = DateTool.GetStr(cal.getTime(), "yyyyMM");
        logger.debug(MessageFormat.format("M06 SQL {0} {1} {2}",SQL_QUERY, accrymEnd, clctTime));
        return jdbcTemplate.query(SQL_QUERY,
                new M06RowMapper(),
                accrymEnd, clctTime);
    }

}
