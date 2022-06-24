package com.yuansong.dailyHelper.features.mqreport.q01.repository;

import com.github.deansquirrel.tools.common.SQLTool;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Q01RowMapper implements RowMapper<Q01Do> {


    @Override
    public Q01Do mapRow(ResultSet rs, int rowNum) throws SQLException {
        Q01Do d = new Q01Do();
        d.setInsuAdmdvs(SQLTool.getString(rs,"INSU_ADMDVS"));
        d.setEmpType(SQLTool.getString(rs,"EMP_TYPE"));
        d.setEmpCount(SQLTool.getLong(rs,"EMP_COUNT"));
        d.setPsnCount(SQLTool.getLong(rs,"PSN_COUNT"));
        d.setRetrCount(SQLTool.getLong(rs,"RETR_COUNT"));
        d.setRetrFemaleCount(SQLTool.getLong(rs,"RETR_FEMALE_COUNT"));
        d.setFemaleCount(SQLTool.getLong(rs,"FEMALE_COUNT"));
        return d;
    }
}
