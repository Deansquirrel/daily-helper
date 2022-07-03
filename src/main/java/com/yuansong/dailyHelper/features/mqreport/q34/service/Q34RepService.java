package com.yuansong.dailyHelper.features.mqreport.q34.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q34.repository.Q34Do;
import com.yuansong.dailyHelper.features.mqreport.q34.repository.Q34Query;
import com.yuansong.dailyHelper.features.mqreport.q34.repository.Q34Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q34RepService {

    private final Q34Rep Q34Rep;

    public Q34RepService(Q34Rep Q34Rep) {
        this.Q34Rep = Q34Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q34Do> getList(Q34Query query) {
        return Q34Rep.getList(query);
    }
}
