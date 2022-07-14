package com.yuansong.dailyHelper.features.sjsc.repository;

import com.alibaba.druid.sql.ast.SQLAdhocTableSource;
import com.github.deansquirrel.tools.common.SQLTool;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SJSCRowMapper implements RowMapper<SJSCDo> {
    @Override
    public SJSCDo mapRow(ResultSet rs, int rowNum) throws SQLException {
        SJSCDo d = new SJSCDo();
        d.setA01(SQLTool.getString(rs, "A01"));
        d.setA02(SQLTool.getString(rs, "A02"));
        d.setA03(SQLTool.getString(rs, "A03"));
        d.setA04(SQLTool.getString(rs, "A04"));
        d.setA05(SQLTool.getString(rs, "A05"));
        d.setA06(SQLTool.getString(rs, "A06"));
        d.setA07(SQLTool.getString(rs, "A07"));
        d.setA08(SQLTool.getDatetime(rs, "A08"));
        d.setA09(SQLTool.getDatetime(rs, "A09"));
        d.setA10(SQLTool.getDatetime(rs, "A10"));
        d.setA11(SQLTool.getString(rs, "A11"));
        d.setA12(SQLTool.getDatetime(rs, "A12"));
        return d;
    }
}
