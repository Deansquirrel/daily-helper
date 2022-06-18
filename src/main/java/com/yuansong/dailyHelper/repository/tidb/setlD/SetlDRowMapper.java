package com.yuansong.dailyHelper.repository.tidb.setlD;

import com.github.deansquirrel.tools.common.SQLTool;
import com.yuansong.dailyHelper.repository.tidb.setlD.SetlDDo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SetlDRowMapper implements  RowMapper<SetlDDo> {

    @Override
    public SetlDDo mapRow(ResultSet rs, int rowNum) throws SQLException {
        SetlDDo d = new SetlDDo();
        d.setSetlId(SQLTool.getString(rs,"SETL_ID"));
        d.setClrOptions(SQLTool.getString(rs,"CLR_OPTINS"));
        d.setMdtrtId(SQLTool.getString(rs,"MDTRT_ID"));
        d.setInitSetlId(SQLTool.getString(rs,"INIT_SETL_ID"));
        d.setFixmedinsCode(SQLTool.getString(rs,"FIXMEDINS_CODE"));
        d.setFixmedinsName(SQLTool.getString(rs,"FIXMEDINS_NAME"));
        d.setSetlTime(SQLTool.getDatetime(rs,"SETL_TIME"));
        d.setMedfeeSumamt(SQLTool.getBigDecimal(rs,"MEDFEE_SUMAMT"));
        return d;
    }
}