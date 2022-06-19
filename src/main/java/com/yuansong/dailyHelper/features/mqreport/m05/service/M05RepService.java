package com.yuansong.dailyHelper.features.mqreport.m05.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.mqreport.m04.repository.M04Do;
import com.yuansong.dailyHelper.features.mqreport.m04.repository.M04Query;
import com.yuansong.dailyHelper.features.mqreport.m04.repository.M04Rep;
import com.yuansong.dailyHelper.features.mqreport.m05.repository.M05Do;
import com.yuansong.dailyHelper.features.mqreport.m05.repository.M05Query;
import com.yuansong.dailyHelper.features.mqreport.m05.repository.M05Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class M05RepService {

    private final M05Rep m05Rep;

    public M05RepService(M05Rep m05Rep) {
        this.m05Rep = m05Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<M05Do> getList(M05Query query) {
        List<M05Do> listA = m05Rep.getAList(query);
        List<M05Do> listB = m05Rep.getBList(query);
        Map<String, M05Do> mapB = new HashMap<>();
        for(M05Do d: listB) {
            mapB.put(d.getInsuAdmdvs(), d);
        }
        List<M05Do> listC = m05Rep.getCList(query);
        Map<String, M05Do> mapC = new HashMap<>();
        for(M05Do d: listC) {
            mapC.put(d.getInsuAdmdvs(), d);
        }
        List<M05Do> listD = m05Rep.getDList(query);
        Map<String, M05Do> mapD = new HashMap<>();
        for(M05Do d: listD) {
            mapD.put(d.getInsuAdmdvs(), d);
        }
        List<M05Do> list = new ArrayList<>();
        for(M05Do d : listA) {
            String admdvs = d.getInsuAdmdvs();
            if(mapB.containsKey(admdvs)) {
                d.setB01(mapB.get(admdvs).getB01());
            }
            if(mapC.containsKey(admdvs)) {
                d.setC01(mapC.get(admdvs).getC01());
                d.setC02(mapC.get(admdvs).getC02());
            }
            if(mapD.containsKey(admdvs)) {
                d.setD01(mapD.get(admdvs).getD01());
            }
            list.add(d);
        }
        return list;
    }
}
