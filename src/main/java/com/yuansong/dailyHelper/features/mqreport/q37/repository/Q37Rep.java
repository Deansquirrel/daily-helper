package com.yuansong.dailyHelper.features.mqreport.q37.repository;

import com.github.deansquirrel.tools.common.DateTool;
import com.github.deansquirrel.tools.db.Constant;
import com.yuansong.dailyHelper.features.mqreport.q36.repository.Q36Do;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.*;

@Repository
public class Q37Rep {

    private static final Logger logger = LoggerFactory.getLogger(Q37Rep.class);

    //计划生育
    private static final String SQL_QUERY_A = "" +
            "select INSU_ADMDVS, " +
            "   CASE " +
            "       WHEN EMP_TYPE IN ('10','99','9008') THEN '企业' " +
            "       WHEN EMP_TYPE IN ('50','55','56','57','70','9001','9002','9003','9004','9005','91','82','90','9009') THEN '事业' " +
            "       WHEN EMP_TYPE IN ('30') THEN '机关' " +
            "       WHEN EMP_TYPE IN ('80','81','9006','9007','9901','9939') THEN '其他' " +
            "       ELSE '企业' " +
            "   END EMP_TYPE, sum( MEDFEE_SUMAMT ) `A01`, count(*) `A02` " +
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
            "group by INSU_ADMDVS, " +
            "   CASE " +
            "       WHEN EMP_TYPE IN ('10','99','9008') THEN '企业' " +
            "       WHEN EMP_TYPE IN ('50','55','56','57','70','9001','9002','9003','9004','9005','91','82','90','9009') THEN '事业' " +
            "       WHEN EMP_TYPE IN ('30') THEN '机关' " +
            "       WHEN EMP_TYPE IN ('80','81','9006','9007','9901','9939') THEN '其他' " +
            "       ELSE '企业' " +
            "   END;";

    //流产
    private static final String SQL_QUERY_B = "" +
            "select INSU_ADMDVS, " +
            "   CASE " +
            "       WHEN EMP_TYPE IN ('10','99','9008') THEN '企业' " +
            "       WHEN EMP_TYPE IN ('50','55','56','57','70','9001','9002','9003','9004','9005','91','82','90','9009') THEN '事业' " +
            "       WHEN EMP_TYPE IN ('30') THEN '机关' " +
            "       WHEN EMP_TYPE IN ('80','81','9006','9007','9901','9939') THEN '其他' " +
            "       ELSE '企业' " +
            "   END EMP_TYPE, sum( MEDFEE_SUMAMT ) `B01`, count(*) `B02` " +
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
            "           and BIRCTRL_TYPE in ('3','4')" +
            "   ) " +
            "group by INSU_ADMDVS, " +
            "   CASE " +
            "       WHEN EMP_TYPE IN ('10','99','9008') THEN '企业' " +
            "       WHEN EMP_TYPE IN ('50','55','56','57','70','9001','9002','9003','9004','9005','91','82','90','9009') THEN '事业' " +
            "       WHEN EMP_TYPE IN ('30') THEN '机关' " +
            "       WHEN EMP_TYPE IN ('80','81','9006','9007','9901','9939') THEN '其他' " +
            "       ELSE '企业' " +
            "   END;";

    //生育
    private static final String SQL_QUERY_C = "" +
            "select INSU_ADMDVS, " +
            "   CASE " +
            "       WHEN EMP_TYPE IN ('10','99','9008') THEN '企业' " +
            "       WHEN EMP_TYPE IN ('50','55','56','57','70','9001','9002','9003','9004','9005','91','82','90','9009') THEN '事业' " +
            "       WHEN EMP_TYPE IN ('30') THEN '机关' " +
            "       WHEN EMP_TYPE IN ('80','81','9006','9007','9901','9939') THEN '其他' " +
            "       ELSE '企业' " +
            "   END EMP_TYPE, sum( MEDFEE_SUMAMT ) `C01`, count(*) `C02` " +
            "from setl_d " +
            "where 1=1 " +
            "   and INSU_ADMDVS like '1311%' " +
            "   and INSUTYPE='310' " +
            "   and MED_TYPE IN ( '52', '53' ) " +
            "   and VALI_FLAG = '1' " +
            "   and REFD_SETL_FLAG = '0' " +
            "   and SETL_TIME >= ? " +
            "   and SETL_TIME < ? " +
            "group by INSU_ADMDVS, " +
            "   CASE " +
            "       WHEN EMP_TYPE IN ('10','99','9008') THEN '企业' " +
            "       WHEN EMP_TYPE IN ('50','55','56','57','70','9001','9002','9003','9004','9005','91','82','90','9009') THEN '事业' " +
            "       WHEN EMP_TYPE IN ('30') THEN '机关' " +
            "       WHEN EMP_TYPE IN ('80','81','9006','9007','9901','9939') THEN '其他' " +
            "       ELSE '企业' " +
            "   END;";

