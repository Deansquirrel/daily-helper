package com.yuansong.dailyHelper.features.mqreport.q26.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q26.repository.Q26Do;
import com.yuansong.dailyHelper.features.mqreport.q26.repository.Q26Query;
import com.yuansong.dailyHelper.features.mqreport.q26.repository.Q26Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q26RepService {

    private final Q26Rep q26Rep;

    public Q26RepService(Q26Rep q26Rep) {
        this.q26Rep = q26Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q26Do> getList(Q26Query query) {
        return q26Rep.getList(query);
    }
}
