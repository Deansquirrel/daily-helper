package com.yuansong.dailyHelper.features.mqreport.q10.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q10.repository.Q10Do;
import com.yuansong.dailyHelper.features.mqreport.q10.repository.Q10Query;
import com.yuansong.dailyHelper.features.mqreport.q10.repository.Q10Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q10RepService {

    private final Q10Rep Q10Rep;

    public Q10RepService(com.yuansong.dailyHelper.features.mqreport.q10.repository.Q10Rep Q10Rep) {
        this.Q10Rep = Q10Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q10Do> getList(Q10Query query) {
        return Q10Rep.getList(query);
    }
}
