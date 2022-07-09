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
//    private static final String SQL_QUERY = "" +
//            "select insu_admdvs,count(distinct psn_no) URR_INSU " +
//            "from setl_d " +
//            "where left(insu_admdvs,4)='1311' " +
//            "   and setl_time >= ? " +
//            "   and SETL_TIME < ? " +
//            "   and VALI_FLAG='1' " +
//            "   and INSUTYPE='390' " +
//            "   and REFD_SETL_FLAG='0' " +
//            "   and FIX_BLNG_ADMDVS NOT LIKE '1311%' " +
//            "Group by insu_admdvs " +
//            "ORDER BY insu_admdvs;";

    private static final String SQL_QUERY = "" +
            "SELECT INSU_ADMDVS, SETL_TYPE, COUNT(DISTINCT PSN_NO) URR_INSU " +
            "FROM ( " +
            "   select INSU_ADMDVS, " +
            "       CASE " +
            "           WHEN INSUTYPE = '310' and INSUTYPE_RETR_FLAG <> '0' and TYPE = 0 THEN '异地安置居住退休人员' " +
            "           WHEN INSUTYPE = '310' and INSUTYPE_RETR_FLAG = '0' and TYPE = 0 THEN '异地工作' " +
            "           WHEN INSUTYPE = '390' and TYPE = 0 THEN '异地居住' " +
            "           WHEN INSUTYPE = '310' THEN '异地转诊(职工)' " +
            "           WHEN INSUTYPE = '390' THEN '异地转诊(居民)' " +
            "           ELSE '异地转诊(居民)' " +
            "       END SETL_TYPE, PSN_NO " +
            "   from ( " +
            "       SELECT a.INSU_ADMDVS, a.PSN_NO, a.INSUTYPE, b.INSUTYPE_RETR_FLAG,c.type " +
            "       FROM ( " +
            "           SELECT INSU_ADMDVS, PSN_NO, INSUTYPE " +
            "           FROM setl_d " +
            "           WHERE INSU_ADMDVS LIKE '1311%' " +
            "               AND FIX_BLNG_ADMDVS NOT LIKE '1311%' " +
            "               AND VALI_FLAG = '1' " +
            "               AND REFD_SETL_FLAG = '0' " +
            "               AND SETL_TIME >= ? " +
            "               AND SETL_TIME < ? " +
            "           GROUP BY INSU_ADMDVS,PSN_NO,INSUTYPE " +
            "       ) a " +
            "       LEFT JOIN ( " +
            "           select PSN_NO,  MAX(INSUTYPE_RETR_FLAG) INSUTYPE_RETR_FLAG " +
            "           from psn_insu_d " +
            "           where INSU_ADMDVS like '1311%' " +
            "               and INSUTYPE = '310' " +
            "           GROUP BY PSN_NO " +
            "       ) b on a.PSN_NO = b.PSN_NO " +
            "       left join ( " +
            "           select PSN_NO, min(TYPE) TYPE " +
            "           from ( " +
            "               select o.PSN_NO, " +
            "                   case " +
            "                       when RLOC_REA in ('02','07','08') then 0 " +
            "                       when RLOC_REA in ('06') then 1 " +
            "                       else 2 " +
            "                   end TYPE " +
            "               from out_appy_d o " +
            "               where o.VALI_FLAG = '1' " +
            "                   and o.CRTE_TIME >= ? " +
            "                   AND o.CRTE_TIME < ? " +
            "                   and o.INSU_ADMDVS like '1311%' " +
            "           ) a " +
            "           GROUP BY PSN_NO " +
            "       ) c on a.PSN_NO = c.PSN_NO " +
            "   ) a " +
            ") a " +
            "GROUP BY INSU_ADMDVS, SETL_TYPE " +
            "ORDER BY INSU_ADMDVS, SETL_TYPE;";


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
        logger.debug(MessageFormat.format("Q34 SQL {0} {1} {2} {3} {4}",SQL_QUERY, minSetlTime,maxSetlTime,minSetlTime,maxSetlTime));
        return jdbcTemplate.query(SQL_QUERY,
                new Q34RowMapper(),
                minSetlTime,maxSetlTime,minSetlTime,maxSetlTime);
    }

}
