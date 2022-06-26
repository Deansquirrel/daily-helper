package com.yuansong.dailyHelper.features.mqreport.q10.repository;

import com.github.deansquirrel.tools.common.SQLTool;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Q10RowMapper implements RowMapper<Q10Do> {

    @Override
    public Q10Do mapRow(ResultSet rs, int rowNum) throws SQLException {
        Q10Do d = new Q10Do();
        d.setInsuAdmdvs(SQLTool.getString(rs,"INSU_ADMDVS"));
        d.setUrrInsu(SQLTool.getLong(rs,"URR_INSU"));
        return d;
    }
}
