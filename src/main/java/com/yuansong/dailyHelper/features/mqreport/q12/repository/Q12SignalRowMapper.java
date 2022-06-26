package com.yuansong.dailyHelper.features.mqreport.q12.repository;

import com.github.deansquirrel.tools.common.SQLTool;
import com.yuansong.dailyHelper.features.mqreport.q12.repository.Q12Do;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Q12SignalRowMapper implements RowMapper<Q12Do> {


    @Override
    public Q12Do mapRow(ResultSet rs, int rowNum) throws SQLException {
        Q12Do d = new Q12Do();
        d.setA01(SQLTool.getBigDecimal(rs, "A01"));
        d.setA02(SQLTool.getBigDecimal(rs, "A02"));
        d.setB01(SQLTool.getBigDecimal(rs, "B01"));
        d.setB02(SQLTool.getBigDecimal(rs, "B02"));
        d.setC01(SQLTool.getBigDecimal(rs, "C01"));
        d.setC02(SQLTool.getBigDecimal(rs, "C02"));
        return d;
    }
}
