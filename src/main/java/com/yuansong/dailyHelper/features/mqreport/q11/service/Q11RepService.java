package com.yuansong.dailyHelper.features.mqreport.q11.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q11.repository.Q11Do;
import com.yuansong.dailyHelper.features.mqreport.q11.repository.Q11Query;
import com.yuansong.dailyHelper.features.mqreport.q11.repository.Q11Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q11RepService {

    private final Q11Rep q11Rep;

    public Q11RepService(Q11Rep q11Rep) {
        this.q11Rep = q11Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q11Do> getList(Q11Query query) {
        return q11Rep.getList(query);
    }
}
