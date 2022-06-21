package com.yuansong.dailyHelper.features.mqreport.m09.repository;

import com.github.deansquirrel.tools.common.SQLTool;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class M09RowMapper implements RowMapper<M09Do> {

    @Override
    public M09Do mapRow(ResultSet rs, int rowNum) throws SQLException {
        M09Do d = new M09Do();
        d.setInsuAdmdvs(SQLTool.getString(rs,"INSU_ADMDVS"));
        d.setUrrInsu(SQLTool.getLong(rs,"URR_INSU"));
        return d;
    }
}
