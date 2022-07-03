package com.yuansong.dailyHelper.features.mqreport.q37.repository;

import com.github.deansquirrel.tools.common.SQLTool;
import com.yuansong.dailyHelper.util.tool.CommonUtil;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Q37RowMapper implements RowMapper<Q37Do> {


    @Override
    public Q37Do mapRow(ResultSet rs, int rowNum) throws SQLException {
        Q37Do d = new Q37Do();
        d.setInsuAdmdvs(SQLTool.getString(rs,"INSU_ADMDVS"));
        d.setEmpType(SQLTool.getString(rs,"EMP_TYPE"));
        if(CommonUtil.isExistColumn(rs, "A01")) {
            d.setA01(SQLTool.getBigDecimal(rs, "A01"));
        };
        if(CommonUtil.isExistColumn(rs, "A02")) {
            d.setA02(SQLTool.getLong(rs, "A02"));
        }
        if(CommonUtil.isExistColumn(rs, "B01")) {
            d.setB01(SQLTool.getBigDecimal(rs, "B01"));
        };
        if(CommonUtil.isExistColumn(rs, "B02")) {
            d.setB02(SQLTool.getLong(rs, "B02"));
        }
        if(CommonUtil.isExistColumn(rs, "C01")) {
            d.setC01(SQLTool.getBigDecimal(rs, "C01"));
        };
        if(CommonUtil.isExistColumn(rs, "C02")) {
            d.setC02(SQLTool.getLong(rs, "C02"));
        }
        if(CommonUtil.isExistColumn(rs, "D01")) {
            d.setD01(SQLTool.getBigDecimal(rs, "D01"));
        };
        if(CommonUtil.isExistColumn(rs, "D02")) {
            d.setD02(SQLTool.getLong(rs, "D02"));
        }
        if(CommonUtil.isExistColumn(rs, "E01")) {
            d.setE01(SQLTool.getBigDecimal(rs, "E01"));
        };
        if(CommonUtil.isExistColumn(rs, "E02")) {
            d.setE02(SQLTool.getLong(rs, "E02"));
        }
        if(CommonUtil.isExistColumn(rs, "F01")) {
            d.setF01(SQLTool.getLong(rs, "F01"));
        }
        if(CommonUtil.isExistColumn(rs, "F02")) {
            d.setF02(SQLTool.getLong(rs, "F02"));
        }
        return d;
    }
}
