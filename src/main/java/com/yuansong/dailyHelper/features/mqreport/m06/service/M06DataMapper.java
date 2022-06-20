package com.yuansong.dailyHelper.features.mqreport.m06.service;

import com.github.deansquirrel.tools.poi.IDataMapper;
import com.yuansong.dailyHelper.features.mqreport.m06.repository.M06Do;

import java.util.ArrayList;
import java.util.List;

public class M06DataMapper implements IDataMapper<M06Do> {
    @Override
    public List<String> getTitleList() {
        List<String> list = new ArrayList<>();
        list.add("区划");
        list.add("人数");
        return list;
    }

    @Override
    public List<Object> getRowData(M06Do data) {
        List<Object> list = new ArrayList<>();
        list.add(data.getInsuAdmdvs() == null ? "" : data.getInsuAdmdvs());
        list.add(data.getUrrInsu()  == null ? "" : String.valueOf(data.getUrrInsu()));
        return list;
    }
}
