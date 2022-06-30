package com.yuansong.dailyHelper.features.mqreport.q16.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q16.repository.Q16Do;
import com.yuansong.dailyHelper.features.mqreport.q16.repository.Q16Query;
import com.yuansong.dailyHelper.features.mqreport.q16.repository.Q16Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q16RepService {

    private final Q16Rep q16Rep;

    public Q16RepService(Q16Rep q16Rep) {
        this.q16Rep = q16Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q16Do> getList(Q16Query query) {
        return q16Rep.getList(query);
    }
}
