package com.yuansong.dailyHelper.repository.tidb.setD;

import com.github.deansquirrel.tools.common.SQLTool;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SetlDRowMapper implements RowMapper<SetlDDo> {
    @Override
    public SetlDDo mapRow(ResultSet rs, int rowNum) throws SQLException {
        SetlDDo d = new SetlDDo();

        return null;
    }
}
