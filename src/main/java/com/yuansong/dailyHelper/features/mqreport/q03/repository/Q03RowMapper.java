package com.yuansong.dailyHelper.features.mqreport.q03.repository;

import com.github.deansquirrel.tools.common.SQLTool;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Q03RowMapper implements RowMapper<Q03Do> {


    @Override
    public Q03Do mapRow(ResultSet rs, int rowNum) throws SQLException {
        Q03Do d = new Q03Do();
        d.setInsuAdmdvs(SQLTool.getString(rs,"INSU_ADMDVS"));
        d.setClctSumamt(SQLTool.getBigDecimal(rs,"CLCT_SUMAMT"));
        return d;
    }
}
