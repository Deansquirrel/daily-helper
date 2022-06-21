package com.yuansong.dailyHelper.features.mqreport.m08.repository;

import com.github.deansquirrel.tools.common.SQLTool;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class M08RowMapper implements RowMapper<M08Do> {

    @Override
    public M08Do mapRow(ResultSet rs, int rowNum) throws SQLException {
        M08Do d = new M08Do();
        d.setInsuAdmdvs(SQLTool.getString(rs,"INSU_ADMDVS"));
        d.setUrrInsu(SQLTool.getLong(rs,"URR_INSU"));
        return d;
    }
}
