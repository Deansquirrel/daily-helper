package com.yuansong.dailyHelper.features.mqreport.q35.repository;

import com.github.deansquirrel.tools.common.SQLTool;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Q35RowMapper implements RowMapper<Q35Do> {


    @Override
    public Q35Do mapRow(ResultSet rs, int rowNum) throws SQLException {
        Q35Do d = new Q35Do();
        d.setPsnRange(SQLTool.getString(rs, "PSN_RANGE"));
        d.setInsuAdmdvs(SQLTool.getString(rs,"INSU_ADMDVS"));
        d.setHifpPay(SQLTool.getBigDecimal(rs,"hifp_pay"));
        d.setHifmiPay(SQLTool.getBigDecimal(rs, "HIFMI_PAY"));
        d.setMafPay(SQLTool.getBigDecimal(rs, "MAF_PAY"));
        d.setZiFu(SQLTool.getBigDecimal(rs,"zifu"));
        d.setZiFei(SQLTool.getBigDecimal(rs, "zifei"));
        d.setRenShu(SQLTool.getLong(rs, "REN_SHU"));
        d.setRenCi(SQLTool.getLong(rs, "REN_CI"));
        return d;
    }
}
