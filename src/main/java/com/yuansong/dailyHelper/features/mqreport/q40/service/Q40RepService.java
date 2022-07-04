package com.yuansong.dailyHelper.features.mqreport.q40.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q40.repository.Q40Do;
import com.yuansong.dailyHelper.features.mqreport.q40.repository.Q40Query;
import com.yuansong.dailyHelper.features.mqreport.q40.repository.Q40Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q40RepService {

    private final Q40Rep q40Rep;

    public Q40RepService(Q40Rep q40Rep) {
        this.q40Rep = q40Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q40Do> getList(Q40Query query) {
        return q40Rep.getList(query);
    }
}
