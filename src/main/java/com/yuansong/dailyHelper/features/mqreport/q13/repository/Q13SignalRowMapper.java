package com.yuansong.dailyHelper.features.mqreport.q13.repository;

import com.github.deansquirrel.tools.common.SQLTool;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Q13SignalRowMapper implements RowMapper<Q13Do> {


    @Override
    public Q13Do mapRow(ResultSet rs, int rowNum) throws SQLException {
        Q13Do d = new Q13Do();
        d.setA01(SQLTool.getBigDecimal(rs, "A01"));
        d.setA02(SQLTool.getBigDecimal(rs, "A02"));
        d.setB01(SQLTool.getBigDecimal(rs, "B01"));
        d.setB02(SQLTool.getBigDecimal(rs, "B02"));
        d.setC01(SQLTool.getBigDecimal(rs, "C01"));
        d.setC02(SQLTool.getBigDecimal(rs, "C02"));
        return d;
    }
}
