package com.yuansong.dailyHelper.features.mqreport.m04.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.m04.repository.M04Do;
import com.yuansong.dailyHelper.features.mqreport.m04.repository.M04Query;
import com.yuansong.dailyHelper.features.mqreport.m04.repository.M04Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class M04RepService {

    private final M04Rep m04Rep;

    public M04RepService(M04Rep m04Rep) {
        this.m04Rep = m04Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<M04Do> getList(M04Query query) {
        return m04Rep.getList(query);
    }
}
