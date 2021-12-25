package com.yuansong.dailyHelper.features.evss;

import com.github.deansquirrel.tools.poi.IDataMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EvssDODataMapper implements IDataMapper<EvssDO> {
    @Override
    public List<String> getTitleList() {
        return Arrays.asList("行政区划编码","定点医药机构编码","定点医药机构名称","结算总人次");
    }

    @Override
    public List<Object> getRowData(EvssDO data) {
        List<Object> list = new ArrayList<>();
        list.add(getObj(data.getFixmedinsCode()));
        list.add(getObj(data.getFixmedinsCode()));
        list.add(getObj(data.getFixmedinsName()));
        list.add(getObj(data.getTotalRc()));
        return list;
    }

    private Object getObj(Object obj) {
        if(obj == null) {
            return "";
        }
        return obj;
    }
}
