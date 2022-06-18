package com.yuansong.dailyHelper.features.mqreport.m01.repository;

import com.github.deansquirrel.tools.common.SQLTool;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class M01RowMapper implements RowMapper<M01Do> {

    @Override
    public M01Do mapRow(ResultSet rs, int rowNum) throws SQLException {
        M01Do d = new M01Do();
        d.setInsuAdmdvs(SQLTool.getString(rs,"INSU_ADMDVS"));
        d.setUrrInsu(SQLTool.getLong(rs,"URR_INSU"));
        return d;
    }
}
