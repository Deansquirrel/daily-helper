package com.yuansong.dailyHelper.features.evss;

import com.github.deansquirrel.tools.db.TargetSource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvssRepService {

    private final EvssRep evssRep;

    public EvssRepService(EvssRep evssRep) {
        this.evssRep = evssRep;
    }

    @TargetSource(EvssConstant.DB_CONN_ZG)
    public List<EvssDO> getZgList() {
        return evssRep.getList();
    }

    @TargetSource(EvssConstant.DB_CONN_JM)
    public List<EvssDO> getJmList() {
        return evssRep.getList();
    }
}
