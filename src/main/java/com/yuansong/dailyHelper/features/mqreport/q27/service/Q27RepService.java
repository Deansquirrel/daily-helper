package com.yuansong.dailyHelper.features.mqreport.q27.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q27.repository.Q27Do;
import com.yuansong.dailyHelper.features.mqreport.q27.repository.Q27Query;
import com.yuansong.dailyHelper.features.mqreport.q27.repository.Q27Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q27RepService {

    private final Q27Rep q27Rep;

    public Q27RepService(Q27Rep q27Rep) {
        this.q27Rep = q27Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q27Do> getList(Q27Query query) {
        return q27Rep.getList(query);
    }
}
