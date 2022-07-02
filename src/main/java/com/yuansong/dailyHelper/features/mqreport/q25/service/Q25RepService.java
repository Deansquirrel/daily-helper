package com.yuansong.dailyHelper.features.mqreport.q25.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q25.repository.Q25Do;
import com.yuansong.dailyHelper.features.mqreport.q25.repository.Q25Query;
import com.yuansong.dailyHelper.features.mqreport.q25.repository.Q25Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q25RepService {

    private final Q25Rep q25Rep;

    public Q25RepService(Q25Rep q25Rep) {
        this.q25Rep = q25Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q25Do> getList(Q25Query query) {
        return q25Rep.getList(query);
    }
}
