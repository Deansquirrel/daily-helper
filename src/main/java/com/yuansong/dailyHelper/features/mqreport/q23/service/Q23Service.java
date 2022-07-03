package com.yuansong.dailyHelper.features.mqreport.q23.service;

import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.q23.repository.Q23Do;
import com.yuansong.dailyHelper.features.mqreport.q23.repository.Q23Query;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q23Service {

    private final com.yuansong.dailyHelper.features.mqreport.q23.service.Q23RepService Q23RepService;

    public Q23Service(com.yuansong.dailyHelper.features.mqreport.q23.service.Q23RepService Q23RepService) {
        this.Q23RepService = Q23RepService;
    }

    public List<Q23Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return Q23RepService.getList(Q23Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "HI7按照医疗级别-门诊.xlsx";
    }

    public XSSFWorkTable getQDataTable(List<Q23Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return XSSFWorkBookTool.getXSSFWorkTable("HI7按照医疗级别-门诊", list, new Q23DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
