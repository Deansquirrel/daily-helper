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
        List<String> columns = this.getColumnLabel(rs);
        M05Do d = new M05Do();
        d.setInsuAdmdvs(SQLTool.getString(rs,"INSU_ADMDVS"));
        if(columns.contains("A01")) {
            d.setA01(SQLTool.getLong(rs,"A01"));
        }
        if(columns.contains("B01")) {
            d.setA01(SQLTool.getLong(rs,"B01"));
        }
        if(columns.contains("C01")) {
            d.setA01(SQLTool.getLong(rs,"C01"));
        }
        if(columns.contains("C02")) {
            d.setA01(SQLTool.getLong(rs,"C02"));
        }
        if(columns.contains("D01")) {
            d.setA01(SQLTool.getLong(rs,"D01"));
        }
        return d;
    }

    private List<String> getColumnLabel(ResultSet rs) throws SQLException {
        ResultSetMetaData resultSetMetaData = rs.getMetaData();
        List<String> list = new ArrayList<>();
        for(int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
            list.add(resultSetMetaData.getColumnLabel(i));
        }
        return list;
    }
}
