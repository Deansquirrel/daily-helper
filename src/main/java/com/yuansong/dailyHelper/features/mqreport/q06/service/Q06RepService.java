package com.yuansong.dailyHelper.features.mqreport.q06.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q06.repository.Q06Do;
import com.yuansong.dailyHelper.features.mqreport.q06.repository.Q06Query;
import com.yuansong.dailyHelper.features.mqreport.q06.repository.Q06Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q06RepService {

    private final Q06Rep q06Rep;

    public Q06RepService(Q06Rep q06Rep) {
        this.q06Rep = q06Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q06Do> getList(Q06Query query) {
        return q06Rep.getList(query);
    }
}
