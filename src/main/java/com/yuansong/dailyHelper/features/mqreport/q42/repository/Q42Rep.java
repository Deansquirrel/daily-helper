package com.yuansong.dailyHelper.features.mqreport.q42.repository;

import com.github.deansquirrel.tools.common.DateTool;
import com.github.deansquirrel.tools.db.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

@Repository
public class Q42Rep {

    private static final Logger logger = LoggerFactory.getLogger(Q42Rep.class);
//    private static final String SQL_QUERY = "" +
//            "select INSU_ADMDVS, " +
//            "   CASE " +
//            "       WHEN INSUTYPE = '310' THEN '职工' " +
//            "       WHEN INSUTYPE = '390' THEN '居民' " +
//            "       WHEN INSUTYPE = '340' THEN '离休' " +
//            "       ELSE INSUTYPE " +
//            "   END INSUTYPE, count(distinct PSN_NO) `A01`, count(*) `A02` " +
//            "from out_appy_d " +
//            "where 1=1 " +
//            "   and INSU_ADMDVS like '1311%' " +
//            "   and CRTE_TIME >= ? " +
//            "   and CRTE_TIME < ? " +
//            "   and left(RLOC_ADMDVS,2) <> '13' " +
//            "   and VALI_FLAG = '1' " +
//            "group by INSU_ADMDVS,INSUTYPE " +
//            "order by INSU_ADMDVS,INSUTYPE;";

    private static final String SQL_QUERY = "" +
            "select a.INSU_ADMDVS, " +
            "   CASE " +
            "       WHEN a.INSUTYPE = '310' and b.INSUTYPE_RETR_FLAG = '0' THEN '职工在职' " +
            "       WHEN a.INSUTYPE = '310' and b.INSUTYPE_RETR_FLAG <> '0' THEN '职工退休' " +
            "       WHEN a.INSUTYPE = '340' THEN '离休' " +
            "       WHEN a.INSUTYPE = '390' THEN '居民' " +
            "       ELSE a.INSUTYPE " +
            "   END INSUTYPE, count(distinct a.PSN_NO) `A01`, count(*) `A02` " +
            "from out_appy_d a " +
            "LEFT JOIN PSN_INSU_D b on a.psn_no = b.psn_no and a.PSN_INSU_RLTS_ID = b.PSN_INSU_RLTS_ID " +
            "where 1=1 " +
            "   and a.psn_no = b.psn_no " +
            "   and a.INSU_ADMDVS like '1311%' " +
            "   and a.CRTE_TIME >= ? " +
            "   and a.CRTE_TIME < ? " +
            "   and left(a.RLOC_ADMDVS,2) <> '13' " +
            "   and a.VALI_FLAG = '1' " +
            "group by a.INSU_ADMDVS, " +
            "   CASE " +
            "       WHEN a.INSUTYPE = '310' and b.INSUTYPE_RETR_FLAG = '0' THEN '职工在职' " +
            "       WHEN a.INSUTYPE = '310' and b.INSUTYPE_RETR_FLAG <> '0' THEN '职工退休' " +
            "       WHEN a.INSUTYPE = '340' THEN '离休' " +
            "       WHEN a.INSUTYPE = '390' THEN '居民' " +
            "       ELSE a.INSUTYPE " +
            "   END " +
            "order by a.INSU_ADMDVS, " +
            "   CASE " +
            "       WHEN a.INSUTYPE = '310' and b.INSUTYPE_RETR_FLAG = '0' THEN '职工在职' " +
            "       WHEN a.INSUTYPE = '310' and b.INSUTYPE_RETR_FLAG <> '0' THEN '职工退休' " +
            "       WHEN a.INSUTYPE = '340' THEN '离休' " +
            "       WHEN a.INSUTYPE = '390' THEN '居民' " +
            "       ELSE a.INSUTYPE " +
            "   END; ";
    
    private final JdbcTemplate jdbcTemplate;

    public Q42Rep(@Qualifier(Constant.BEAN_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Q42Do> getList(Q42Query query) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(query.getMonth().getTime());
        cal.set(
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),
                0,0,0);
        cal.add(Calendar.MONTH, 1);
        String maxSetlTime = DateTool.GetDateTimeStr(cal.getTime());
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        String minSetlTime = DateTool.GetDateTimeStr(cal.getTime());
        logger.debug(MessageFormat.format("Q42 SQL A {0} {1} {2}",SQL_QUERY, minSetlTime, maxSetlTime));
        return jdbcTemplate.query(SQL_QUERY, new Q42RowMapper(), minSetlTime, maxSetlTime);
    }

}
