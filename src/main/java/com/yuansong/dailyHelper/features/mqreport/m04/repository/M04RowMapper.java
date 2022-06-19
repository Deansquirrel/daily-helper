package com.yuansong.dailyHelper.features.mqreport.m04.repository;

import com.github.deansquirrel.tools.common.SQLTool;
import com.yuansong.dailyHelper.features.mqreport.m03.repository.M03Do;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class M04RowMapper implements RowMapper<M04Do> {

    @Override
    public M04Do mapRow(ResultSet rs, int rowNum) throws SQLException {
        M04Do d = new M04Do();
        d.setInsuAdmdvs(SQLTool.getString(rs,"INSU_ADMDVS"));
        d.setUrrInsu(SQLTool.getLong(rs,"URR_INSU"));
        return d;
    }
}
