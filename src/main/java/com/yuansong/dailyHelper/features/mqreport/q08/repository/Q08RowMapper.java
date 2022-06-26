package com.yuansong.dailyHelper.features.mqreport.q08.repository;

import com.github.deansquirrel.tools.common.SQLTool;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Q08RowMapper implements RowMapper<Q08Do> {


    @Override
    public Q08Do mapRow(ResultSet rs, int rowNum) throws SQLException {
        Q08Do d = new Q08Do();
        d.setInsuAdmdvs(SQLTool.getString(rs,"INSU_ADMDVS"));
        d.setPsnType(SQLTool.getString(rs,"PSN_TYPE"));
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
