package com.yuansong.dailyHelper.features.mqreport.q21.repository;

import com.github.deansquirrel.tools.common.SQLTool;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Q21RowMapper implements RowMapper<Q21Do> {


    @Override
    public Q21Do mapRow(ResultSet rs, int rowNum) throws SQLException {
        Q21Do d = new Q21Do();
        d.setInsuAdmdvs(SQLTool.getString(rs,"INSU_ADMDVS"));
        d.setPsnType(SQLTool.getString(rs,"PSN_TYPE"));
        d.setMedfeeSumamt(SQLTool.getBigDecimal(rs,"MEDFEE_SUMAMT"));
        d.setHifpPay(SQLTool.getBigDecimal(rs,"hifp_pay"));
        d.setHifmiPay(SQLTool.getBigDecimal(rs, "HIFMI_PAY"));
        d.setOtherPay(SQLTool.getBigDecimal(rs,"other_pay"));
        d.setZiFu(SQLTool.getBigDecimal(rs,"zifu"));
        d.setZiFei(SQLTool.getBigDecimal(rs, "zifei"));
        d.setAcctPay(SQLTool.getBigDecimal(rs,"ACCT_PAY"));
        d.setMuLuWai(SQLTool.getBigDecimal(rs, "muluwai"));
        d.settCount(SQLTool.getLong(rs,"T_COUNT"));
        d.setInHostDay(SQLTool.getLong(rs, "IN_HOST_DAY"));
        return d;
    }
}
