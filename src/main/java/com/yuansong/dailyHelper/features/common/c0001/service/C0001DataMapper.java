package com.yuansong.dailyHelper.features.common.c0001.service;

import com.github.deansquirrel.tools.poi.IDataMapper;
import com.yuansong.dailyHelper.features.common.c0001.repository.C0001Do;

import java.util.ArrayList;
import java.util.List;

public class C0001DataMapper implements IDataMapper<C0001Do> {
    @Override
    public List<String> getTitleList() {
        List<String> list = new ArrayList<>();
        list.add("区划");
        list.add("定点编号");
        list.add("定点名称");
        list.add("险种");
        list.add("清算年月");
        list.add("预留金");
        list.add("实拨");
        return list;
    }

    @Override
    public List<Object> getRowData(C0001Do d) {
        List<Object> list = new ArrayList<>();
        list.add(d.getClrOptins());
        list.add(d.getFixmedinsCode());
        list.add(d.getFixmedinsName());
        list.add(d.getInsuType());
        list.add(d.getClrYm());
        list.add(d.getDpstSumamt());
        list.add(d.getActDfrAmt());
        return list;
    }
}
