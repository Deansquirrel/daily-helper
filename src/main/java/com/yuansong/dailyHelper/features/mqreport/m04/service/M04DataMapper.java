package com.yuansong.dailyHelper.features.mqreport.m04.service;

import com.github.deansquirrel.tools.poi.IDataMapper;
import com.yuansong.dailyHelper.features.mqreport.m04.repository.M04Do;

import java.util.ArrayList;
import java.util.List;

public class M04DataMapper implements IDataMapper<M04Do> {
    @Override
    public List<String> getTitleList() {
        List<String> list = new ArrayList<>();
        list.add("区划");
        list.add("人数");
        return list;
    }

    @Override
    public List<Object> getRowData(M04Do data) {
        List<Object> list = new ArrayList<>();
        list.add(data.getInsuAdmdvs() == null ? "" : data.getInsuAdmdvs());
        list.add(data.getUrrInsu()  == null ? "" : String.valueOf(data.getUrrInsu()));
        return list;
    }
}