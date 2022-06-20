package com.yuansong.dailyHelper.features.mqreport.m05.repository;

import com.github.deansquirrel.tools.common.SQLTool;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class M05RowMapper implements RowMapper<M05Do> {

    @Override
    public M05Do mapRow(ResultSet rs, int rowNum) throws SQLException {

        M05Do d = new M05Do();
        d.setInsuAdmdvs(SQLTool.getString(rs,"INSU_ADMDVS"));
        d.setA01(SQLTool.getLong(rs,"A01"));
        d.setB01(SQLTool.getLong(rs,"B01"));
        d.setC01(SQLTool.getLong(rs,"C01"));
        d.setC02(SQLTool.getLong(rs,"C02"));
        d.setD01(SQLTool.getLong(rs,"D01"));
        return d;
    }
}
