package com.yuansong.dailyHelper.repository.tidb.setD;

import com.github.deansquirrel.tools.common.SQLTool;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SetlDRowMapper implements RowMapper<SetlDDo> {
    @Override
    public SetlDDo mapRow(ResultSet rs, int rowNum) throws SQLException {
        SetlDDo d = new SetlDDo();
        d.setSetlId(SQLTool.getString(rs,"setl_id"));
        d.setClrOptions(SQLTool.getString(rs,"clr_options"));
        d.setMdtrtId(SQLTool.getString(rs,"mdtrt_id"));
        d.setInitSetlId(SQLTool.getString(rs,"init_setl_id"));
        d.setFixmedinsCode(SQLTool.getString(rs,"fixmedins_code"));
        d.setFixmedinsName(SQLTool.getString(rs,"fixmedins_name"));
        d.setSetlTime(SQLTool.getDatetime(rs,"setl_time"));
        d.setMedfeeSumamt(SQLTool.getBigDecimal(rs,"medfee_sumamt"));
        return null;
    }
}
