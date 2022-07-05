package com.yuansong.dailyHelper.features.mqreport.q27.service;

import com.github.deansquirrel.tools.poi.IDataMapper;
import com.yuansong.dailyHelper.features.mqreport.q27.repository.Q27Do;

import java.util.ArrayList;
import java.util.List;

public class Q27DataMapper implements IDataMapper<Q27Do> {
    @Override
    public List<String> getTitleList() {
        List<String> list = new ArrayList<>();
        list.add("区划");
        list.add("类型");
        list.add("人数");
        list.add("人次");
        list.add("总金额");
        list.add("统筹支付");
        list.add("大病");
        list.add("其他支付");
        list.add("自付");
        list.add("自费");
        return list;
    }

    @Override
    public List<Object> getRowData(Q27Do data) {
        List<Object> list = new ArrayList<>();
        list.add(data.getInsuAdmdvs());
        list.add(data.getDiseType());
        list.add(data.getRenShu());
        list.add(data.getRenCi());
        list.add(data.getMedfeeSumamt());
        list.add(data.getHifpPay());
        list.add(data.getHifmiPay());
        list.add(data.getOtherPay());
        list.add(data.getZiFu());
        list.add(data.getZiFei());
        return list;
    }
}