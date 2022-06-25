package com.yuansong.dailyHelper.features.mqreport.q03.service;

import com.github.deansquirrel.tools.poi.IDataMapper;
import com.yuansong.dailyHelper.features.mqreport.q03.repository.Q03Do;

import java.util.ArrayList;
import java.util.List;

public class Q03DataMapper implements IDataMapper<Q03Do> {
    @Override
    public List<String> getTitleList() {
        List<String> list = new ArrayList<>();
        list.add("区划");
        list.add("金额");
        return list;
    }

    @Override
    public List<Object> getRowData(Q03Do data) {
        List<Object> list = new ArrayList<>();
        list.add(data.getInsuAdmdvs());
        list.add(data.getClctSumamt());
        return list;
    }
}
