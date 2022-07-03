package com.yuansong.dailyHelper.features.mqreport.q36.repository;

import com.github.deansquirrel.tools.common.SQLTool;
import com.yuansong.dailyHelper.util.tool.CommonUtil;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Q36RowMapper implements RowMapper<Q36Do> {


    @Override
    public Q36Do mapRow(ResultSet rs, int rowNum) throws SQLException {
        Q36Do d = new Q36Do();
        d.setInsuAdmdvs(SQLTool.getString(rs, "INSU_ADMDVS"));
        if(CommonUtil.isExistColumn(rs, "A01")) {
            d.setA01(SQLTool.getLong(rs, "A01"));
        }
        if(CommonUtil.isExistColumn(rs, "A02")) {
            d.setA02(SQLTool.getLong(rs, "A02"));
        }
        if(CommonUtil.isExistColumn(rs, "A03")) {
            d.setA03(SQLTool.getLong(rs, "A03"));
        }
        if(CommonUtil.isExistColumn(rs, "A04")) {
            d.setA04(SQLTool.getLong(rs, "A04"));
        }
        if(CommonUtil.isExistColumn(rs, "A05")) {
            d.setA05(SQLTool.getLong(rs, "A05"));
        }
        if(CommonUtil.isExistColumn(rs, "A06")) {
            d.setA06(SQLTool.getLong(rs, "A06"));
        }
        if(CommonUtil.isExistColumn(rs, "A07")) {
            d.setA07(SQLTool.getBigDecimal(rs, "A07"));
        }
        if(CommonUtil.isExistColumn(rs, "B01")) {
            d.setB01(SQLTool.getLong(rs, "B01"));
        }
        if(CommonUtil.isExistColumn(rs, "B02")) {
            d.setB02(SQLTool.getLong(rs, "B02"));
        }
        if(CommonUtil.isExistColumn(rs, "B03")) {
            d.setB03(SQLTool.getLong(rs, "B03"));
        }
        if(CommonUtil.isExistColumn(rs, "B04")) {
            d.setB04(SQLTool.getLong(rs, "B04"));
        }
        if(CommonUtil.isExistColumn(rs, "B05")) {
            d.setB05(SQLTool.getBigDecimal(rs, "B05"));
        }
        if(CommonUtil.isExistColumn(rs, "B06")) {
            d.setB06(SQLTool.getBigDecimal(rs, "B06"));
        }
        return d;
    }
}
