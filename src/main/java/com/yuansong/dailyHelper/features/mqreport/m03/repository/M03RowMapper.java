package com.yuansong.dailyHelper.features.mqreport.m03.repository;

import com.github.deansquirrel.tools.common.SQLTool;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class M03RowMapper implements RowMapper<M03Do> {

    @Override
    public M03Do mapRow(ResultSet rs, int rowNum) throws SQLException {
        M03Do d = new M03Do();
        d.setInsuAdmdvs(SQLTool.getString(rs,"INSU_ADMDVS"));
        d.setUrrInsu(SQLTool.getLong(rs,"URR_INSU"));
        return d;
    }
}
