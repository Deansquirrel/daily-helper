package com.yuansong.dailyHelper.features.mqreport.q36.service;

import com.github.deansquirrel.tools.poi.IDataMapper;
import com.yuansong.dailyHelper.features.mqreport.q36.repository.Q36Do;

import java.util.ArrayList;
import java.util.List;

public class Q36DataMapper implements IDataMapper<Q36Do> {
    @Override
    public List<String> getTitleList() {
        List<String> list = new ArrayList<>();
        list.add("区划");
        list.add("转入农民工合计");
        list.add("转入农民工合计省外");
        list.add("职工医保转入职工医保合计");
        list.add("职工医保转入职工医保省外");
        list.add("职工医保转入居民医保合计");
        list.add("居民医保转入职工医保合计");
        list.add("转入金额合计");
        list.add("转出合计");
        list.add("转出到省外合计");
        list.add("转出农民工合计");
        list.add("转出农民工省外");
        list.add("转出地清算给个人合计");
        list.add("转出地清算给个人省外");
        return list;
    }

    @Override
    public List<Object> getRowData(Q36Do data) {
        List<Object> list = new ArrayList<>();
        list.add(data.getInsuAdmdvs());
        list.add(data.getA01());
        list.add(data.getA02());
        list.add(data.getA03());
        list.add(data.getA04());
        list.add(data.getA05());
        list.add(data.getA06());
        list.add(data.getA07());
        list.add(data.getB01());
        list.add(data.getB02());
        list.add(data.getB03());
        list.add(data.getB04());
        list.add(data.getB05());
        list.add(data.getB06());
        return list;
    }
}
