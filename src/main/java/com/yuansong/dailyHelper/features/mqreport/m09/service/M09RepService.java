package com.yuansong.dailyHelper.features.mqreport.m09.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.m09.repository.M09Do;
import com.yuansong.dailyHelper.features.mqreport.m09.repository.M09Query;
import com.yuansong.dailyHelper.features.mqreport.m09.repository.M09Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class M09RepService {

    private final M09Rep m09Rep;

    public M09RepService(M09Rep m09Rep) {
        this.m09Rep = m09Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<M09Do> getList(M09Query query) {
        return m09Rep.getList(query);
    }
}
