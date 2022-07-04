package com.yuansong.dailyHelper.features.mqreport.q39.repository;

import com.github.deansquirrel.tools.common.SQLTool;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Q39RowMapper implements RowMapper<Q39Do> {


    @Override
    public Q39Do mapRow(ResultSet rs, int rowNum) throws SQLException {
        Q39Do d = new Q39Do();
        d.setInsuType(SQLTool.getString(rs, "INSUTYPE"));
        d.setInsuAdmdvs(SQLTool.getString(rs,"INSU_ADMDVS"));
        d.setEmpType(SQLTool.getString(rs,"EMP_TYPE"));
        d.settCount(SQLTool.getLong(rs, "T_COUNT"));
        return d;
    }
}
