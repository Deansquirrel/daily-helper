package com.yuansong.dailyHelper.features.mqreortv2;

import com.github.deansquirrel.tools.poi.IDataMapper;
import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.util.tool.FileUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface IService<T, S extends IRepService<T>> {

    S getService();

    String getFileName();

    IDataMapper<T> getDataMapper();

    default List<T> getData(Date month) {
        if(month == null) {
            month = MQReportQuery.getDefaultQueryMonth();
        }
        return this.getService().getList(MQReportQuery.builder().setMonth(month));
    }

    default String getExportFileName() {
        return FileUtil.getNextStr() + getFileName() + ".xlsx";
    }

    default XSSFWorkTable getDataTable(List<T> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return XSSFWorkBookTool.getXSSFWorkTable(getFileName(), list, getDataMapper());
    }

}
