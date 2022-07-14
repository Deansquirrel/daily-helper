package com.yuansong.dailyHelper.features.mqreortv2;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public interface IRep<T> {

    JdbcTemplate getJdbcTemplate();

    String getQuerySQL();

    List<Object> getParam();

    RowMapper<T> getRowMapper();

    default List<T> getList() {
        this.getJdbcTemplate().query(this.getQuerySQL(), this.getRowMapper(), this.getParam().toArray());
        return null;
    }

}
