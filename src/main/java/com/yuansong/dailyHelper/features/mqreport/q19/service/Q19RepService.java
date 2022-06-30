package com.yuansong.dailyHelper.features.mqreport.q19.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q19.repository.Q19Do;
import com.yuansong.dailyHelper.features.mqreport.q19.repository.Q19Query;
import com.yuansong.dailyHelper.features.mqreport.q19.repository.Q19Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q19RepService {

    private final Q19Rep q19Rep;

    public Q19RepService(Q19Rep q19Rep) {
        this.q19Rep = q19Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q19Do> getList(Q19Query query) {
        return q19Rep.getList(query);
    }
}
