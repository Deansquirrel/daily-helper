package com.yuansong.dailyHelper.repository.tidb.setlD;

import com.github.deansquirrel.tools.db.Constant;
import com.yuansong.dailyHelper.repository.tidb.setlD.SetlDDo;
import com.yuansong.dailyHelper.repository.tidb.setlD.SetlDQuery;
import com.yuansong.dailyHelper.repository.tidb.setlD.SetlDRowMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SetlDRep {

    private static final String SQL_GET_LIST = "" +
            "SELECT * " +
            "FROM setl_d " +
            "WHERE 1=1 ";

//    private static final String SQL_INSERT = "" +
//            "INSERT INTO setl_d " +
//            "VALUES (?, ?, ?, ?, ?, ?, ?);";
//
//    private static final String SQL_UPDATE = "" +
//            "UPDATE setl_d " +
//            "SET category_name = ?, category_type = ?, remark = ?, valid_flag = ?, update_time = ? " +
//            "WHERE category_id = ? ;";
//
//    private static final String SQL_DEL = "" +
//            "DELETE FROM setl_d " +
//            "WHERE category_id = ? ;";

    private final JdbcTemplate jdbcTemplate;

    public SetlDRep(@Qualifier(Constant.BEAN_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<SetlDDo> getList(SetlDQuery query) {
        List<Object> objList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(SQL_GET_LIST);
        if(query != null) {
            if(query.getSetlId() != null && !"".equals(query.getSetlId())) {
                sb.append(" AND setl_id = ? ");
                objList.add(query.getSetlId());
            }
            if(query.getMdtrtId() != null && !"".equals(query.getMdtrtId())) {
                sb.append(" AND mdtrt_d = ? ");
                objList.add(query.getMdtrtId());
            }
        }
        sb.append("ORDER BY setl_time asc ;");
        return jdbcTemplate.query(sb.toString(), new SetlDRowMapper(), objList.toArray());
    }
}
