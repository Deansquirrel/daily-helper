package com.yuansong.dailyHelper.features.mqreport.m01.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.m01.repository.M01Do;
import com.yuansong.dailyHelper.features.mqreport.m01.repository.M01Query;
import com.yuansong.dailyHelper.features.mqreport.m01.repository.M01Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class M01RepService {

    private final M01Rep m01Rep;

    public M01RepService(M01Rep m01Rep) {
        this.m01Rep = m01Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<M01Do> getList(M01Query query) {
        return m01Rep.getList(query);
    }
}
