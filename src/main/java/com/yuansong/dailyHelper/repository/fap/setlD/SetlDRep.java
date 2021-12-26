package com.yuansong.dailyHelper.repository.fap.setlD;

import com.github.deansquirrel.tools.db.Constant;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class SetlDRep {

    private final JdbcTemplate jdbcTemplate;

    private final List<String> fields = Arrays.asList(
            "SETL_ID","MDTRT_ID","PSN_NO","PSN_NAME","CERTNO",
            "FIXMEDINS_CODE","FIXMEDINS_NAME","SETL_TIME","MDTRT_CERT_TYPE");

    public SetlDRep(@Qualifier(Constant.BEAN_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<SetlDDO> getList(SetlDQuery query) {
        List<Object> objList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        for(int i = 0; i < fields.size(); i++) {
            if(i > 0) {
                sb.append(",");
            }
            sb.append("`");
            sb.append(fields.get(i));
            sb.append("` ");
        }
        sb.append("FROM SETL_D ");
        sb.append("WHERE 1=1 ");
        if(query.getSetlId() != null) {
            sb.append(" AND SETL_ID = ?");
            objList.add(query.getSetlId());
        }
        if(query.getSetlTimeBeg() != null) {
            sb.append(" AND SETL_TIME >= ?");
            objList.add(query.getSetlTimeBeg());
        }
        if(query.getSetlTimeEnd() != null) {
            sb.append(" AND SETL_TIME < ?");
            objList.add(query.getSetlTimeEnd());
        }
        if(query.getFixmedinsCode() != null) {
            sb.append(" AND FIXMEDINS_CODE = ?");
            objList.add(query.getFixmedinsCode());
        }
        if(query.getFixmedinsCodeLike() != null) {
            sb.append(" AND FIXMEDINS_CODE LIKE ?");
            objList.add(query.getFixmedinsCodeLike());
        }
        sb.append(";");
        jdbcTemplate.query(sb.toString(), new SetlDRowMapper(), objList.toArray());
        return null;
    }
}
