package com.yuansong.dailyHelper.features.mqreport.m09.repository;

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
public class M09Rep {

    private static final Logger logger = LoggerFactory.getLogger(M09Rep.class);

    private static final String SQL_QUERY = "" +
            "select p.INSU_ADMDVS,count(DISTINCT a.PSN_NO) URR_INSU " +
            "from staf_psn_clct_detl_d a " +
            "LEFT JOIN psn_insu_d p on a.PSN_NO=p.PSN_NO " +
            "where a.PSN_NO like '13%' " +
            "   and a.CLCT_TYPE = '32' " +
            "   and a.INSUTYPE='310' " +
            "   and p.PSN_INSU_STAS in (1,2) " +
            "   and p.INSUTYPE = '310' " +
            "   and a.CRTE_TIME >= ? " +
            "   and a.CRTE_TIME < ? " +
            "   and p.INSU_ADMDVS like '1311%' " +
            "group by p.INSU_ADMDVS " +
            "order by p.INSU_ADMDVS;";

    private final JdbcTemplate jdbcTemplate;

    public M09Rep(@Qualifier(Constant.BEAN_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<M09Do> getList(M09Query query) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(query.getMonth().getTime());
        cal.add(Calendar.MONTH, 1);
        cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),0,0,0);
        String crteTimeMax = DateTool.GetDateTimeStr(cal.getTime());
        cal.set(Calendar.MONTH,Calendar.JANUARY);
        String crteTimeMin = DateTool.GetDateTimeStr(cal.getTime());
        logger.debug(MessageFormat.format("M09 SQL {0} {1} {2}",SQL_QUERY, crteTimeMin, crteTimeMax));
        return jdbcTemplate.query(SQL_QUERY,
                new M09RowMapper(),
                crteTimeMin, crteTimeMax);
    }

}
