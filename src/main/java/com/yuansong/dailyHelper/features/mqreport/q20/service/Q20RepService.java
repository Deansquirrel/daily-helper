package com.yuansong.dailyHelper.features.mqreport.q20.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q20.repository.Q20Do;
import com.yuansong.dailyHelper.features.mqreport.q20.repository.Q20Query;
import com.yuansong.dailyHelper.features.mqreport.q20.repository.Q20Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q20RepService {

    private final Q20Rep q20Rep;

    public Q20RepService(Q20Rep q20Rep) {
        this.q20Rep = q20Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q20Do> getList(Q20Query query) {
        return q20Rep.getList(query);
    }
}
