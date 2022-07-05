package com.yuansong.dailyHelper.features.mqreport.q41.service;

import com.github.deansquirrel.tools.poi.IDataMapper;
import com.yuansong.dailyHelper.features.mqreport.q41.repository.Q41Do;

import java.util.ArrayList;
import java.util.List;

public class Q41DataMapper implements IDataMapper<Q41Do> {
    @Override
    public List<String> getTitleList() {
        List<String> list = new ArrayList<>();
        list.add("类型");
        list.add("区划");
        list.add("人数");
        return list;
    }

    @Override
    public List<Object> getRowData(Q41Do data) {
        List<Object> list = new ArrayList<>();
        list.add(data.getMedType());
        list.add(data.getInsuAdmdvs());
        list.add(data.getPsnCount());
        return list;
    }
}
