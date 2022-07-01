package com.yuansong.dailyHelper.features.mqreport.q20.service;

import com.github.deansquirrel.tools.poi.IDataMapper;
import com.yuansong.dailyHelper.features.mqreport.q20.repository.Q20Do;

import java.util.ArrayList;
import java.util.List;

public class Q20DataMapper implements IDataMapper<Q20Do> {
    @Override
    public List<String> getTitleList() {
        List<String> list = new ArrayList<>();
        list.add("区划");
        list.add("人员类型");
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
    public List<Object> getRowData(Q20Do data) {
        List<Object> list = new ArrayList<>();
        list.add(data.getInsuAdmdvs());
        list.add(data.getPsnType());
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
