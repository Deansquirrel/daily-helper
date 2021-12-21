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
            "select b.FIX_BLNG_ADMDVS 行政区划编码, b.FIXMEDINS_CODE 定点医药机构编码, b.FIXMEDINS_NAME 定点医药机构名称," +
            "  A.结算总人次," +
            "  A.社保卡结算人次," +
            "  A.电子凭证结算人次," +
            "  A.电子凭证结算人数," +
            "  A.`10月结算总人次`," +
            "  A.`10月社保卡结算人次`," +
            "  A.`10月电子凭证结算人次`," +
            "  A.`10月电子凭证结算人数`," +
            "  A.结算总人次," +
            "  A.社保卡结算人次," +
            "  A.电子凭证结算人次," +
            "  A.电子凭证结算人数," +
            "  A.`10月结算总人次`," +
            "  A.`10月社保卡结算人次`," +
            "  A.`10月电子凭证结算人次`," +
            "  A.`10月电子凭证结算人数`" +
            "from fixmedins_b b " +
            "left join (" +
            "  SELECT 定点医药机构编码, sum(结算总人次) 结算总人次, sum(社保卡结算人次) 社保卡结算人次, sum(电子凭证结算人次) 电子凭证结算人次, sum(电子凭证结算人数) 电子凭证结算人数, sum( `10月结算总人次`) `10月结算总人次`, sum( `10月社保卡结算人次` ) `10月社保卡结算人次`, sum( `10月电子凭证结算人次` ) `10月电子凭证结算人次`, sum( `10月电子凭证结算人数` ) `10月电子凭证结算人数`" +
            "  FROM (" +
            "    SELECT" +
            "     FIXMEDINS_CODE 定点医药机构编码, count(*) 结算总人次,  sum( CASE MDTRT_CERT_TYPE WHEN '01' THEN 0 ELSE 1 END ) 社保卡结算人次,  sum( CASE MDTRT_CERT_TYPE WHEN '01' THEN 1 ELSE 0 END ) 电子凭证结算人次,  0 电子凭证结算人数," +
            "     0 `10月结算总人次`,  0 `10月社保卡结算人次`,  0 `10月电子凭证结算人次`,  0 `10月电子凭证结算人数` " +
            "    FROM setl_d force index (IDX_SETL_D_3)" +
            "    WHERE SETL_TIME >= '2021-03-13 00:00:00'   AND SETL_TIME < '2021-12-01 00:00:00' " +
            "     and (FIXMEDINS_CODE like 'H1311%' OR FIXMEDINS_CODE LIKE 'P1311%')" +
            "    GROUP BY FIXMEDINS_CODE" +
            "    UNION ALL" +
            "    SELECT FIXMEDINS_CODE," +
            "     0,  0,  0,  count( DISTINCT psn_no )," +
            "     0,  0,  0,  0 " +
            "    FROM setl_d force index (IDX_SETL_D_3)" +
            "    WHERE SETL_TIME >= '2021-03-13 00:00:00' AND SETL_TIME < '2021-12-01 00:00:00' AND MDTRT_CERT_TYPE = '01' " +
            "     and (FIXMEDINS_CODE like 'H1311%' OR FIXMEDINS_CODE LIKE 'P1311%')" +
            "    GROUP BY FIXMEDINS_CODE" +
            "    UNION ALL" +
            "    " +
            "    SELECT" +
            "     FIXMEDINS_CODE," +
            "     0,  0,  0,  0," +
            "     count(*),  sum( CASE MDTRT_CERT_TYPE WHEN '01' THEN 0 ELSE 1 END ),  sum( CASE MDTRT_CERT_TYPE WHEN '01' THEN 1 ELSE 0 END ),  0 " +
            "    FROM setl_d force index (IDX_SETL_D_3)" +
            "    WHERE SETL_TIME >= '2021-12-01 00:00:00' AND SETL_TIME < '2021-12-21 00:00:00' " +
            "     and (FIXMEDINS_CODE like 'H1311%' OR FIXMEDINS_CODE LIKE 'P1311%')" +
            "    GROUP BY FIXMEDINS_CODE" +
            "    UNION ALL" +
            "    SELECT" +
            "     FIXMEDINS_CODE," +
            "     0,  0,  0,  0," +
            "     0,  0,  0,  count( DISTINCT psn_no ) " +
            "    FROM setl_d force index (IDX_SETL_D_3)" +
            "    WHERE SETL_TIME >= '2021-12-01 00:00:00' AND SETL_TIME < '2021-12-21 00:00:00' AND MDTRT_CERT_TYPE = '01'" +
            "     and (FIXMEDINS_CODE like 'H1311%' OR FIXMEDINS_CODE LIKE 'P1311%')" +
            "    GROUP BY FIXMEDINS_CODE" +
            "  ) A" +
            "  group by 定点医药机构编码" +
            ") a on a.定点医药机构编码 = b.FIXMEDINS_CODE" +
            " where b.FIXMEDINS_CODE like 'H1311%' OR B.FIXMEDINS_CODE LIKE 'P1311%' ";

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
