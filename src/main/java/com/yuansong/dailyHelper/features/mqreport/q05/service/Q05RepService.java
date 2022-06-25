package com.yuansong.dailyHelper.features.mqreport.q05.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q05.repository.Q05Do;
import com.yuansong.dailyHelper.features.mqreport.q05.repository.Q05Query;
import com.yuansong.dailyHelper.features.mqreport.q05.repository.Q05Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q05RepService {

    private final Q05Rep q05Rep;

    public Q05RepService(Q05Rep q05Rep) {
        this.q05Rep = q05Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q05Do> getList(Q05Query query) {
        return q05Rep.getList(query);
    }
}
