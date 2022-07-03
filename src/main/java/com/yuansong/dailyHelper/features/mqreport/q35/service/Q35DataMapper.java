package com.yuansong.dailyHelper.features.mqreport.q35.service;

import com.github.deansquirrel.tools.poi.IDataMapper;
import com.yuansong.dailyHelper.features.mqreport.q35.repository.Q35Do;

import java.util.ArrayList;
import java.util.List;

public class Q35DataMapper implements IDataMapper<Q35Do> {
    @Override
    public List<String> getTitleList() {
        List<String> list = new ArrayList<>();
        list.add("范围");
        list.add("区划");
        list.add("基本支付");
        list.add("大病支付");
        list.add("贫困支付");
        list.add("自付");
        list.add("自费");
        list.add("人数");
        list.add("人次");
        return list;
    }

    @Override
    public List<Object> getRowData(Q35Do data) {
        List<Object> list = new ArrayList<>();
        list.add(data.getPsnRange());
        list.add(data.getInsuAdmdvs());
        list.add(data.getHifpPay());
        list.add(data.getHifmiPay());
        list.add(data.getMafPay());
        list.add(data.getZiFu());
        list.add(data.getZiFei());
        list.add(data.getRenShu());
        list.add(data.getRenCi());
        return list;
    }
}
