package com.yuansong.dailyHelper.features.mqreport.q38.repository;

import com.github.deansquirrel.tools.common.SQLTool;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Q38RowMapper implements RowMapper<Q38Do> {

    @Override
    public Q38Do mapRow(ResultSet rs, int rowNum) throws SQLException {
        Q38Do d = new Q38Do();
        d.setInsuAdmdvs(SQLTool.getString(rs,"INSU_ADMDVS"));
        d.setEmpType(SQLTool.getString(rs,"EMP_TYPE"));
        d.settCount(SQLTool.getLong(rs, "T_COUNT"));
        return d;
    }
}
