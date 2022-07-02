package com.yuansong.dailyHelper.features.mqreport.q21.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q21.repository.Q21Do;
import com.yuansong.dailyHelper.features.mqreport.q21.repository.Q21Query;
import com.yuansong.dailyHelper.features.mqreport.q21.repository.Q21Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q21RepService {

    private final Q21Rep q21Rep;

    public Q21RepService(Q21Rep q21Rep) {
        this.q21Rep = q21Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q21Do> getList(Q21Query query) {
        return q21Rep.getList(query);
    }
}
