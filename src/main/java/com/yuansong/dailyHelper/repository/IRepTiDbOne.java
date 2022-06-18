package com.yuansong.dailyHelper.repository;

import com.yuansong.dailyHelper.repository.tidb.setlD.SetlDDo;
import com.yuansong.dailyHelper.repository.tidb.setlD.SetlDQuery;

import java.util.List;

public interface IRepTiDbOne {

    List<SetlDDo> getSetlDList(SetlDQuery query);

}
