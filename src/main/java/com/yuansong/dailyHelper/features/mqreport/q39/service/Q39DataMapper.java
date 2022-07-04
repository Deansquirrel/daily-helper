package com.yuansong.dailyHelper.features.mqreport.q39.service;

import com.github.deansquirrel.tools.poi.IDataMapper;
import com.yuansong.dailyHelper.features.mqreport.q39.repository.Q39Do;

import java.util.ArrayList;
import java.util.List;

public class Q39DataMapper implements IDataMapper<Q39Do> {
    @Override
    public List<String> getTitleList() {
        List<String> list = new ArrayList<>();
        list.add("险种");
        list.add("区划");
        list.add("单位分类");
        list.add("人数");
        return list;
    }

    @Override
    public List<Object> getRowData(Q39Do data) {
        List<Object> list = new ArrayList<>();
        list.add(data.getInsuType());
        list.add(data.getInsuAdmdvs());
        list.add(data.getEmpType());
        list.add(data.gettCount());
        return list;
    }
}
