package com.yuansong.dailyHelper.features.mqreport.q11.repository;

import com.github.deansquirrel.tools.common.SQLTool;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Q11RowMapper implements RowMapper<Q11Do> {


    @Override
    public Q11Do mapRow(ResultSet rs, int rowNum) throws SQLException {
        Q11Do d = new Q11Do();
        d.setInsuAdmdvs(SQLTool.getString(rs,"INSU_ADMDVS"));
        d.setDedcHospLv(SQLTool.getString(rs,"DEDC_HOST_LV"));
        d.setMedfeeSumamt(SQLTool.getBigDecimal(rs,"MEDFEE_SUMAMT"));
        d.setHifpPay(SQLTool.getBigDecimal(rs,"hifp_pay"));
        d.setOtherPay(SQLTool.getBigDecimal(rs,"other_pay"));
        d.setZiFu(SQLTool.getBigDecimal(rs,"zifu"));
        d.setSelfPay(SQLTool.getBigDecimal(rs,"self_pay"));
        d.setAcctPay(SQLTool.getBigDecimal(rs,"ACCT_PAY"));
        d.setFulamtOwnpayAmt(SQLTool.getBigDecimal(rs,"FULAMT_OWNPAY_AMT"));
        d.settCount(SQLTool.getLong(rs,"T_COUNT"));
        d.setInHostDay(SQLTool.getLong(rs, "IN_HOST_DAY"));
        return d;
    }
}
