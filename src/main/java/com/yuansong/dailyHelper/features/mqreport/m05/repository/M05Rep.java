package com.yuansong.dailyHelper.features.mqreport.m05.repository;

import com.github.deansquirrel.tools.common.DateTool;
import com.github.deansquirrel.tools.db.Constant;
import com.yuansong.dailyHelper.features.mqreport.m01.repository.M01RowMapper;
import com.yuansong.dailyHelper.features.mqreport.m04.repository.M04Do;
import com.yuansong.dailyHelper.features.mqreport.m04.repository.M04Query;
import com.yuansong.dailyHelper.features.mqreport.m04.repository.M04RowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.List;

@Repository
public class M05Rep {

    private static final Logger logger = LoggerFactory.getLogger(M05Rep.class);

    private static final String SQL_QUERY_A = "" +
            "SELECT p.INSU_ADMDVS,COUNT(DISTINCT r.PSN_NO) `A01`, 0 `B01`, 0 `C01`, 0 `C02`, 0 `D01` " +
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
            "   and EXISTS (" +
            "       select 1 " +
            "       from psn_info_b " +
            "       where GEND='2' and PSN_NO=p.PSN_NO" +
            "   ) " +
            "GROUP BY p.INSU_ADMDVS " +
            "order by p.INSU_ADMDVS;";
    private static final String SQL_QUERY_B = "" +
            "select INSU_ADMDVS, count(*) `B01`,0 `A01`, 0 `C01`, 0 `C02`, 0 `D01` " +
            "from (" +
            "   select PSN_NO,INSU_ADMDVS" +
            "   from setl_d" +
            "   where 1=1 " +
            "       and INSU_ADMDVS like '1311%' " +
            "       and INSUTYPE='310' " +
            "       and MED_TYPE in('51','52','53') " +
            "       and VALI_FLAG = '1' " +
            "       and REFD_SETL_FLAG = '0' " +
            "       and SETL_TIME >= ? " +
            "       and SETL_TIME < ? " +
            "   UNION ALL " +
            "   select a.PSN_NO,b.INSU_ADMDVS " +
            "   from matn_alwn_crtf_d a,psn_insu_d b " +
            "   where 1=1 " +
            "       and a.POOLAREA_NO like '1311%' " +
            "       and a.VALI_FLAG = '1' " +
            "       AND a.YM >= ? " +
            "       AND a.YM < ? " +
            "       and a.PSN_INSU_RLTS_ID = b.PSN_INSU_RLTS_ID " +
            "   ) t " +
            "group by INSU_ADMDVS " +
            "order by INSU_ADMDVS;";
    private static final String SQL_QUERY_C = "" +
            "select INSU_ADMDVS, count(*) `C01`, count(DISTINCT PSN_NO) `C02`,0 `A01`, 0 `B01`, 0 `D01` " +
            "from ( " +
            "   select PSN_NO,INSU_ADMDVS " +
            "   from setl_d " +
            "   where 1=1 " +
            "       and INSU_ADMDVS like '1311%' " +
            "       and INSUTYPE='310' " +
            "       and MED_TYPE in('51','52','53') " +
            "       and VALI_FLAG = '1' " +
            "       and REFD_SETL_FLAG = '0' " +
            "       and SETL_TIME >= ? " +
            "       and SETL_TIME < ? " +
            "       and EXISTS (" +
            "           select 1 " +
            "           from psn_info_b " +
            "           where GEND='2' and PSN_NO=setl_d.PSN_NO" +
            "       ) " +
            ") t " +
            "group by INSU_ADMDVS " +
            "order by INSU_ADMDVS;";
    private static final String SQL_QUERY_D = "" +
            "select INSU_ADMDVS,count(*) `D01`,0 `A01`, 0 `B01`, 0 `C01`, 0 `C02` " +
            "from setl_d " +
            "where 1=1 " +
            "   and INSU_ADMDVS like '1311%' " +
            "   and INSUTYPE='310' " +
            "   and MED_TYPE ='51' " +
            "   and VALI_FLAG = '1' " +
            "   and REFD_SETL_FLAG = '0' " +
            "   and SETL_TIME >= ? " +
            "   and SETL_TIME < ? " +
            "   and exists (" +
            "       select 1 " +
            "       from mdtrt_d " +
            "       where MDTRT_ID=setl_d.MDTRT_ID " +
            "           and BIRCTRL_TYPE in ('1','2','3','4','5','6','9')" +
            "   ) " +
            "group by INSU_ADMDVS " +
            "order by INSU_ADMDVS;";

    private final JdbcTemplate jdbcTemplate;

    public M05Rep(@Qualifier(Constant.BEAN_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<M05Do> getAList(M05Query query) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(query.getMonth().getTime());
        cal.add(Calendar.MONTH, 1);
        String clctTime = DateTool.GetDateStr(cal.getTime());
        cal.add(Calendar.MONTH,-6);
        String accrymEnd = DateTool.GetStr(cal.getTime(), "yyyyMM");
        logger.debug(MessageFormat.format("M05_A SQL {0} {1} {2}",
                SQL_QUERY_A, accrymEnd, clctTime));
        return jdbcTemplate.query(SQL_QUERY_A,
                new M05RowMapper(),
                accrymEnd, clctTime);
    }

    public List<M05Do> getBList(M05Query query) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(query.getMonth().getTime());
        cal.add(Calendar.MONTH, 1);
        String setlTimeMax = DateTool.GetDateTimeStr(cal.getTime());
        String ymMax = DateTool.GetStr(cal.getTime(), "yyyyMM");
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        String setlTimeMin = DateTool.GetDateTimeStr(cal.getTime());
        String ymMin = DateTool.GetStr(cal.getTime(), "yyyyMM");
        logger.debug(MessageFormat.format("M05_B SQL {0} {1} {2} {3} {4}",
                SQL_QUERY_B, setlTimeMin, setlTimeMax, ymMin, ymMax));
        return jdbcTemplate.query(SQL_QUERY_B, new M05RowMapper(),
                setlTimeMin, setlTimeMax, ymMin, ymMax);
    }

    public List<M05Do> getCList(M05Query query) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(query.getMonth().getTime());
        cal.add(Calendar.MONTH, 1);
        String setlTimeMax = DateTool.GetDateTimeStr(cal.getTime());
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        String setlTimeMin = DateTool.GetDateTimeStr(cal.getTime());
        logger.debug(MessageFormat.format("M05_C SQL {0} {1} {2} ",
                SQL_QUERY_C, setlTimeMin, setlTimeMax, setlTimeMin, setlTimeMax));
        return jdbcTemplate.query(SQL_QUERY_C, new M05RowMapper(),
                setlTimeMin, setlTimeMax);
    }

    public List<M05Do> getDList(M05Query query) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(query.getMonth().getTime());
        cal.add(Calendar.MONTH, 1);
        String setlTimeMax = DateTool.GetDateTimeStr(cal.getTime());
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        String setlTimeMin = DateTool.GetDateTimeStr(cal.getTime());
        logger.debug(MessageFormat.format("M05_D SQL {0} {1} {2} ",
                SQL_QUERY_D, setlTimeMin, setlTimeMax, setlTimeMin, setlTimeMax));
        return jdbcTemplate.query(SQL_QUERY_D, new M05RowMapper(),
                setlTimeMin, setlTimeMax);
    }
}
