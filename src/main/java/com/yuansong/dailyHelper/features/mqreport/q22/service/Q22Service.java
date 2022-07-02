package com.yuansong.dailyHelper.features.mqreport.q22.service;

import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.q22.repository.Q22Do;
import com.yuansong.dailyHelper.features.mqreport.q22.repository.Q22Query;
import com.yuansong.dailyHelper.util.io.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q22Service {

    private final com.yuansong.dailyHelper.features.mqreport.q22.service.Q22RepService Q22RepService;

    public Q22Service(com.yuansong.dailyHelper.features.mqreport.q22.service.Q22RepService Q22RepService) {
        this.Q22RepService = Q22RepService;
    }

    public List<Q22Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return Q22RepService.getList(Q22Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "HI7其中60岁以上老人，学生-住院按照支出类别.xlsx";
    }

    public XSSFWorkTable getQDataTable(List<Q22Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return XSSFWorkBookTool.getXSSFWorkTable("HI7其中60岁以上老人，学生-住院按照支出类别", list, new Q22DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
