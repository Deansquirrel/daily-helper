package com.yuansong.dailyHelper.features.mqreport.q40.service;

import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.q40.repository.Q40Do;
import com.yuansong.dailyHelper.features.mqreport.q40.repository.Q40Query;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q40Service {

    private final Q40RepService q40RepService;

    public Q40Service(Q40RepService q40RepService) {
        this.q40RepService = q40RepService;
    }

    public List<Q40Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return q40RepService.getList(Q40Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "SI大额参保人数.xlsx";
    }

    public XSSFWorkTable getQDataTable(List<Q40Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return XSSFWorkBookTool.getXSSFWorkTable("SI大额参保人数", list, new Q40DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
