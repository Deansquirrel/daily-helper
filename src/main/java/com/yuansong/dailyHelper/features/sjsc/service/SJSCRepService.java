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

    @TargetSource(DHConstant.DB_CONN_STR_HL_HS)
    public List<SJSCDo> getList01(SJSCQuery query) {
        return sjscRep.getList01(query);
    }

    @TargetSource(DHConstant.DB_CONN_STR_HL_HS)
    public List<SJSCDo> getList02(SJSCQuery query) {
        return sjscRep.getList02(query);
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<SJSCDo> getList03(SJSCQuery query) {
        return sjscRep.getList03(query);
    }

    @TargetSource(DHConstant.DB_CONN_STR_HL_HS)
    public List<SJSCDo> getList04(SJSCQuery query) {
        return sjscRep.getList04(query);
    }

    @TargetSource(DHConstant.DB_CONN_STR_HL_HS)
    public List<SJSCDo> getList05(SJSCQuery query) {
        return sjscRep.getList05(query);
    }

    @TargetSource(DHConstant.DB_CONN_STR_HL_HS)
    public List<SJSCDo> getList06(SJSCQuery query) {
        return sjscRep.getList06(query);
    }

    @TargetSource(DHConstant.DB_CONN_STR_HL_HS)
    public List<SJSCDo> getList07(SJSCQuery query) {
        return sjscRep.getList07(query);
    }

    @TargetSource(DHConstant.DB_CONN_STR_HL_HS)
    public List<SJSCDo> getList08(SJSCQuery query) {
        return sjscRep.getList08(query);
    }

    @TargetSource(DHConstant.DB_CONN_STR_HL_HS)
    public List<SJSCDo> getList09(SJSCQuery query) {
        return sjscRep.getList09(query);
    }

    @TargetSource(DHConstant.DB_CONN_STR_HL_HS)
    public List<SJSCDo> getList10(SJSCQuery query) {
        return sjscRep.getList10(query);
    }

    @TargetSource(DHConstant.DB_CONN_STR_HL_HS)
    public List<SJSCDo> getList11(SJSCQuery query) {
        return sjscRep.getList11(query);
    }

    @TargetSource(DHConstant.DB_CONN_STR_HL_HS)
    public List<SJSCDo> getList12(SJSCQuery query) {
        return sjscRep.getList12(query);
    }

    @TargetSource(DHConstant.DB_CONN_STR_HL_HS)
    public List<SJSCDo> getList13(SJSCQuery query) {
        return sjscRep.getList13(query);
    }

    @TargetSource(DHConstant.DB_CONN_STR_HL_HS)
    public List<SJSCDo> getList14(SJSCQuery query) {
        return sjscRep.getList14(query);
    }

    @TargetSource(DHConstant.DB_CONN_STR_HL_HS)
    public List<SJSCDo> getList15(SJSCQuery query) {
        return sjscRep.getList15(query);
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<SJSCDo> getList16(SJSCQuery query) {
        return sjscRep.getList16(query);
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<SJSCDo> getList17(SJSCQuery query) {
        return sjscRep.getList17(query);
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<SJSCDo> getList18(SJSCQuery query) {
        return sjscRep.getList18(query);
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<SJSCDo> getList19(SJSCQuery query) {
        return sjscRep.getList19(query);
    }


}
