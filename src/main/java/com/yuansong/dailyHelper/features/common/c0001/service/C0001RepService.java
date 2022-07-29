package com.yuansong.dailyHelper.features.common.c0001.service;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.features.common.c0001.repository.C0001Do;
import com.yuansong.dailyHelper.features.common.c0001.repository.C0001Rep;
import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class C0001RepService {

    private final C0001Rep c0001Rep;

    public C0001RepService(C0001Rep c0001Rep) {
        this.c0001Rep = c0001Rep;
    }

    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<C0001Do> getList() {
        return c0001Rep.getList();
    }
}
