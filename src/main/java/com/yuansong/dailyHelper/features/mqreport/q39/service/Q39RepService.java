package com.yuansong.dailyHelper.features.mqreport.q39.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q39.repository.Q39Do;
import com.yuansong.dailyHelper.features.mqreport.q39.repository.Q39Query;
import com.yuansong.dailyHelper.features.mqreport.q39.repository.Q39Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q39RepService {

    private final Q39Rep q39Rep;

    public Q39RepService(Q39Rep q39Rep) {
        this.q39Rep = q39Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q39Do> getList(Q39Query query) {
        return q39Rep.getList(query);
    }
}
