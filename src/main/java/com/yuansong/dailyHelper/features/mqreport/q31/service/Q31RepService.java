package com.yuansong.dailyHelper.features.mqreport.q31.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q31.repository.Q31Do;
import com.yuansong.dailyHelper.features.mqreport.q31.repository.Q31Query;
import com.yuansong.dailyHelper.features.mqreport.q31.repository.Q31Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q31RepService {

    private final Q31Rep q31Rep;

    public Q31RepService(Q31Rep q31Rep) {
        this.q31Rep = q31Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q31Do> getList(Q31Query query) {
        return q31Rep.getList(query);
    }
}