    //顺产
    private static final String SQL_QUERY_D = "" +
            "select INSU_ADMDVS, " +
            "   CASE " +
            "       WHEN EMP_TYPE IN ('10','99','9008') THEN '企业' " +
            "       WHEN EMP_TYPE IN ('50','55','56','57','70','9001','9002','9003','9004','9005','91','82','90','9009') THEN '事业' " +
            "       WHEN EMP_TYPE IN ('30') THEN '机关' " +
            "       WHEN EMP_TYPE IN ('80','81','9006','9007','9901','9939') THEN '其他' " +
            "       ELSE '企业' " +
            "   END EMP_TYPE, sum( MEDFEE_SUMAMT ) `D01`, count(*) `D02` " +
            "from setl_d " +
            "where 1=1 " +
            "   and INSU_ADMDVS like '1311%' " +
            "   and INSUTYPE='310' " +
            "   and MED_TYPE IN ( '52', '53' ) " +
            "   and VALI_FLAG = '1' " +
            "   and REFD_SETL_FLAG = '0' " +
            "   and SETL_TIME >= ? " +
            "   and SETL_TIME < ? " +
            "   and exists (" +
            "       select 1 " +
            "       from mdtrt_d " +
            "       where MDTRT_ID=setl_d.MDTRT_ID " +
            "           and MATN_TYPE in ('1')" +
            "   ) " +
            "group by INSU_ADMDVS, " +
            "   CASE " +
            "       WHEN EMP_TYPE IN ('10','99','9008') THEN '企业' " +
            "       WHEN EMP_TYPE IN ('50','55','56','57','70','9001','9002','9003','9004','9005','91','82','90','9009') THEN '事业' " +
            "       WHEN EMP_TYPE IN ('30') THEN '机关' " +
            "       WHEN EMP_TYPE IN ('80','81','9006','9007','9901','9939') THEN '其他' " +
            "       ELSE '企业' " +
            "   END;";


    //生育津贴
    private static final String SQL_QUERY_E = "" +
            "select INSU_ADMDVS, EMP_TYPE,count(*) `E02`, sum(MATN_ALWN_SUMAMT) `E01` " +
            "from ( " +
            "   select a.PSN_NO, " +
            "       CASE " +
            "           WHEN EMP_TYPE IN ('10','99','9008') THEN '企业' " +
            "           WHEN EMP_TYPE IN ('50','55','56','57','70','9001','9002','9003','9004','9005','91','82','90','9009') THEN '事业' " +
            "           WHEN EMP_TYPE IN ('30') THEN '机关' " +
            "           WHEN EMP_TYPE IN ('80','81','9006','9007','9901','9939') THEN '其他' " +
            "           ELSE '企业' " +
            "       END EMP_TYPE,b.INSU_ADMDVS,MATN_ALWN_SUMAMT " +
            "   from matn_alwn_crtf_d a,psn_insu_d b " +
            "   left join insu_emp_info_b c on c.EMP_NO = b.EMP_NO " +
            "   where 1=1 " +
            "       and a.POOLAREA_NO like '1311%' " +
            "       and a.VALI_FLAG = '1' " +
            "       AND a.YM >= ? " +
            "       AND a.YM < ? " +
            "       and a.PSN_INSU_RLTS_ID = b.PSN_INSU_RLTS_ID " +
            ") a " +
            "group by INSU_ADMDVS,EMP_TYPE;";

    //本期享受待遇女性
    private static final String SQL_QUERY_F = "" +
            "select INSU_ADMDVS, EMP_TYPE,count(*) `F01`, count(DISTINCT PSN_NO) `F02` " +
            "from ( " +
            "   select PSN_NO, CASE " +
            "           WHEN EMP_TYPE IN ('10','99','9008') THEN '企业' " +
            "           WHEN EMP_TYPE IN ('50','55','56','57','70','9001','9002','9003','9004','9005','91','82','90','9009') THEN '事业' " +
            "           WHEN EMP_TYPE IN ('30') THEN '机关' " +
            "           WHEN EMP_TYPE IN ('80','81','9006','9007','9901','9939') THEN '其他' " +
            "           ELSE '企业' " +
            "       END EMP_TYPE,INSU_ADMDVS " +
            "   from setl_d " +
            "   where 1=1 " +
            "       and INSU_ADMDVS like '1311%' " +
            "       and INSUTYPE='310'" +
            "       and MED_TYPE in('51','52','53') " +
            "       and VALI_FLAG = '1' " +
            "       and REFD_SETL_FLAG = '0' " +
            "       and SETL_TIME >= ? " +
            "       and SETL_TIME < ? " +
            "       and EXISTS ( " +
            "           select 1 " +
            "           from psn_info_b " +
            "           where GEND='2' and PSN_NO=setl_d.PSN_NO " +
            "       ) " +
            "   UNION ALL " +
            "   select a.PSN_NO, CASE " +
            "           WHEN EMP_TYPE IN ('10','99','9008') THEN '企业' " +
            "           WHEN EMP_TYPE IN ('50','55','56','57','70','9001','9002','9003','9004','9005','91','82','90','9009') THEN '事业' " +
            "           WHEN EMP_TYPE IN ('30') THEN '机关' " +
            "           WHEN EMP_TYPE IN ('80','81','9006','9007','9901','9939') THEN '其他' " +
            "           ELSE '企业' " +
            "       END EMP_TYPE,b.INSU_ADMDVS " +
            "   from matn_alwn_crtf_d a,psn_insu_d b " +
            "   left join insu_emp_info_b c on c.EMP_NO = b.EMP_NO " +
            "   where 1=1 " +
            "       and a.POOLAREA_NO like '1311%' " +
            "       and a.VALI_FLAG = '1' " +
            "       AND a.YM >= ? " +
            "       AND a.YM < ? " +
            "       and a.PSN_INSU_RLTS_ID = b.PSN_INSU_RLTS_ID " +
            "       and EXISTS ( " +
            "           select 1 " +
            "           from psn_info_b " +
            "           where GEND='2' and PSN_NO=a.PSN_NO " +
            "       ) " +
            ") t " +
            "group by INSU_ADMDVS,EMP_TYPE;";

