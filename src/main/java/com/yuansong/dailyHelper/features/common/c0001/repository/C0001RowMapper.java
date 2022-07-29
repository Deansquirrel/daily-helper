package com.yuansong.dailyHelper.features.common.c0001.repository;

import com.github.deansquirrel.tools.common.SQLTool;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class C0001RowMapper implements RowMapper<C0001Do> {

    @Override
    public C0001Do mapRow(ResultSet rs, int rowNum) throws SQLException {
        C0001Do d = new C0001Do();
        d.setClrOptins(SQLTool.getString(rs,"CLR_OPTINS"));
        d.setFixmedinsCode(SQLTool.getString(rs, "FIXMEDINS_CODE"));
        d.setFixmedinsName(SQLTool.getString(rs, "FIXMEDINS_NAME"));
        d.setInsuType(SQLTool.getString(rs,"INSUTYPE"));
        d.setClrYm(SQLTool.getString(rs,"CLR_YM"));
        d.setDpstSumamt(SQLTool.getBigDecimal(rs, "DPST_SUMAMT"));
        d.setActDfrAmt(SQLTool.getBigDecimal(rs, "ACT_DFR_AMT"));
        return d;
    }
}
