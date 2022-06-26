package com.yuansong.dailyHelper.features.mqreport.q08.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q08.repository.Q08Do;
import com.yuansong.dailyHelper.features.mqreport.q08.repository.Q08Query;
import com.yuansong.dailyHelper.features.mqreport.q08.repository.Q08Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q08RepService {

    private final Q08Rep q08Rep;

    public Q08RepService(Q08Rep q08Rep) {
        this.q08Rep = q08Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q08Do> getList(Q08Query query) {
        return q08Rep.getList(query);
    }
}
