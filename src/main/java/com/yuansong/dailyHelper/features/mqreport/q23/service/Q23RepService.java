package com.yuansong.dailyHelper.features.mqreport.q23.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q23.repository.Q23Do;
import com.yuansong.dailyHelper.features.mqreport.q23.repository.Q23Query;
import com.yuansong.dailyHelper.features.mqreport.q23.repository.Q23Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q23RepService {

    private final Q23Rep q23Rep;

    public Q23RepService(Q23Rep q23Rep) {
        this.q23Rep = q23Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q23Do> getList(Q23Query query) {
        return q23Rep.getList(query);
    }
}
