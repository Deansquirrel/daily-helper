package com.yuansong.dailyHelper.features.mqreport.q36.repository;

import com.github.deansquirrel.tools.common.DateTool;
import com.github.deansquirrel.tools.db.Constant;
import com.yuansong.dailyHelper.features.mqreport.q26.repository.Q26Do;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.*;

@Repository
public class Q36Rep {

    private static final Logger logger = LoggerFactory.getLogger(Q36Rep.class);

    //转入农民工合计
    private static final String SQL_QUERY_A01 = "" +
            "SELECT TRAFIN_ADMDVS INSU_ADMDVS,count(*) `A01` " +
            "FROM rlts_traf_info_d a " +
            "   STRAIGHT_JOIN psn_info_b b ON a.PSN_NO = b.PSN_NO " +
            "   AND left(a.TRAFIN_ADMDVS,4)='1311' " +
            "   AND a.CRTE_TIME >= ? " +
            "   AND a.CRTE_TIME < ? " +
            "   AND b.RESD_NATU IN ('20', '21', '22') " +
            "group by TRAFIN_ADMDVS " +
            "ORDER BY TRAFIN_ADMDVS;";

    //转入农民工合计省外
    private static final String SQL_QUERY_A02 = "" +
            "SELECT TRAFIN_ADMDVS INSU_ADMDVS,count(*) `A02` " +
            "FROM rlts_traf_info_d a " +
            "   STRAIGHT_JOIN psn_info_b b ON a.PSN_NO = b.PSN_NO " +
            "   AND left(a.TRAFIN_ADMDVS,4)='1311' " +
            "   AND a.CRTE_TIME >= ? " +
            "   AND a.CRTE_TIME < ? " +
            "   AND LEFT ( a.TRAFOUT_ADMDVS, 2 ) != '13' " +
            "   AND b.RESD_NATU IN ('20', '21', '22') " +
            "group by TRAFIN_ADMDVS " +
            "ORDER BY TRAFIN_ADMDVS;";

    //职工医保转入职工医保合计
    private static final String SQL_QUERY_A03 = "" +
            "SELECT TRAFIN_ADMDVS INSU_ADMDVS, count(*) `A03` " +
            "FROM rlts_traf_info_d " +
            "WHERE LEFT ( TRAFIN_ADMDVS, 4 )= '1311' " +
            "   AND CRTE_TIME >= ? " +
            "   AND CRTE_TIME < ? " +
            "   AND TRAF_PROT_DIRC = '11' " +
            "GROUP BY TRAFIN_ADMDVS " +
            "ORDER BY TRAFIN_ADMDVS;";

    //职工医保转入职工医保省外
    private static final String SQL_QUERY_A04 = "" +
            "SELECT TRAFIN_ADMDVS INSU_ADMDVS, count(*) `A04` " +
            "FROM rlts_traf_info_d " +
            "WHERE LEFT ( TRAFIN_ADMDVS, 4 )= '1311' " +
            "   AND CRTE_TIME >= ? " +
            "   AND CRTE_TIME < ? " +
            "   AND TRAF_PROT_DIRC = '11' " +
            "   AND LEFT ( TRAFOUT_ADMDVS, 2 ) != '13' " +
            "GROUP BY TRAFIN_ADMDVS " +
            "ORDER BY TRAFIN_ADMDVS;";

    //职工医保转入居民医保合计
    private static final String SQL_QUERY_A05 = "" +
            "SELECT TRAFIN_ADMDVS INSU_ADMDVS, count(*) `A05` " +
            "FROM rlts_traf_info_d " +
            "WHERE LEFT ( TRAFIN_ADMDVS, 4 )= '1311' " +
            "   AND CRTE_TIME >= ? " +
            "   AND CRTE_TIME < ? " +
            "   AND TRAF_PROT_DIRC IN ( '12', '14' ) " +
            "GROUP BY TRAFIN_ADMDVS " +
            "ORDER BY TRAFIN_ADMDVS;";

    //居民医保转入职工医保合计
    private static final String SQL_QUERY_A06 = "" +
            "SELECT TRAFIN_ADMDVS INSU_ADMDVS, count(*) `A06` " +
            "FROM rlts_traf_info_d " +
            "WHERE LEFT ( TRAFIN_ADMDVS, 4 )= '1311' " +
            "   AND CRTE_TIME >= ? " +
            "   AND CRTE_TIME < ? " +
            "   AND TRAF_PROT_DIRC IN ( '22', '42' ) " +
            "GROUP BY TRAFIN_ADMDVS " +
            "ORDER BY TRAFIN_ADMDVS;";

