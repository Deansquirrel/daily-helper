package com.yuansong.dailyHelper.features.mqreport.q29.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q29.repository.Q29Do;
import com.yuansong.dailyHelper.features.mqreport.q29.repository.Q29Query;
import com.yuansong.dailyHelper.features.mqreport.q29.repository.Q29Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q29RepService {

    private final Q29Rep q29Rep;

    public Q29RepService(Q29Rep q29Rep) {
        this.q29Rep = q29Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q29Do> getList(Q29Query query) {
        return q29Rep.getList(query);
    }
}
