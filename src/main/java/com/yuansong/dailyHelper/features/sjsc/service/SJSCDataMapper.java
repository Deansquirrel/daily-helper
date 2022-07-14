package com.yuansong.dailyHelper.features.sjsc.service;

import com.github.deansquirrel.tools.common.DateTool;
import com.github.deansquirrel.tools.poi.IDataMapper;
import com.yuansong.dailyHelper.features.sjsc.repository.SJSCDo;

import java.util.ArrayList;
import java.util.List;

public class SJSCDataMapper implements IDataMapper<SJSCDo> {
    @Override
    public List<String> getTitleList() {
        List<String> list = new ArrayList<>();
        list.add("办件编号");
        list.add("三级四从事项实施编码");
        list.add("事项名称");
        list.add("申请人证件类型");
        list.add("申请人证件号码");
        list.add("用户姓名");
        list.add("评价人联系电话");
        list.add("收件时间");
        list.add("承诺办结时间");
        list.add("法定办结时间");
        list.add("整体满意度");
        list.add("评价时间");
        return list;
    }

    @Override
    public List<Object> getRowData(SJSCDo d) {
        List<Object> list = new ArrayList<>();
        list.add(d.getA01());
        list.add(d.getA02());
        list.add(d.getA03());
        list.add(d.getA04());
        list.add(d.getA05());
        list.add(d.getA06());
        list.add(d.getA07());
        list.add(DateTool.GetDateTimeStr(d.getA08()));
        list.add(DateTool.GetDateTimeStr(d.getA09()));
        list.add(DateTool.GetDateTimeStr(d.getA10()));
        list.add(d.getA11());
        list.add(DateTool.GetDateTimeStr(d.getA12()));
        return list;
    }
}
