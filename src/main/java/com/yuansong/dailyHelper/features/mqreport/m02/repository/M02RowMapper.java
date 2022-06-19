package com.yuansong.dailyHelper.features.mqreport.m02.repository;

import com.github.deansquirrel.tools.common.SQLTool;
import com.yuansong.dailyHelper.features.mqreport.m01.repository.M01Do;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class M02RowMapper implements RowMapper<M02Do> {

    @Override
    public M02Do mapRow(ResultSet rs, int rowNum) throws SQLException {
        M02Do d = new M02Do();
        d.setInsuAdmdvs(SQLTool.getString(rs,"INSU_ADMDVS"));
        d.setUrrInsu(SQLTool.getLong(rs,"URR_INSU"));
        return d;
    }
}
