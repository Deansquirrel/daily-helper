package com.yuansong.dailyHelper.features.mqreport.q03.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q03.repository.Q03Do;
import com.yuansong.dailyHelper.features.mqreport.q03.repository.Q03Query;
import com.yuansong.dailyHelper.features.mqreport.q03.repository.Q03Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q03RepService {

    private final Q03Rep q03Rep;

    public Q03RepService(Q03Rep q03Rep) {
        this.q03Rep = q03Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q03Do> getList(Q03Query query) {
        return q03Rep.getList(query);
    }
}
