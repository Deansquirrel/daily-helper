package com.yuansong.dailyHelper.features.mqreport.q32.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q32.repository.Q32Do;
import com.yuansong.dailyHelper.features.mqreport.q32.repository.Q32Query;
import com.yuansong.dailyHelper.features.mqreport.q32.repository.Q32Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q32RepService {

    private final Q32Rep q32Rep;

    public Q32RepService(Q32Rep q32Rep) {
        this.q32Rep = q32Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q32Do> getList(Q32Query query) {
        return q32Rep.getList(query);
    }
}
