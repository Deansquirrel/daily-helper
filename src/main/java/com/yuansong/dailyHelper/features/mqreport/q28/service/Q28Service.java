package com.yuansong.dailyHelper.features.mqreport.q28.service;

import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.q28.repository.Q28Do;
import com.yuansong.dailyHelper.features.mqreport.q28.repository.Q28Query;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q28Service {

    private final Q28RepService Q28RepService;

    public Q28Service(Q28RepService Q28RepService) {
        this.Q28RepService = Q28RepService;
    }

    public List<Q28Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return Q28RepService.getList(Q28Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "HI8-普通门诊.xlsx";
    }

    public XSSFWorkTable getQDataTable(List<Q28Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return XSSFWorkBookTool.getXSSFWorkTable("HI8-普通门诊", list, new Q28DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
