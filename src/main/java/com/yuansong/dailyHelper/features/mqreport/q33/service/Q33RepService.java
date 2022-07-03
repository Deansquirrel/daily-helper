package com.yuansong.dailyHelper.features.mqreport.q33.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q33.repository.Q33Do;
import com.yuansong.dailyHelper.features.mqreport.q33.repository.Q33Query;
import com.yuansong.dailyHelper.features.mqreport.q33.repository.Q33Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q33RepService {

    private final Q33Rep q33Rep;

    public Q33RepService(Q33Rep q33Rep) {
        this.q33Rep = q33Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q33Do> getList(Q33Query query) {
        return q33Rep.getList(query);
    }
}
