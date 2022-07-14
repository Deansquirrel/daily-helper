package com.yuansong.dailyHelper.features.mqreortv2;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.global.DHConstant;

import java.util.List;

public interface IRepService<T> {

    IRep<T> getRep();

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    default List<T> getList(MQReportQuery query) {
        return this.getRep().getList();
    }

}
