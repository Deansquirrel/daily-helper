package com.yuansong.dailyHelper.repository;

import com.github.deansquirrel.tools.db.TargetSource;
import com.yuansong.dailyHelper.global.DHConstant;
import com.yuansong.dailyHelper.repository.tidb.setlD.SetlDDo;
import com.yuansong.dailyHelper.repository.tidb.setlD.SetlDQuery;
import com.yuansong.dailyHelper.repository.tidb.setlD.SetlDRep;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepTidbOneImpl implements IRepTiDbOne {

    private final SetlDRep setlDRep;

    public RepTidbOneImpl(SetlDRep setlDRep) {
        this.setlDRep = setlDRep;
    }

    @Override
    @TargetSource(DHConstant.DB_CONN_STR_TIDB_ONE)
    public List<SetlDDo> getSetlDList(SetlDQuery query) {
        return setlDRep.getList(query);
    }
}
