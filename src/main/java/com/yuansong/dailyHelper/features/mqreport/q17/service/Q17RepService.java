package com.yuansong.dailyHelper.features.mqreport.q17.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q17.repository.Q17Do;
import com.yuansong.dailyHelper.features.mqreport.q17.repository.Q17Query;
import com.yuansong.dailyHelper.features.mqreport.q17.repository.Q17Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q17RepService {

    private final Q17Rep q17Rep;

    public Q17RepService(Q17Rep q17Rep) {
        this.q17Rep = q17Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q17Do> getList(Q17Query query) {
        return q17Rep.getList(query);
    }
}
