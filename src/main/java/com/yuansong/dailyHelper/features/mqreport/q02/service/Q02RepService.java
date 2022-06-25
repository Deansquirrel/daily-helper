package com.yuansong.dailyHelper.features.mqreport.q02.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q02.repository.Q02Do;
import com.yuansong.dailyHelper.features.mqreport.q02.repository.Q02Query;
import com.yuansong.dailyHelper.features.mqreport.q02.repository.Q02Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q02RepService {

    private final Q02Rep q02Rep;

    public Q02RepService(Q02Rep q02Rep) {
        this.q02Rep = q02Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q02Do> getList(Q02Query query) {
        return q02Rep.getList(query);
    }
}
