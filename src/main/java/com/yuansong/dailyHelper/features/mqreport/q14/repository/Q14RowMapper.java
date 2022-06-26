package com.yuansong.dailyHelper.features.mqreport.q14.repository;

import com.github.deansquirrel.tools.common.SQLTool;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Q14RowMapper implements RowMapper<Q14Do> {

    @Override
    public Q14Do mapRow(ResultSet rs, int rowNum) throws SQLException {
        Q14Do d = new Q14Do();
        d.setInsuAdmdvs(SQLTool.getString(rs,"INSU_ADMDVS"));
        d.setUrrInsu(SQLTool.getLong(rs,"URR_INSU"));
        return d;
    }
}
