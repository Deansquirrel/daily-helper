package com.yuansong.dailyHelper.features.mqreport.q04.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q04.repository.Q04Do;
import com.yuansong.dailyHelper.features.mqreport.q04.repository.Q04Query;
import com.yuansong.dailyHelper.features.mqreport.q04.repository.Q04Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Q04RepService {

    private final Q04Rep q04Rep;

    public Q04RepService(Q04Rep q04Rep) {
        this.q04Rep = q04Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<Q04Do> getList(Q04Query query) {
        return q04Rep.getList(query);
    }
}
