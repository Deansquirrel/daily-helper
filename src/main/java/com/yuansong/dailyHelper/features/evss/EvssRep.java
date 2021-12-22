package com.yuansong.dailyHelper.features.evss;

import com.github.deansquirrel.tools.common.SQLTool;
import com.github.deansquirrel.tools.db.Constant;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EvssRep {

    private final JdbcTemplate jdbcTemplate;

    public EvssRep(@Qualifier(Constant.BEAN_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private String sql = "" +
            "SELECT " +
            " b.FIX_BLNG_ADMDVS, " +
            " b.FIXMEDINS_CODE, " +
            " b.FIXMEDINS_NAME, " +
            " a.TOTAL_RC, " +
            " a.SBK_RC, " +
            " a.DZPZ_RC, " +
            " a.DZPZ_RS, " +
            " a.CURR_TOTAL_TC, " +
            " a.CURR_SBK_RC, " +
            " a.CURR_DZPZ_RC, " +
            " a.CURR_DZPZ_RS " +
            "FROM " +
            " fixmedins_b b " +
            " LEFT JOIN ( " +
            " SELECT " +
            "  FIXMEDINS_CODE, " +
            "  sum(TOTAL_RC) TOTAL_RC, " +
            "  sum(SBK_RC) SBK_RC, " +
            "  sum(DZPZ_RC) DZPZ_RC, " +
            "  sum(DZPZ_RS) DZPZ_RS, " +
            "  sum(CURR_TOTAL_TC) CURR_TOTAL_TC, " +
            "  sum(CURR_SBK_RC) CURR_SBK_RC, " +
            "  sum(CURR_DZPZ_RC) CURR_DZPZ_RC, " +
            "  sum(CURR_DZPZ_RS) CURR_DZPZ_RS  " +
            " FROM " +
            "  ( " +
            "  SELECT FIXMEDINS_CODE, count(*) TOTAL_RC, sum( CASE MDTRT_CERT_TYPE WHEN '01' THEN 0 ELSE 1 END ) SBK_RC, sum( CASE MDTRT_CERT_TYPE WHEN '01' THEN 1 ELSE 0 END ) DZPZ_RC, 0 DZPZ_RS, 0 CURR_TOTAL_TC, 0 CURR_SBK_RC, 0 CURR_DZPZ_RC, 0 CURR_DZPZ_RS  " +
            "  FROM " +
            "   setl_d FORCE INDEX ( IDX_SETL_D_3 )  " +
            "  WHERE 1=1 " +
            "   AND SETL_TIME >= '2021-03-13 00:00:00'  " +
            "   AND SETL_TIME < '2021-12-01 00:00:00'  " +
            "   AND ( FIXMEDINS_CODE LIKE 'H1311%' OR FIXMEDINS_CODE LIKE 'P1311%' )  " +
            "  GROUP BY FIXMEDINS_CODE  " +
            "UNION ALL " +
            "  SELECT " +
            "   FIXMEDINS_CODE, 0, 0, 0, count( DISTINCT psn_no ), 0, 0, 0, 0  " +
            "  FROM " +
            "   setl_d FORCE INDEX ( IDX_SETL_D_3 )  " +
            "  WHERE 1=1 " +
            "   AND SETL_TIME >= '2021-03-13 00:00:00'  " +
            "   AND SETL_TIME < '2021-12-01 00:00:00'  " +
            "   AND MDTRT_CERT_TYPE = '01'  " +
            "   AND ( FIXMEDINS_CODE LIKE 'H1311%' OR FIXMEDINS_CODE LIKE 'P1311%' )  " +
            "  GROUP BY FIXMEDINS_CODE  " +
            "UNION ALL " +
            "  SELECT " +
            "   FIXMEDINS_CODE, 0, 0, 0, 0, count(*), sum( CASE MDTRT_CERT_TYPE WHEN '01' THEN 0 ELSE 1 END ), sum( CASE MDTRT_CERT_TYPE WHEN '01' THEN 1 ELSE 0 END ), 0  " +
            "  FROM " +
            "   setl_d FORCE INDEX ( IDX_SETL_D_3 )  " +
            "  WHERE 1=1 " +
            "   AND SETL_TIME >= '2021-12-01 00:00:00'  " +
            "   AND SETL_TIME < '2021-12-21 00:00:00'  " +
            "   AND ( FIXMEDINS_CODE LIKE 'H1311%' OR FIXMEDINS_CODE LIKE 'P1311%' )  " +
            "  GROUP BY FIXMEDINS_CODE   " +
            " UNION ALL    " +
            "  SELECT " +
            "   FIXMEDINS_CODE, 0, 0, 0, 0, 0, 0, 0, count( DISTINCT psn_no )  " +
            "  FROM " +
            "   setl_d FORCE INDEX ( IDX_SETL_D_3 )  " +
            "  WHERE 1=1 " +
            "   AND SETL_TIME >= '2021-12-01 00:00:00'  " +
            "   AND SETL_TIME < '2021-12-21 00:00:00'  " +
            "   AND MDTRT_CERT_TYPE = '01'  " +
            "   AND ( FIXMEDINS_CODE LIKE 'H1311%' OR FIXMEDINS_CODE LIKE 'P1311%' )  " +
            "  GROUP BY FIXMEDINS_CODE  " +
            "  ) A  " +
            " GROUP BY " +
            "  FIXMEDINS_CODE  " +
            " ) a ON a.FIXMEDINS_CODE = b.FIXMEDINS_CODE  " +
            "WHERE 1=1 " +
            " AND (b.FIXMEDINS_CODE LIKE 'H1311%' OR b.FIXMEDINS_CODE LIKE 'P1311%')";


    public List<EvssDO> getList() {
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            EvssDO d = new EvssDO();
//                private String fixBlngAdmdvs; // 行政区划编码
            d.setFixBlngAdmdvs(SQLTool.getString(rs, "行政区划编码"));
//                private String fixmedinsCode; // 定点医药机构编码
            d.setFixmedinsCode(SQLTool.getString(rs, "定点医药机构编码"));
//                private String fixmedinsName; // 定点医药机构名称,
            d.setFixmedinsName(SQLTool.getString(rs, "定点医药机构名称"));
            return d;
        });
    }

}
