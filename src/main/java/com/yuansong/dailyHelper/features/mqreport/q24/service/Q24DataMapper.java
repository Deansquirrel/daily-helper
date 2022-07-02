package com.yuansong.dailyHelper.features.mqreport.q24.service;

import com.github.deansquirrel.tools.poi.IDataMapper;
import com.yuansong.dailyHelper.features.mqreport.q24.repository.Q24Do;

import java.util.ArrayList;
import java.util.List;

public class Q24DataMapper implements IDataMapper<Q24Do> {
    @Override
    public List<String> getTitleList() {
        List<String> list = new ArrayList<>();
        list.add("区划");
        list.add("项目");
        list.add("总金额");
        list.add("统筹支付");
        list.add("大病支付");
        list.add("其他支付");
        list.add("自付");
        list.add("自费");
        list.add("个人账户");
        list.add("目录外");
        list.add("就诊人次");
        return list;
    }

    @Override
    public List<Object> getRowData(Q24Do data) {
        List<Object> list = new ArrayList<>();
        list.add(data.getInsuAdmdvs());
        list.add(data.getDedcHospLv());
        list.add(data.getMedfeeSumamt());
        list.add(data.getHifpPay());
        list.add(data.getHifmiPay());
        list.add(data.getOtherPay());
        list.add(data.getZiFu());
        list.add(data.getZiFei());
        list.add(data.getAcctPay());
        list.add(data.getMuLuWai());
        list.add(data.gettCount());
        return list;
    }
}