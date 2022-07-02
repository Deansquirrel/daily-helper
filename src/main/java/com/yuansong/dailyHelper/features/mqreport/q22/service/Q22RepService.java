package com.yuansong.dailyHelper.features.mqreport.q22.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q22.repository.Q22Do;
import com.yuansong.dailyHelper.features.mqreport.q22.repository.Q22Query;
import com.yuansong.dailyHelper.features.mqreport.q22.repository.Q22Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q22RepService {

    private final Q22Rep q22Rep;

    public Q22RepService(Q22Rep q22Rep) {
        this.q22Rep = q22Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q22Do> getList(Q22Query query) {
        return q22Rep.getList(query);
    }
}
