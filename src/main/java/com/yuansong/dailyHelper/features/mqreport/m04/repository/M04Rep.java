package com.yuansong.dailyHelper.features.mqreport.m04.repository;

import com.github.deansquirrel.tools.common.DateTool;
import com.github.deansquirrel.tools.db.Constant;
import com.yuansong.dailyHelper.features.mqreport.m03.repository.M03Do;
import com.yuansong.dailyHelper.features.mqreport.m03.repository.M03Query;
import com.yuansong.dailyHelper.features.mqreport.m03.repository.M03RowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.List;

@Repository
public class M04Rep {

    private static final Logger logger = LoggerFactory.getLogger(M04Rep.class);

    private static final String SQL_QUERY = "" +
            "select a.INSU_ADMDVS,count(PSN_NO) as URR_INSU " +
            "from (" +
            "   select MIN(INSU_ADMDVS) INSU_ADMDVS,PSN_NO " +
            "   from setl_d " +
            "   where PSN_NO like '13%' " +
            "       and INSUTYPE = '390' " +
            "       and CRTE_TIME >= ? " +
            "       and CRTE_TIME < ? " +
            "       and HIFP_PAY > 0 " +
            "       and INSU_ADMDVS like '1311%' " +
            "       group by psn_no" +
            "   ) a " +
            "group by a.INSU_ADMDVS " +
            "order by a.INSU_ADMDVS;";

    private final JdbcTemplate jdbcTemplate;

    public M04Rep(@Qualifier(Constant.BEAN_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<M04Do> getList(M04Query query) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(query.getMonth().getTime());
        cal.add(Calendar.MONTH, 1);
        cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),0,0,0);
        String crteTimeMax = DateTool.GetDateTimeStr(cal.getTime());
        cal.set(Calendar.MONTH,Calendar.JANUARY);
        String crteTimeMin = DateTool.GetDateTimeStr(cal.getTime());
        logger.debug(MessageFormat.format("M04 SQL {0} {1} {2}",SQL_QUERY, crteTimeMin, crteTimeMax));
        return jdbcTemplate.query(SQL_QUERY, new M04RowMapper(),crteTimeMin, crteTimeMax);
    }

}
