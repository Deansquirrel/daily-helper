package com.yuansong.dailyHelper.features.mqreport.q42.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q42.repository.Q42Do;
import com.yuansong.dailyHelper.features.mqreport.q42.repository.Q42Query;
import com.yuansong.dailyHelper.features.mqreport.q42.repository.Q42Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q42RepService {

    private final Q42Rep q42Rep;

    public Q42RepService(Q42Rep q42Rep) {
        this.q42Rep = q42Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q42Do> getList(Q42Query query) {
        return q42Rep.getList(query);
    }
}
