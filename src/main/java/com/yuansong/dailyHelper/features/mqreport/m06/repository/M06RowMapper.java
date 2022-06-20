package com.yuansong.dailyHelper.features.mqreport.m06.repository;

import com.github.deansquirrel.tools.common.SQLTool;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class M06RowMapper implements RowMapper<M06Do> {

    @Override
    public M06Do mapRow(ResultSet rs, int rowNum) throws SQLException {
        M06Do d = new M06Do();
        d.setInsuAdmdvs(SQLTool.getString(rs,"INSU_ADMDVS"));
        d.setUrrInsu(SQLTool.getLong(rs,"URR_INSU"));
        return d;
    }
}
