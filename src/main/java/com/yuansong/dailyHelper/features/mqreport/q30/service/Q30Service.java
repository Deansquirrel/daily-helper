package com.yuansong.dailyHelper.features.mqreport.q30.service;

import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.q30.repository.Q30Do;
import com.yuansong.dailyHelper.features.mqreport.q30.repository.Q30Query;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q30Service {

    private final Q30RepService Q30RepService;

    public Q30Service(Q30RepService Q30RepService) {
        this.Q30RepService = Q30RepService;
    }

    public List<Q30Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return Q30RepService.getList(Q30Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "HI8-住院.xlsx";
    }

    public XSSFWorkTable getQDataTable(List<Q30Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return XSSFWorkBookTool.getXSSFWorkTable("HI8-住院", list, new Q30DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
