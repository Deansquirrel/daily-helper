package com.yuansong.dailyHelper.features.mqreport.q20.service;

import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.q20.repository.Q20Do;
import com.yuansong.dailyHelper.features.mqreport.q20.repository.Q20Query;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q20Service {

    private final com.yuansong.dailyHelper.features.mqreport.q20.service.Q20RepService Q20RepService;

    public Q20Service(com.yuansong.dailyHelper.features.mqreport.q20.service.Q20RepService Q20RepService) {
        this.Q20RepService = Q20RepService;
    }

    public List<Q20Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return Q20RepService.getList(Q20Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "HI7其中60岁以上老人，学生-慢病.xlsx";
    }

    public XSSFWorkTable getQDataTable(List<Q20Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return XSSFWorkBookTool.getXSSFWorkTable("HI7其中60岁以上老人，学生-慢病", list, new Q20DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
