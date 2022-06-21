package com.yuansong.dailyHelper.features.mqreport.m08.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.m07.repository.M07Do;
import com.yuansong.dailyHelper.features.mqreport.m07.repository.M07Query;
import com.yuansong.dailyHelper.features.mqreport.m07.repository.M07Rep;
import com.yuansong.dailyHelper.features.mqreport.m08.repository.M08Do;
import com.yuansong.dailyHelper.features.mqreport.m08.repository.M08Query;
import com.yuansong.dailyHelper.features.mqreport.m08.repository.M08Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class M08RepService {

    private final M08Rep m08Rep;

    public M08RepService(M08Rep m08Rep) {
        this.m08Rep = m08Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<M08Do> getList(M08Query query) {
        return m08Rep.getList(query);
    }
}
