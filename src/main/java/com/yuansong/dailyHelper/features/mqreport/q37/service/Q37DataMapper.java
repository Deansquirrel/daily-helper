package com.yuansong.dailyHelper.features.mqreport.q37.service;

import com.github.deansquirrel.tools.poi.IDataMapper;
import com.yuansong.dailyHelper.features.mqreport.q37.repository.Q37Do;

import java.util.ArrayList;
import java.util.List;

public class Q37DataMapper implements IDataMapper<Q37Do> {
    @Override
    public List<String> getTitleList() {
        List<String> list = new ArrayList<>();
        list.add("区划");
        list.add("单位分类");
        list.add("计划生育金额");
        list.add("计划生育人次");
        list.add("流产金额");
        list.add("流产人次");
        list.add("生育金额");
        list.add("生育人次");
        list.add("顺产金额");
        list.add("顺产人次");
        list.add("生育津贴金额");
        list.add("生育津贴人次");
        list.add("本期享受待遇女性-人次");
        list.add("本期享受待遇女性-人数");

        return list;
    }

    @Override
    public List<Object> getRowData(Q37Do data) {
        List<Object> list = new ArrayList<>();
        list.add(data.getInsuAdmdvs());
        list.add(data.getEmpType());
        list.add(data.getA01());
        list.add(data.getA02());
        list.add(data.getB01());
        list.add(data.getB02());
        list.add(data.getC01());
        list.add(data.getC02());
        list.add(data.getD01());
        list.add(data.getD02());
        list.add(data.getE01());
        list.add(data.getE02());
        list.add(data.getF01());
        list.add(data.getF02());
        return list;
    }
}
