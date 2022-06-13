package com.yuansong.dailyHelper.featuresH.evss;

import com.github.deansquirrel.tools.common.DateTool;
import com.github.deansquirrel.tools.poi.IDataMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EvssDODataMapper implements IDataMapper<EvssDO> {
    @Override
    public List<String> getTitleList() {
        String mon = DateTool.GetStr("MM")+"月";

        return Arrays.asList("行政区划编码","定点医药机构编码","定点医药机构名称",
                "结算总人次","社保卡结算人次","电子凭证结算人次","电子凭证结算人数",
                mon+"结算总人次",mon+"社保卡结算人次",mon+"电子凭证结算人次",mon+"电子凭证结算人数");
    }

    @Override
    public List<Object> getRowData(EvssDO data) {
        if(data == null) return null;
        List<Object> list = new ArrayList<>();
//        list.add(getObj(data.getFixmedinsCode()));
//        list.add(getObj(data.getFixmedinsCode()));
//        list.add(getObj(data.getFixmedinsName()));
//        list.add(getObj(data.getTotalRc()));
//        list.add(getObj(data.getSbkRc()));
//        list.add(getObj(data.getDzpzRc()));
//        list.add(getObj(data.getDzpzRs()));
//        list.add(getObj(data.getCurrTotalRc()));
//        list.add(getObj(data.getCurrSbkRc()));
//        list.add(getObj(data.getCurrDzpzRc()));
//        list.add(getObj(data.getCurrDzpzRs()));
        list.add(data.getFixBlngAdmdvs());
        list.add(data.getFixmedinsCode());
        list.add(data.getFixmedinsName());
        list.add(data.getTotalRc());
        list.add(data.getSbkRc());
        list.add(data.getDzpzRc());
        list.add(data.getDzpzRs());
        list.add(data.getCurrTotalRc());
        list.add(data.getCurrSbkRc());
        list.add(data.getCurrDzpzRc());
        list.add(data.getCurrDzpzRs());
        return list;
    }
}
