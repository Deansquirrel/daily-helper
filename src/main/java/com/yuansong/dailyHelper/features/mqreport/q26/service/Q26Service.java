package com.yuansong.dailyHelper.features.mqreport.q26.service;

import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.q26.repository.Q26Do;
import com.yuansong.dailyHelper.features.mqreport.q26.repository.Q26Query;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q26Service {

    private final Q26RepService Q26RepService;

    public Q26Service(Q26RepService Q26RepService) {
        this.Q26RepService = Q26RepService;
    }

    public List<Q26Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return Q26RepService.getList(Q26Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "HI7按照支出类别-住院按照支出类别.xlsx";
    }

    public XSSFWorkTable getQDataTable(List<Q26Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return XSSFWorkBookTool.getXSSFWorkTable("HI7按照支出类别-住院按照支出类别", list, new Q26DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
