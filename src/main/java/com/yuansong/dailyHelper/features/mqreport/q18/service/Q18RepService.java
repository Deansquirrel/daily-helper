package com.yuansong.dailyHelper.features.mqreport.q18.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q18.repository.Q18Do;
import com.yuansong.dailyHelper.features.mqreport.q18.repository.Q18Query;
import com.yuansong.dailyHelper.features.mqreport.q18.repository.Q18Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q18RepService {

    private final Q18Rep q18Rep;

    public Q18RepService(Q18Rep q18Rep) {
        this.q18Rep = q18Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q18Do> getList(Q18Query query) {
        return q18Rep.getList(query);
    }
}
