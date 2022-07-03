package com.yuansong.dailyHelper.features.mqreport.q35.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q35.repository.Q35Do;
import com.yuansong.dailyHelper.features.mqreport.q35.repository.Q35Query;
import com.yuansong.dailyHelper.features.mqreport.q35.repository.Q35Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q35RepService {

    private final Q35Rep q35Rep;

    public Q35RepService(Q35Rep q35Rep) {
        this.q35Rep = q35Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q35Do> getList(Q35Query query) {
        return q35Rep.getList(query);
    }
}
