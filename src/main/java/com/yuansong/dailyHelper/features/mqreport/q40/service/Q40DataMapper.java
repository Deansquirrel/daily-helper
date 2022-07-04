package com.yuansong.dailyHelper.features.mqreport.q40.service;

import com.github.deansquirrel.tools.poi.IDataMapper;
import com.yuansong.dailyHelper.features.mqreport.q40.repository.Q40Do;

import java.util.ArrayList;
import java.util.List;

public class Q40DataMapper implements IDataMapper<Q40Do> {
    @Override
    public List<String> getTitleList() {
        List<String> list = new ArrayList<>();
        list.add("区划");
        list.add("单位分类");
        list.add("参保单位数");
        list.add("参保人数");
        return list;
    }

    @Override
    public List<Object> getRowData(Q40Do data) {
        List<Object> list = new ArrayList<>();
        list.add(data.getInsuAdmdvs() == null ? "" : data.getInsuAdmdvs());
        list.add(data.getEmpType() == null ? "": data.getEmpType());
        list.add(data.getEmpCount() == null ? "" : data.getEmpCount());
        list.add(data.getPsnCount() == null ? "" : data.getPsnCount());
        return list;
    }
}
