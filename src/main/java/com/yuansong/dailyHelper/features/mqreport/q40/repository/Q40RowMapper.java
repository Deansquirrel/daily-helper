package com.yuansong.dailyHelper.features.mqreport.q40.repository;

import com.github.deansquirrel.tools.common.SQLTool;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Q40RowMapper implements RowMapper<Q40Do> {

    @Override
    public Q40Do mapRow(ResultSet rs, int rowNum) throws SQLException {
        Q40Do d = new Q40Do();
        d.setInsuAdmdvs(SQLTool.getString(rs,"INSU_ADMDVS"));
        d.setEmpType(SQLTool.getString(rs,"EMP_TYPE"));
        d.setEmpCount(SQLTool.getLong(rs,"EMP_COUNT"));
        d.setPsnCount(SQLTool.getLong(rs,"PSN_COUNT"));
        return d;
    }
}
