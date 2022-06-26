package com.yuansong.dailyHelper.features.mqreport.q09.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q09.repository.Q09Do;
import com.yuansong.dailyHelper.features.mqreport.q09.repository.Q09Query;
import com.yuansong.dailyHelper.features.mqreport.q09.repository.Q09Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q09RepService {

    private final Q09Rep q09Rep;

    public Q09RepService(Q09Rep q09Rep) {
        this.q09Rep = q09Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q09Do> getList(Q09Query query) {
        return q09Rep.getList(query);
    }
}
