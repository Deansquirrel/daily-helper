package com.yuansong.dailyHelper.features.mqreport.q41.repository;

import com.github.deansquirrel.tools.common.SQLTool;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Q41RowMapper implements RowMapper<Q41Do> {


    @Override
    public Q41Do mapRow(ResultSet rs, int rowNum) throws SQLException {
        Q41Do d = new Q41Do();
        d.setMedType(SQLTool.getString(rs, "MED_TYPE"));
        d.setInsuAdmdvs(SQLTool.getString(rs,"INSU_ADMDVS"));
        d.setPsnCount(SQLTool.getLong(rs, "PSN_COUNT"));
        return d;
    }
}
