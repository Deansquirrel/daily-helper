package com.yuansong.dailyHelper.features.mqreport.q38.service;

import com.github.deansquirrel.tools.poi.IDataMapper;
import com.yuansong.dailyHelper.features.mqreport.q38.repository.Q38Do;

import java.util.ArrayList;
import java.util.List;

public class Q38DataMapper implements IDataMapper<Q38Do> {
    @Override
    public List<String> getTitleList() {
        List<String> list = new ArrayList<>();
        list.add("区划");
        list.add("单位分类");
        list.add("人数");
        return list;
    }

    @Override
    public List<Object> getRowData(Q38Do data) {
        List<Object> list = new ArrayList<>();
        list.add(data.getInsuAdmdvs());
        list.add(data.getEmpType());
        list.add(data.gettCount());
        return list;
    }
}
