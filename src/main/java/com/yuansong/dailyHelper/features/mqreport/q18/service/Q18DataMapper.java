package com.yuansong.dailyHelper.features.mqreport.q18.service;

import com.github.deansquirrel.tools.poi.IDataMapper;
import com.yuansong.dailyHelper.features.mqreport.q18.repository.Q18Do;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Q18DataMapper implements IDataMapper<Q18Do> {

    @Override
    public List<String> getTitleList() {
        List<String> list = new ArrayList<>();
        list.add("区划");
        list.add("药品目录内");
        list.add("药品目录外");
        list.add("项目目录内");
        list.add("项目目录外");
        list.add("服务设施目录内");
        list.add("服务设施目录外");
        return list;
    }

    @Override
    public List<Object> getRowData(Q18Do data) {
        List<Object> list = new ArrayList<>();
        list.add(data.getInsuAdmdvs());
        list.add(data.getA01().compareTo(BigDecimal.ZERO) == 0 ? "" : data.getA01());
        list.add(data.getA02().compareTo(BigDecimal.ZERO) == 0 ? "" : data.getA02());
        list.add(data.getB01().compareTo(BigDecimal.ZERO) == 0 ? "" : data.getB01());
        list.add(data.getB01().compareTo(BigDecimal.ZERO) == 0 ? "" : data.getB02());
        list.add(data.getC01().compareTo(BigDecimal.ZERO) == 0 ? "" : data.getC01());
        list.add(data.getC02().compareTo(BigDecimal.ZERO) == 0 ? "" : data.getC02());
        return list;
    }
}
