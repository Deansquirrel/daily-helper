package com.yuansong.dailyHelper.features.mqreport.q02.service;

import com.github.deansquirrel.tools.poi.IDataMapper;
import com.yuansong.dailyHelper.features.mqreport.q02.repository.Q02Do;

import java.util.ArrayList;
import java.util.List;

public class Q02DataMapper implements IDataMapper<Q02Do> {
    @Override
    public List<String> getTitleList() {
        List<String> list = new ArrayList<>();
        list.add("区划");
        list.add("单位分类");
        list.add("单位缴费基数");
        list.add("个人缴费基数");
        list.add("本期单位应缴");
        list.add("本期个人应缴");
        list.add("单位划入个人账户");
        list.add("其中划入退休人员账户");
        return list;
    }

    @Override
    public List<Object> getRowData(Q02Do data) {
        List<Object> list = new ArrayList<>();
        list.add(data.getInsuAdmdvs() == null ? "" : data.getInsuAdmdvs());
        list.add(data.getEmpType() == null ? "": data.getEmpType());
        list.add(data.getEmpClctStd() == null ? "" : data.getEmpClctStd());
        list.add(data.getPsnClctStd());
        list.add(data.getEmpClctAmt());
        list.add(data.getPsnClctAmt());
        list.add(data.getEmpClctIntoAcctAmt());
        list.add(data.getEmpClctIntoRetrAcctAmt());
        return list;
    }
}
