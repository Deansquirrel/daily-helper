package com.yuansong.dailyHelper.features.mqreport.m03.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.m03.repository.M03Do;
import com.yuansong.dailyHelper.features.mqreport.m03.repository.M03Query;
import com.yuansong.dailyHelper.features.mqreport.m03.repository.M03Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class M03RepService {

    private final M03Rep m03Rep;

    public M03RepService(M03Rep m03Rep) {
        this.m03Rep = m03Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<M03Do> getList(M03Query query) {
        return m03Rep.getList(query);
    }
}
