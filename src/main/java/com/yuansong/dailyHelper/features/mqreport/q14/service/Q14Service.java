package com.yuansong.dailyHelper.features.mqreport.q14.service;

import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.q14.repository.Q14Do;
import com.yuansong.dailyHelper.features.mqreport.q14.repository.Q14Query;
import com.yuansong.dailyHelper.util.io.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q14Service {

    private final com.yuansong.dailyHelper.features.mqreport.q14.service.Q14RepService Q14RepService;

    public Q14Service(com.yuansong.dailyHelper.features.mqreport.q14.service.Q14RepService Q14RepService) {
        this.Q14RepService = Q14RepService;
    }

    public List<Q14Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return Q14RepService.getList(Q14Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "HI4.1住院人数.xlsx";
    }

    public XSSFWorkTable getQDataTable(List<Q14Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return XSSFWorkBookTool.getXSSFWorkTable("HI4.1住院人数", list, new Q14DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
