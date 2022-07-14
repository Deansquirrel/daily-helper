package com.yuansong.dailyHelper.features.sjsc.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.q42.repository.Q42Do;
import com.yuansong.dailyHelper.features.mqreport.q42.repository.Q42Query;
import com.yuansong.dailyHelper.features.sjsc.repository.SJSCDo;
import com.yuansong.dailyHelper.features.sjsc.repository.SJSCQuery;
import com.yuansong.dailyHelper.features.sjsc.repository.SJSCRep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SJSCRepService {

    private final SJSCRep sjscRep;

    public SJSCRepService(SJSCRep sjscRep) {
        this.sjscRep = sjscRep;
    }


    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<SJSCDo> getList(SJSCQuery query) {
        return sjscRep.getList(query);
    }

}
