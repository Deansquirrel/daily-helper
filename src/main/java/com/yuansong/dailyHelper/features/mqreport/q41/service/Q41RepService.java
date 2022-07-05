package com.yuansong.dailyHelper.features.mqreport.q41.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q41.repository.Q41Do;
import com.yuansong.dailyHelper.features.mqreport.q41.repository.Q41Query;
import com.yuansong.dailyHelper.features.mqreport.q41.repository.Q41Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q41RepService {

    private final Q41Rep q41Rep;

    public Q41RepService(Q41Rep q41Rep) {
        this.q41Rep = q41Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q41Do> getList(Q41Query query) {
        return q41Rep.getList(query);
    }
}