    //转入金额合计
    private static final String SQL_QUERY_A07 = "" +
            "SELECT TRAFIN_ADMDVS INSU_ADMDVS, IFNULL( sum( b.ACCTFUND_TRAF_AMT ), 0 ) `A07` " +
            "FROM rlts_traf_info_d a " +
            "   STRAIGHT_JOIN rlts_traf_fund_map_d b ON LEFT ( TRAFIN_ADMDVS, 4 )= '1311' " +
            "   AND a.CRTE_TIME >= ? " +
            "   AND a.CRTE_TIME < ? " +
            "   AND a.RLTS_TRAF_ID = b.RLTS_TRAF_ID " +
            "   AND a.PSN_NO = b.PSN_NO " +
            "GROUP BY TRAFIN_ADMDVS " +
            "ORDER BY TRAFIN_ADMDVS;";

    //转出合计
    private static final String SQL_QUERY_B01 = "" +
            "SELECT TRAFOUT_ADMDVS INSU_ADMDVS, count(*) `B01` " +
            "FROM rlts_traf_info_d a " +
            "   STRAIGHT_JOIN psn_info_b b ON a.PSN_NO = b.PSN_NO " +
            "   AND LEFT ( TRAFOUT_ADMDVS, 4 )= '1311' " +
            "   AND a.CRTE_TIME >= ? " +
            "   AND a.CRTE_TIME < ? " +
            "GROUP BY TRAFOUT_ADMDVS " +
            "ORDER BY TRAFOUT_ADMDVS;";

    //转出到省外合计
    private static final String SQL_QUERY_B02 = "" +
            "SELECT TRAFOUT_ADMDVS INSU_ADMDVS, count(*) `B02` " +
            "FROM rlts_traf_info_d a " +
            "   STRAIGHT_JOIN psn_info_b b ON a.PSN_NO = b.PSN_NO " +
            "   AND LEFT ( TRAFOUT_ADMDVS, 4 )= '1311' " +
            "   AND a.CRTE_TIME >= ? " +
            "   AND a.CRTE_TIME < ? " +
            "   AND LEFT ( TRAFIN_ADMDVS, 2 ) != '13' " +
            "GROUP BY TRAFOUT_ADMDVS;";

    //转出农民工合计
    private static final String SQL_QUERY_B03 = "" +
            "SELECT TRAFOUT_ADMDVS INSU_ADMDVS, count(*) `B03` " +
            "FROM rlts_traf_info_d a " +
            "   STRAIGHT_JOIN psn_info_b b ON a.PSN_NO = b.PSN_NO " +
            "   AND LEFT ( TRAFOUT_ADMDVS, 4 )= '1311' " +
            "   AND a.CRTE_TIME >= ? " +
            "   AND a.CRTE_TIME < ? " +
            "   AND b.RESD_NATU IN ( '20', '21', '22' ) " +
            "GROUP BY TRAFOUT_ADMDVS;";

    //转出农民工省外
    private static final String SQL_QUERY_B04 = "" +
            "SELECT TRAFOUT_ADMDVS INSU_ADMDVS, count(*) `B04` " +
            "FROM rlts_traf_info_d a " +
            "   STRAIGHT_JOIN psn_info_b b ON a.PSN_NO = b.PSN_NO " +
            "   AND LEFT ( TRAFOUT_ADMDVS, 4 )= '1311' " +
            "   AND a.CRTE_TIME >= ? " +
            "   AND a.CRTE_TIME < ? " +
            "   AND b.RESD_NATU IN ( '20', '21', '22' ) " +
            "   AND LEFT ( TRAFIN_ADMDVS, 2 ) != '13' " +
            "GROUP BY TRAFOUT_ADMDVS;";

