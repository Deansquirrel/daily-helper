package com.yuansong.dailyHelper.features.mqreport.q42.service;

import com.github.deansquirrel.tools.poi.IDataMapper;
import com.yuansong.dailyHelper.features.mqreport.q42.repository.Q42Do;

import java.util.ArrayList;
import java.util.List;

public class Q42DataMapper implements IDataMapper<Q42Do> {
    @Override
    public List<String> getTitleList() {
        List<String> list = new ArrayList<>();
        list.add("区划");
        list.add("险种");
        list.add("人数");
        list.add("人次");
        return list;
    }

    @Override
    public List<Object> getRowData(Q42Do data) {
        List<Object> list = new ArrayList<>();
        list.add(data.getInsuAdmdvs());
        list.add(data.getInsuType());
        list.add(data.getA01());
        list.add(data.getA02());
        return list;
    }
}
