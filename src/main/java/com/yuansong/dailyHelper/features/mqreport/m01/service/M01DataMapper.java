package com.yuansong.dailyHelper.features.mqreport.m01.service;

import com.github.deansquirrel.tools.poi.IDataMapper;
import com.yuansong.dailyHelper.features.mqreport.m01.repository.M01Do;

import java.util.ArrayList;
import java.util.List;

public class M01DataMapper implements IDataMapper<M01Do> {
    @Override
    public List<String> getTitleList() {
        List<String> list = new ArrayList<>();
        list.add("区划");
        list.add("人数");
        return list;
    }

    @Override
    public List<Object> getRowData(M01Do data) {
        List<Object> listM01 = new ArrayList<>();
        listM01.add(data.getInsuAdmdvs() == null ? "" : data.getInsuAdmdvs());
        listM01.add(data.getUrrInsu()  == null ? "" : String.valueOf(data.getUrrInsu()));
        return listM01;
    }
}
