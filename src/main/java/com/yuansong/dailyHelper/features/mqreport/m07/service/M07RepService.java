package com.yuansong.dailyHelper.features.mqreport.m07.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.m01.repository.M01Do;
import com.yuansong.dailyHelper.features.mqreport.m01.repository.M01Query;
import com.yuansong.dailyHelper.features.mqreport.m01.repository.M01Rep;
import com.yuansong.dailyHelper.features.mqreport.m06.repository.M06Do;
import com.yuansong.dailyHelper.features.mqreport.m06.repository.M06Query;
import com.yuansong.dailyHelper.features.mqreport.m06.repository.M06Rep;
import com.yuansong.dailyHelper.features.mqreport.m07.repository.M07Do;
import com.yuansong.dailyHelper.features.mqreport.m07.repository.M07Query;
import com.yuansong.dailyHelper.features.mqreport.m07.repository.M07Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class M07RepService {

    private final M07Rep m07Rep;

    public M07RepService(M07Rep m07Rep) {
        this.m07Rep = m07Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<M07Do> getList(M07Query query) {
        return m07Rep.getList(query);
    }
}
