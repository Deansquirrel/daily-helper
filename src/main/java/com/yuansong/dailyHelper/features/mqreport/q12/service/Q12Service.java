package com.yuansong.dailyHelper.features.mqreport.q12.service;

import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.q12.repository.Q12Do;
import com.yuansong.dailyHelper.features.mqreport.q12.repository.Q12Query;
import com.yuansong.dailyHelper.util.io.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q12Service {

    private final com.yuansong.dailyHelper.features.mqreport.q12.service.Q12RepService Q12RepService;

    public Q12Service(com.yuansong.dailyHelper.features.mqreport.q12.service.Q12RepService Q12RepService) {
        this.Q12RepService = Q12RepService;
    }

    public List<Q12Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return Q12RepService.getList(Q12Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "HI4.1住院按照支出类别-在职退休.xlsx";
    }

    public XSSFWorkTable getQDataTable(List<Q12Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return XSSFWorkBookTool.getXSSFWorkTable("HI4.1住院按照支出类别-在职退休", list, new Q12DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
