package com.yuansong.dailyHelper.features.mqreport.q01.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.m01.repository.M01Do;
import com.yuansong.dailyHelper.features.mqreport.m01.repository.M01Query;
import com.yuansong.dailyHelper.features.mqreport.m01.repository.M01Rep;
import com.yuansong.dailyHelper.features.mqreport.q01.repository.Q01Do;
import com.yuansong.dailyHelper.features.mqreport.q01.repository.Q01Query;
import com.yuansong.dailyHelper.features.mqreport.q01.repository.Q01Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q01RepService {

    private final Q01Rep q01Rep;

    public Q01RepService(Q01Rep q01Rep) {
        this.q01Rep = q01Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q01Do> getList(Q01Query query) {
        return q01Rep.getList(query);
    }
}
