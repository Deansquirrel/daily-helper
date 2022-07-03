package com.yuansong.dailyHelper.features.mqreport.q34.service;

import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.q34.repository.Q34Do;
import com.yuansong.dailyHelper.features.mqreport.q34.repository.Q34Query;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q34Service {

    private final Q34RepService Q34RepService;

    public Q34Service(Q34RepService Q34RepService) {
        this.Q34RepService = Q34RepService;
    }

    public List<Q34Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return Q34RepService.getList(Q34Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "HI8.1-异地结算总人数.xlsx";
    }

    public XSSFWorkTable getQDataTable(List<Q34Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return XSSFWorkBookTool.getXSSFWorkTable("HI8.1-异地结算总人数", list, new Q34DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