    //转出地清算给个人合计
    private static final String SQL_QUERY_B05 = "" +
            "SELECT TRAFOUT_ADMDVS INSU_ADMDVS, IFNULL( sum( b.CRT_RETT_AMT ), 0 ) `B05` " +
            "FROM rlts_traf_info_d a " +
            "   STRAIGHT_JOIN acct_rett_d b ON LEFT ( TRAFOUT_ADMDVS, 4 )= '1311' " +
            "   AND a.CRTE_TIME >= ? " +
            "   AND a.CRTE_TIME < ? " +
            "   AND a.PSN_NO = b.PSN_NO " +
            "   AND a.PSN_INSU_RLTS_ID = b.PSN_INSU_RLTS_ID " +
            "GROUP BY TRAFOUT_ADMDVS;";

    //转出地清算给个人省外
    private static final String SQL_QUERY_B06 = "" +
            "SELECT TRAFOUT_ADMDVS INSU_ADMDVS, IFNULL( sum( b.CRT_RETT_AMT ), 0 ) `B06` " +
            "FROM rlts_traf_info_d a " +
            "   STRAIGHT_JOIN acct_rett_d b ON LEFT ( TRAFOUT_ADMDVS, 4 )= '1311' " +
            "   AND a.CRTE_TIME >= ? " +
            "   AND a.CRTE_TIME < ? " +
            "   AND a.PSN_NO = b.PSN_NO " +
            "   AND a.PSN_INSU_RLTS_ID = b.PSN_INSU_RLTS_ID " +
            "   AND LEFT ( TRAFIN_ADMDVS, 2 ) != '13' " +
            "GROUP BY TRAFOUT_ADMDVS;";

    private final JdbcTemplate jdbcTemplate;

    public Q36Rep(@Qualifier(Constant.BEAN_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Q36Do> getList(Q36Query query) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(query.getMonth().getTime());
        cal.set(
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),
                0,0,0);
        cal.add(Calendar.MONTH, 1);
        String maxSetlTime = DateTool.GetDateStr(cal.getTime());
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        String minSetlTime = DateTool.GetDateStr(cal.getTime());
        Map<String, Q36Do> map = new HashMap<>();
        List<Q36Do> list = getSubList("A01", SQL_QUERY_A01, minSetlTime, maxSetlTime);
        handleList(list, map);
        list = getSubList("A02", SQL_QUERY_A02, minSetlTime, maxSetlTime);
        handleList(list, map);
        list = getSubList("A03", SQL_QUERY_A03, minSetlTime, maxSetlTime);
        handleList(list, map);
        list = getSubList("A04", SQL_QUERY_A04, minSetlTime, maxSetlTime);
        handleList(list, map);
        list = getSubList("A05", SQL_QUERY_A05, minSetlTime, maxSetlTime);
        handleList(list, map);
        list = getSubList("A06", SQL_QUERY_A06, minSetlTime, maxSetlTime);
        handleList(list, map);
        list = getSubList("A07", SQL_QUERY_A07, minSetlTime, maxSetlTime);
        handleList(list, map);
        list = getSubList("B01", SQL_QUERY_B01, minSetlTime, maxSetlTime);
        handleList(list, map);
        list = getSubList("B02", SQL_QUERY_B02, minSetlTime, maxSetlTime);
        handleList(list, map);
        list = getSubList("B03", SQL_QUERY_B03, minSetlTime, maxSetlTime);
        handleList(list, map);
        list = getSubList("B04", SQL_QUERY_B04, minSetlTime, maxSetlTime);
        handleList(list, map);
        list = getSubList("B05", SQL_QUERY_B05, minSetlTime, maxSetlTime);
        handleList(list, map);
        list = getSubList("B06", SQL_QUERY_B06, minSetlTime, maxSetlTime);
        handleList(list, map);

        list = new ArrayList<>(map.values());
        Collections.sort(list);
        return list;
    }

    private List<Q36Do> getSubList(String k, String query, String minSetlTime, String maxSetlTime) {
        logger.debug(MessageFormat.format("Q35 SQL {0} {1} {2} {3}", k, query, minSetlTime,maxSetlTime));
        return jdbcTemplate.query(query, new Q36RowMapper(), minSetlTime, maxSetlTime);
    }

    private void handleList(List<Q36Do> list, Map<String, Q36Do> map) {
        String insuAdmdvs = "";
        for(Q36Do d : list) {
            insuAdmdvs = d.getInsuAdmdvs();
            if(map.containsKey(insuAdmdvs)) {
                map.put(insuAdmdvs, map.get(insuAdmdvs).add(d));
            } else {
                map.put(insuAdmdvs, d);
            }
        }
    }
}
