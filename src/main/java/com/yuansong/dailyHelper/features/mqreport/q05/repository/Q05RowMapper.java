package com.yuansong.dailyHelper.features.mqreport.q05.repository;

import com.github.deansquirrel.tools.common.SQLTool;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Q05RowMapper implements RowMapper<Q05Do> {


    @Override
    public Q05Do mapRow(ResultSet rs, int rowNum) throws SQLException {
        Q05Do d = new Q05Do();
        d.setInsuAdmdvs(SQLTool.getString(rs,"INSU_ADMDVS"));
        d.setDedcHospLv(SQLTool.getString(rs,"DEDC_HOSP_LV"));
        d.setMedfeeSumamt(SQLTool.getBigDecimal(rs,"MEDFEE_SUMAMT"));
        d.setHifpPay(SQLTool.getBigDecimal(rs,"hifp_pay"));
        d.setOtherPay(SQLTool.getBigDecimal(rs,"other_pay"));
        d.setZiFu(SQLTool.getBigDecimal(rs,"zifu"));
        d.setSelfPay(SQLTool.getBigDecimal(rs,"self_pay"));
        d.setAcctPay(SQLTool.getBigDecimal(rs,"ACCT_PAY"));
        d.setFulamtOwnpayAmt(SQLTool.getBigDecimal(rs,"FULAMT_OWNPAY_AMT"));
        d.settCount(SQLTool.getLong(rs,"T_COUNT"));
        return d;
    }
}
