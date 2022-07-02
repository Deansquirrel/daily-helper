package com.yuansong.dailyHelper.features.mqreport.q24.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q24.repository.Q24Do;
import com.yuansong.dailyHelper.features.mqreport.q24.repository.Q24Query;
import com.yuansong.dailyHelper.features.mqreport.q24.repository.Q24Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q24RepService {

    private final Q24Rep q24Rep;

    public Q24RepService(Q24Rep q24Rep) {
        this.q24Rep = q24Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q24Do> getList(Q24Query query) {
        return q24Rep.getList(query);
    }
}
