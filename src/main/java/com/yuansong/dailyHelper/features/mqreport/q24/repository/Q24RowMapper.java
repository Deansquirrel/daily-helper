package com.yuansong.dailyHelper.features.mqreport.q24.repository;

import com.github.deansquirrel.tools.common.SQLTool;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Q24RowMapper implements RowMapper<Q24Do> {


    @Override
    public Q24Do mapRow(ResultSet rs, int rowNum) throws SQLException {
        Q24Do d = new Q24Do();
        d.setInsuAdmdvs(SQLTool.getString(rs,"INSU_ADMDVS"));
        d.setDedcHospLv(SQLTool.getString(rs,"DEDC_HOSP_LV"));
        d.setMedfeeSumamt(SQLTool.getBigDecimal(rs,"MEDFEE_SUMAMT"));
        d.setHifmiPay(SQLTool.getBigDecimal(rs, "HIFMI_PAY"));
        d.setHifpPay(SQLTool.getBigDecimal(rs,"hifp_pay"));
        d.setOtherPay(SQLTool.getBigDecimal(rs,"other_pay"));
        d.setZiFu(SQLTool.getBigDecimal(rs,"zifu"));
        d.setZiFei(SQLTool.getBigDecimal(rs, "zifei"));
        d.setAcctPay(SQLTool.getBigDecimal(rs,"ACCT_PAY"));
        d.setMuLuWai(SQLTool.getBigDecimal(rs, "muluwai"));
        d.settCount(SQLTool.getLong(rs,"T_COUNT"));
        return d;
    }
}
