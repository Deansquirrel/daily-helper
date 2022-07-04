package com.yuansong.dailyHelper.features.mqreport.q38.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q38.repository.Q38Do;
import com.yuansong.dailyHelper.features.mqreport.q38.repository.Q38Query;
import com.yuansong.dailyHelper.features.mqreport.q38.repository.Q38Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q38RepService {

    private final Q38Rep q38Rep;

    public Q38RepService(Q38Rep q38Rep) {
        this.q38Rep = q38Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q38Do> getList(Q38Query query) {
        return q38Rep.getList(query);
    }
}
