package com.yuansong.dailyHelper.features.mqreport.q13.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q13.repository.Q13Do;
import com.yuansong.dailyHelper.features.mqreport.q13.repository.Q13Query;
import com.yuansong.dailyHelper.features.mqreport.q13.repository.Q13Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q13RepService {

    private final Q13Rep q13Rep;

    public Q13RepService(Q13Rep q13Rep) {
        this.q13Rep = q13Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q13Do> getList(Q13Query query) {
        return q13Rep.getList(query);
    }
}
