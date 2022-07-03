package com.yuansong.dailyHelper.features.mqreport.q30.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q30.repository.Q30Do;
import com.yuansong.dailyHelper.features.mqreport.q30.repository.Q30Query;
import com.yuansong.dailyHelper.features.mqreport.q30.repository.Q30Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q30RepService {

    private final Q30Rep q30Rep;

    public Q30RepService(Q30Rep q30Rep) {
        this.q30Rep = q30Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q30Do> getList(Q30Query query) {
        return q30Rep.getList(query);
    }
}
