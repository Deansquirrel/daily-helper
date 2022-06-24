package com.yuansong.dailyHelper.features.mqreport.q01.service;

import com.github.deansquirrel.tools.poi.IDataMapper;
import com.yuansong.dailyHelper.features.mqreport.m01.repository.M01Do;
import com.yuansong.dailyHelper.features.mqreport.q01.repository.Q01Do;

import java.util.ArrayList;
import java.util.List;

public class Q01DataMapper implements IDataMapper<Q01Do> {
    @Override
    public List<String> getTitleList() {
        List<String> list = new ArrayList<>();
        list.add("区划");
        list.add("单位分类");
        list.add("参保单位数");
        list.add("参保人数");
        list.add("退休人数");
        list.add("退休女职工人数");
        list.add("女职工人数");
        return list;
    }

    @Override
    public List<Object> getRowData(Q01Do data) {
        List<Object> list = new ArrayList<>();
        list.add(data.getInsuAdmdvs() == null ? "" : data.getInsuAdmdvs());
        list.add(data.getEmpType() == null ? "": data.getEmpType());
        list.add(data.getEmpCount() == null ? "" : data.getEmpCount());
        list.add(data.getPsnCount() == null ? "" : data.getPsnCount());
        list.add(data.getRetrCount() == null ? "" : data.getRetrCount());
        list.add(data.getRetrFemaleCount() == null ? "" : data.getRetrFemaleCount());
        list.add(data.getFemaleCount() == null ? "" : data.getFemaleCount());
        return list;
    }
}
