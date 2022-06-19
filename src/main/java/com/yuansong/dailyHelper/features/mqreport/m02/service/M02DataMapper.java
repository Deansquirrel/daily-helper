package com.yuansong.dailyHelper.features.mqreport.m02.service;

import com.github.deansquirrel.tools.poi.IDataMapper;
import com.yuansong.dailyHelper.features.mqreport.m02.repository.M02Do;

import java.util.ArrayList;
import java.util.List;

public class M02DataMapper implements IDataMapper<M02Do> {
    @Override
    public List<String> getTitleList() {
        List<String> list = new ArrayList<>();
        list.add("区划");
        list.add("人数");
        return list;
    }

    @Override
    public List<Object> getRowData(M02Do data) {
        List<Object> listM02 = new ArrayList<>();
        listM02.add(data.getInsuAdmdvs() == null ? "" : data.getInsuAdmdvs());
        listM02.add(data.getUrrInsu()  == null ? "" : String.valueOf(data.getUrrInsu()));
        return listM02;
    }
}
