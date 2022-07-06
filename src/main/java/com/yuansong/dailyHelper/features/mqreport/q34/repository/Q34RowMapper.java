package com.yuansong.dailyHelper.features.mqreport.q34.repository;

import com.github.deansquirrel.tools.common.SQLTool;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Q34RowMapper implements RowMapper<Q34Do> {

    @Override
    public Q34Do mapRow(ResultSet rs, int rowNum) throws SQLException {
        Q34Do d = new Q34Do();
        d.setInsuAdmdvs(SQLTool.getString(rs,"INSU_ADMDVS"));
        d.setSetlType(SQLTool.getString(rs, "SETL_TYPE"));
        d.setUrrInsu(SQLTool.getLong(rs,"URR_INSU"));
        return d;
    }
}
