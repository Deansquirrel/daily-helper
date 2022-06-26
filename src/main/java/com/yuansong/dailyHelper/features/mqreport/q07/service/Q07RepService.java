package com.yuansong.dailyHelper.features.mqreport.q07.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q07.repository.Q07Do;
import com.yuansong.dailyHelper.features.mqreport.q07.repository.Q07Query;
import com.yuansong.dailyHelper.features.mqreport.q07.repository.Q07Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q07RepService {

    private final Q07Rep q07Rep;

    public Q07RepService(Q07Rep q07Rep) {
        this.q07Rep = q07Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q07Do> getList(Q07Query query) {
        return q07Rep.getList(query);
    }
}
