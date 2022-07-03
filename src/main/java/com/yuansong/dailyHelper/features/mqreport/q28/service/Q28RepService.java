package com.yuansong.dailyHelper.features.mqreport.q28.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q28.repository.Q28Do;
import com.yuansong.dailyHelper.features.mqreport.q28.repository.Q28Query;
import com.yuansong.dailyHelper.features.mqreport.q28.repository.Q28Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q28RepService {

    private final Q28Rep q28Rep;

    public Q28RepService(Q28Rep q28Rep) {
        this.q28Rep = q28Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q28Do> getList(Q28Query query) {
        return q28Rep.getList(query);
    }
}
