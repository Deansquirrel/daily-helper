package com.yuansong.dailyHelper.features.mqreport.q42.repository;

import com.github.deansquirrel.tools.common.SQLTool;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Q42RowMapper implements RowMapper<Q42Do> {


    @Override
    public Q42Do mapRow(ResultSet rs, int rowNum) throws SQLException {
        Q42Do d = new Q42Do();
        d.setInsuAdmdvs(SQLTool.getString(rs,"INSU_ADMDVS"));
        d.setInsuType(SQLTool.getString(rs, "INSUTYPE"));
        d.setA01(SQLTool.getLong(rs, "A01"));
        d.setA02(SQLTool.getLong(rs, "A02"));
        return d;
    }
}
