package com.yuansong.dailyHelper.features.mqreport.q37.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q37.repository.Q37Do;
import com.yuansong.dailyHelper.features.mqreport.q37.repository.Q37Query;
import com.yuansong.dailyHelper.features.mqreport.q37.repository.Q37Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q37RepService {

    private final Q37Rep q37Rep;

    public Q37RepService(Q37Rep q37Rep) {
        this.q37Rep = q37Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q37Do> getList(Q37Query query) {
        return q37Rep.getList(query);
    }
}