    private final JdbcTemplate jdbcTemplate;

    public Q37Rep(@Qualifier(Constant.BEAN_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Q37Do> getList(Q37Query query) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(query.getMonth().getTime());
        cal.set(
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),
                0,0,0);
        cal.add(Calendar.MONTH, 1);
        String maxSetlTime = DateTool.GetDateStr(cal.getTime());
        String maxYm = DateTool.GetStr(cal.getTime(), "yyyyMM");
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        String minSetlTime = DateTool.GetDateStr(cal.getTime());
        String minYm = DateTool.GetStr(cal.getTime(), "yyyyMM");
        Map<String, Q37Do> map = new HashMap<>();
        List<Q37Do> list = getListA(minSetlTime, maxSetlTime);
        handleList(list, map);
        list = getListB(minSetlTime, maxSetlTime);
        handleList(list, map);
        list = getListC(minSetlTime, maxSetlTime);
        handleList(list, map);
        list = getListD(minSetlTime, maxSetlTime);
        handleList(list, map);
        list = getListE(minYm, maxYm);
        handleList(list, map);
        list = getListF(minSetlTime, maxSetlTime, minYm, maxYm);
        handleList(list, map);

        list = new ArrayList<>(map.values());
        Collections.sort(list);
        return list;
    }

    private List<Q37Do> getListA(String minSetlTime, String maxSetlTime) {
        logger.debug(MessageFormat.format("Q37 SQL A {0} {1} {2}",SQL_QUERY_A, minSetlTime,maxSetlTime));
        return jdbcTemplate.query(SQL_QUERY_A, new Q37RowMapper(), minSetlTime,maxSetlTime);
    }

    private List<Q37Do> getListB(String minSetlTime, String maxSetlTime) {
        logger.debug(MessageFormat.format("Q37 SQL B {0} {1} {2}",SQL_QUERY_B, minSetlTime,maxSetlTime));
        return jdbcTemplate.query(SQL_QUERY_B, new Q37RowMapper(), minSetlTime,maxSetlTime);
    }

    private List<Q37Do> getListC(String minSetlTime, String maxSetlTime) {
        logger.debug(MessageFormat.format("Q37 SQL C {0} {1} {2}",SQL_QUERY_C, minSetlTime,maxSetlTime));
        return jdbcTemplate.query(SQL_QUERY_C, new Q37RowMapper(), minSetlTime,maxSetlTime);
    }

    private List<Q37Do> getListD(String minSetlTime, String maxSetlTime) {
        logger.debug(MessageFormat.format("Q37 SQL D {0} {1} {2}",SQL_QUERY_D, minSetlTime,maxSetlTime));
        return jdbcTemplate.query(SQL_QUERY_D, new Q37RowMapper(), minSetlTime,maxSetlTime);
    }

    private List<Q37Do> getListE(String minYm, String maxYm) {
        logger.debug(MessageFormat.format("Q37 SQL E {0} {1} {2}",SQL_QUERY_E, minYm,maxYm));
        return jdbcTemplate.query(SQL_QUERY_E, new Q37RowMapper(), minYm,maxYm);
    }

    private List<Q37Do> getListF(String minSetlTime, String maxSetlTime, String minYm, String maxYm) {
        logger.debug(MessageFormat.format("Q37 SQL F {0} {1} {2} {3} {4}",SQL_QUERY_F, minSetlTime,maxSetlTime,minYm,maxYm));
        return jdbcTemplate.query(SQL_QUERY_F, new Q37RowMapper(), minSetlTime,maxSetlTime,minYm,maxYm);
    }

    private void handleList(List<Q37Do> list, Map<String, Q37Do> map) {
        String k = "";
        for(Q37Do d : list) {
            k = MessageFormat.format("{0}-{1}",d.getInsuAdmdvs(), d.getEmpType());
            if(map.containsKey(k)) {
                map.put(k, map.get(k).add(d));
            } else {
                map.put(k, d);
            }
        }
    }
}
