package com.yuansong.dailyHelper.features.mqreport.m02.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.m01.repository.M01Do;
import com.yuansong.dailyHelper.features.mqreport.m01.repository.M01Query;
import com.yuansong.dailyHelper.features.mqreport.m01.repository.M01Rep;
import com.yuansong.dailyHelper.features.mqreport.m02.repository.M02Do;
import com.yuansong.dailyHelper.features.mqreport.m02.repository.M02Query;
import com.yuansong.dailyHelper.features.mqreport.m02.repository.M02Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class M02RepService {

    private final M02Rep m02Rep;

    public M02RepService(M02Rep m02Rep) {
        this.m02Rep = m02Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<M02Do> getList(M02Query query) {
        return m02Rep.getList(query);
    }
}
