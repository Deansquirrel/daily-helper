package com.yuansong.dailyHelper.features.mqreport.q15.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q15.repository.Q15Do;
import com.yuansong.dailyHelper.features.mqreport.q15.repository.Q15Query;
import com.yuansong.dailyHelper.features.mqreport.q15.repository.Q15Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q15RepService {

    private final Q15Rep q15Rep;

    public Q15RepService(Q15Rep q15Rep) {
        this.q15Rep = q15Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q15Do> getList(Q15Query query) {
        return q15Rep.getList(query);
    }
}
