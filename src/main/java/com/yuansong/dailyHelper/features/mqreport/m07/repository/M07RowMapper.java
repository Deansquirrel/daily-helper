package com.yuansong.dailyHelper.features.mqreport.m07.repository;

import com.github.deansquirrel.tools.common.SQLTool;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class M07RowMapper implements RowMapper<M07Do> {

    @Override
    public M07Do mapRow(ResultSet rs, int rowNum) throws SQLException {
        M07Do d = new M07Do();
        d.setInsuAdmdvs(SQLTool.getString(rs,"INSU_ADMDVS"));
        d.setUrrInsu(SQLTool.getLong(rs,"URR_INSU"));
        return d;
    }
}
