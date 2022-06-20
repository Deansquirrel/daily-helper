package com.yuansong.dailyHelper.features.mqreport.m06.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.m01.repository.M01Do;
import com.yuansong.dailyHelper.features.mqreport.m01.repository.M01Query;
import com.yuansong.dailyHelper.features.mqreport.m01.repository.M01Rep;
import com.yuansong.dailyHelper.features.mqreport.m06.repository.M06Do;
import com.yuansong.dailyHelper.features.mqreport.m06.repository.M06Query;
import com.yuansong.dailyHelper.features.mqreport.m06.repository.M06Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class M06RepService {

    private final M06Rep m06Rep;

    public M06RepService(M06Rep m06Rep) {
        this.m06Rep = m06Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<M06Do> getList(M06Query query) {
        return m06Rep.getList(query);
    }
}
