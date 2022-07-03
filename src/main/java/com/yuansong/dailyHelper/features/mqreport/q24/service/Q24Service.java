package com.yuansong.dailyHelper.features.mqreport.q24.service;

import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.q24.repository.Q24Do;
import com.yuansong.dailyHelper.features.mqreport.q24.repository.Q24Query;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q24Service {

    private final com.yuansong.dailyHelper.features.mqreport.q24.service.Q24RepService Q24RepService;

    public Q24Service(com.yuansong.dailyHelper.features.mqreport.q24.service.Q24RepService Q24RepService) {
        this.Q24RepService = Q24RepService;
    }

    public List<Q24Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return Q24RepService.getList(Q24Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "HI7按照医疗级别-慢特病.xlsx";
    }

    public XSSFWorkTable getQDataTable(List<Q24Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return XSSFWorkBookTool.getXSSFWorkTable("HI7按照医疗级别-慢特病", list, new Q24DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
