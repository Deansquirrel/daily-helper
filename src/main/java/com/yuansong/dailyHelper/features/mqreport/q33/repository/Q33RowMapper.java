package com.yuansong.dailyHelper.features.mqreport.q33.repository;

import com.github.deansquirrel.tools.common.SQLTool;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Q33RowMapper implements RowMapper<Q33Do> {


    @Override
    public Q33Do mapRow(ResultSet rs, int rowNum) throws SQLException {
        Q33Do d = new Q33Do();
        d.setInsuAdmdvs(SQLTool.getString(rs,"INSU_ADMDVS"));
        d.setSetlType(SQLTool.getString(rs, "SETL_TYPE"));
        d.setRenShu(SQLTool.getLong(rs, "REN_SHU"));
        d.setRenCi(SQLTool.getLong(rs, "REN_CI"));
        d.setMedfeeSumamt(SQLTool.getBigDecimal(rs,"MEDFEE_SUMAMT"));
        d.setHifpPay(SQLTool.getBigDecimal(rs,"hifp_pay"));
        d.setHifmiPay(SQLTool.getBigDecimal(rs, "HIFMI_PAY"));
        d.setOtherPay(SQLTool.getBigDecimal(rs,"other_pay"));
        d.setZiFu(SQLTool.getBigDecimal(rs,"zifu"));
        d.setZiFei(SQLTool.getBigDecimal(rs, "zifei"));
        d.setInHostDay(SQLTool.getLong(rs, "IN_HOST_DAY"));
        return d;
    }
}
