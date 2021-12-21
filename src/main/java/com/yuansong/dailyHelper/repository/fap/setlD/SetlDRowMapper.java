package com.yuansong.dailyHelper.repository.fap.setlD;

import com.github.deansquirrel.tools.common.SQLTool;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SetlDRowMapper implements RowMapper<SetlDDO> {
    @Override
    public SetlDDO mapRow(ResultSet rs, int rowNum) throws SQLException {
        SetlDDO d = new SetlDDO();
        d.setSetlId(SQLTool.getString(rs, "SETL_ID"));
        d.setMdtrtId(SQLTool.getString(rs,"MDTRT_ID"));
        d.setPsnNo(SQLTool.getString(rs, "PSN_NO"));
        d.setPsnName(SQLTool.getString(rs, "PSN_NAME"));
        d.setCertNo(SQLTool.getString(rs, "CERTNO"));
        d.setFixmedinsCode(SQLTool.getString(rs,"FIXMEDINS_CODE"));
        d.setFixmedinsName(SQLTool.getString(rs, "FIXMEDINS_NAME"));
        d.setSetlTime(SQLTool.getDatetime(rs, "SETL_TIME"));
        d.setMdtrtCertType(SQLTool.getString(rs,"MDTRT_CERT_TYPE"));
        return d;
    }
}
