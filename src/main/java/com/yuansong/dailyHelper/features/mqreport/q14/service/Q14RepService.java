package com.yuansong.dailyHelper.features.mqreport.q14.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q14.repository.Q14Do;
import com.yuansong.dailyHelper.features.mqreport.q14.repository.Q14Query;
import com.yuansong.dailyHelper.features.mqreport.q14.repository.Q14Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q14RepService {

    private final Q14Rep Q14Rep;

    public Q14RepService(com.yuansong.dailyHelper.features.mqreport.q14.repository.Q14Rep Q14Rep) {
        this.Q14Rep = Q14Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q14Do> getList(Q14Query query) {
        return Q14Rep.getList(query);
    }
}
