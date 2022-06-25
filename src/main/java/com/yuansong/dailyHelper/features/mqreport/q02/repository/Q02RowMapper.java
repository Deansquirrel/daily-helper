package com.yuansong.dailyHelper.features.mqreport.q02.repository;

import com.github.deansquirrel.tools.common.SQLTool;
import com.yuansong.dailyHelper.features.mqreport.q02.repository.Q02Do;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Q02RowMapper implements RowMapper<Q02Do> {


    @Override
    public Q02Do mapRow(ResultSet rs, int rowNum) throws SQLException {
        Q02Do d = new Q02Do();
        d.setInsuAdmdvs(SQLTool.getString(rs,"INSU_ADMDVS"));
        d.setEmpType(SQLTool.getString(rs,"EMP_TYPE"));
        d.setEmpClctStd(SQLTool.getBigDecimal(rs, "EMP_CLCTSTD"));
        d.setPsnClctStd(SQLTool.getBigDecimal(rs, "PSN_CLCTSTD"));
        d.setEmpClctAmt(SQLTool.getBigDecimal(rs,"EMP_CLCT_AMT"));
        d.setPsnClctAmt(SQLTool.getBigDecimal(rs,"PSN_CLCT_AMT"));
        d.setEmpClctIntoAcctAmt(SQLTool.getBigDecimal(rs,"EMP_CLCT_INTO_ACCT_AMT"));
        d.setEmpClctIntoRetrAcctAmt(SQLTool.getBigDecimal(rs,"EMP_CLCT_INTO_RETR_ACCT_AMT"));
        return d;
    }
}
