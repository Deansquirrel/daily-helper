package com.yuansong.dailyHelper.features.mqreport.q36.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q36.repository.Q36Do;
import com.yuansong.dailyHelper.features.mqreport.q36.repository.Q36Query;
import com.yuansong.dailyHelper.features.mqreport.q36.repository.Q36Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q36RepService {

    private final Q36Rep q36Rep;

    public Q36RepService(Q36Rep q36Rep) {
        this.q36Rep = q36Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q36Do> getList(Q36Query query) {
        return q36Rep.getList(query);
    }
}
