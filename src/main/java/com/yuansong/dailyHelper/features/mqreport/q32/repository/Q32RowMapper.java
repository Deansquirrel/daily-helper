package com.yuansong.dailyHelper.features.mqreport.q32.repository;

import com.github.deansquirrel.tools.common.SQLTool;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Q32RowMapper implements RowMapper<Q32Do> {


    @Override
    public Q32Do mapRow(ResultSet rs, int rowNum) throws SQLException {
        Q32Do d = new Q32Do();
        d.setInsuAdmdvs(SQLTool.getString(rs,"INSU_ADMDVS"));
        d.setSetlType(SQLTool.getString(rs, "SETL_TYPE"));
        d.setRenShu(SQLTool.getLong(rs, "REN_SHU"));
        d.setRenCi(SQLTool.getLong(rs, "REN_CI"));
        d.setMedfeeSumamt(SQLTool.getBigDecimal(rs,"MEDFEE_SUMAMT"));
        d.setHifpPay(SQLTool.getBigDecimal(rs,"hifp_pay"));
        d.setOtherPay(SQLTool.getBigDecimal(rs,"other_pay"));
        d.setZiFu(SQLTool.getBigDecimal(rs,"zifu"));
        d.setZiFei(SQLTool.getBigDecimal(rs, "zifei"));
        return d;
    }
}
