package com.yuansong.dailyHelper.features.common.c0001.repository;

import com.github.deansquirrel.tools.common.SQLTool;
import com.github.deansquirrel.tools.db.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

@Repository
public class C0001Rep {

    private static final Logger logger = LoggerFactory.getLogger(C0001Rep.class);

    private static final String SQL_QUERY = "" +
            "select CLR_OPTINS,FIXMEDINS_CODE, (SELECT FIXMEDINS_NAME FROM fixmedins_b m WHERE m.FIXMEDINS_CODE = a.FIXMEDINS_CODE) FIXMEDINS_NAME," +
            "   INSUTYPE, CLR_YM, sum(DPST_SUMAMT) DPST_SUMAMT, sum(ACT_DFR_AMT) ACT_DFR_AMT " +
            "from ( " +
            "   select CLR_OPTINS,FIXMEDINS_CODE, " +
            "       case " +
            "           when b.INSUTYPE in ('310','510') then '职工' " +
            "           when b.INSUTYPE in ('390') then '居民' " +
            "           when b.INSUTYPE in ('340') then '离休' " +
            "           else b.INSUTYPE " +
            "       end INSUTYPE, CLR_YM, DPST_SUMAMT,ACT_DFR_AMT " +
            "   from medins_clr_sum_d b " +
            "   where 1=1 and b.VALI_FLAG = '1' and b.CLR_YM >= '202103' " +
//            "       and b.CLR_OPTINS = '131102' " +
            "       and b.CLR_OPTINS like '1311%' " +
            "       and b.CLR_STAS = '60' " +
            ") a " +
            "group by FIXMEDINS_CODE, INSUTYPE, CLR_YM,CLR_OPTINS " +
            "order by CLR_OPTINS,FIXMEDINS_CODE, CLR_YM, INSUTYPE;";
    
    private static final String SQL_QUERY_SUB = "" +
            "select SUM(CASE WHEN LENGTH(CLR_TYPE) = 2 AND POOLAREA_FUND_PAY_TYPE in ('330101','390201','330100') THEN FUND_PAYAMT ELSE 0 END) BD " +
            "FROM ( " +
            "   select b.CLR_OPTINS,b.FIXMEDINS_CODE, " +
            "       case " +
            "           when b.INSUTYPE in ('310','510') then '职工' " +
            "           when b.INSUTYPE in ('390') then '居民' " +
            "           when b.INSUTYPE in ('340') then '离休' " +
            "           else b.INSUTYPE " +
            "       end INSUTYPE , b.CLR_TYPE, b.CLR_TYPE_LV2, b.CLR_YM, b.CLR_STAS, a.FUND_PAYAMT,a.POOLAREA_FUND_PAY_TYPE, c.INSU_ADMDVS, c.MED_TYPE,c.PSN_TYPE,b.MEDFEE_SUMAMT,b.FUND_APPY_SUM,b.DFR_AMT,b.DPST_SUMAMT,b.DET_SUMAMT,b.ACCT_PAY,b.ACT_DFR_AMT " +
            "from clred_fund_sbit_d a, medins_clr_sum_d b , clred_setl_d c " +
            "where 1=1 " +
            "   and a.FEE_CLR_ID = b.FEE_CLR_ID " +
            "   and a.CLR_APPY_EVT_ID = b.CLR_APPY_EVT_ID " +
            "   and a.psn_no = c.psn_no " +
            "   and a.SETL_ID = c.SETL_ID " +
            "   and a.VALI_FLAG = '1' and b.VALI_FLAG = '1' " +
            "   AND b.CLR_YM = ? " +
            "   and b.CLR_OPTINS = ? " +
            "   and b.CLR_OPTINS like '1311%' " +
            "   and b.CLR_STAS = '60' " +
            "   AND b.FIXMEDINS_CODE = ? " +
            ") a " +
            "GROUP BY FIXMEDINS_CODE,INSUTYPE,CLR_YM,CLR_OPTINS " +
            "HAVING INSUTYPE = ? ;";

    private final JdbcTemplate jdbcTemplate;

    public C0001Rep(@Qualifier(Constant.BEAN_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<C0001Do> getList() {
        List<C0001Do> list = new ArrayList<>();
        jdbcTemplate.query(SQL_QUERY, new RowCallbackHandler() {
            C0001Do d = null;
            long c = 0L;
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                c = c + 1;
                if(c % 200 == 0) {
                    logger.debug(MessageFormat.format("C0001 RowCallbackHandler {0}", c));
                }
                d = new C0001Do();
                d.setClrOptins(SQLTool.getString(rs,"CLR_OPTINS"));
                d.setFixmedinsCode(SQLTool.getString(rs, "FIXMEDINS_CODE"));
                d.setFixmedinsName(SQLTool.getString(rs, "FIXMEDINS_NAME"));
                d.setInsuType(SQLTool.getString(rs,"INSUTYPE"));
                d.setClrYm(SQLTool.getString(rs,"CLR_YM"));
                d.setDpstSumamt(SQLTool.getBigDecimal(rs, "DPST_SUMAMT"));
                d.setActDfrAmt(SQLTool.getBigDecimal(rs, "ACT_DFR_AMT"));
                List<BigDecimal> lBd = jdbcTemplate.queryForList(SQL_QUERY_SUB, BigDecimal.class,
                        d.getClrYm(), d.getClrOptins(), d.getFixmedinsCode(), d.getInsuType());
                if(!lBd.isEmpty()) {
                    d.setActDfrAmt(d.getActDfrAmt().add(lBd.get(0).multiply(BigDecimal.valueOf(-1))));
                }
                list.add(d);
            }
        });
        return list;
    }
    
}
