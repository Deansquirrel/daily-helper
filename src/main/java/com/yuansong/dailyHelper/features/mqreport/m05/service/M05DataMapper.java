package com.yuansong.dailyHelper.features.mqreport.m05.service;

import com.github.deansquirrel.tools.poi.IDataMapper;
import com.yuansong.dailyHelper.features.mqreport.m04.repository.M04Do;
import com.yuansong.dailyHelper.features.mqreport.m05.repository.M05Do;

import java.util.ArrayList;
import java.util.List;

public class M05DataMapper implements IDataMapper<M05Do> {
    @Override
    public List<String> getTitleList() {
        List<String> list = new ArrayList<>();
        list.add("区划");
        list.add("参保-女性人数");
        list.add("享受待遇人次（结算+津贴）");
        list.add("享受待遇-女性-人次（结算）");
        list.add("享受待遇-女性-人数（结算）");
        list.add("计划生育人次");
        return list;
    }

    @Override
    public List<Object> getRowData(M05Do data) {
        List<Object> list = new ArrayList<>();
        list.add(data.getInsuAdmdvs() == null ? "" : data.getInsuAdmdvs());
        list.add(data.getA01()  == null ? "" : String.valueOf(data.getA01()));
        list.add(data.getB01()  == null ? "" : String.valueOf(data.getB01()));
        list.add(data.getC01()  == null ? "" : String.valueOf(data.getC01()));
        list.add(data.getC02()  == null ? "" : String.valueOf(data.getC02()));
        list.add(data.getD01()  == null ? "" : String.valueOf(data.getD01()));
        return list;
    }
}
