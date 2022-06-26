package com.yuansong.dailyHelper.features.mqreport.q12.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q12.repository.Q12Do;
import com.yuansong.dailyHelper.features.mqreport.q12.repository.Q12Query;
import com.yuansong.dailyHelper.features.mqreport.q12.repository.Q12Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q12RepService {

    private final Q12Rep q12Rep;

    public Q12RepService(Q12Rep q12Rep) {
        this.q12Rep = q12Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q12Do> getList(Q12Query query) {
        return q12Rep.getList(query);
    }
}
