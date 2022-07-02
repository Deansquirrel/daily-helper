package com.yuansong.dailyHelper.features.mqreport.q21.service;

import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.q21.repository.Q21Do;
import com.yuansong.dailyHelper.features.mqreport.q21.repository.Q21Query;
import com.yuansong.dailyHelper.util.io.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q21Service {

    private final com.yuansong.dailyHelper.features.mqreport.q21.service.Q21RepService Q21RepService;

    public Q21Service(com.yuansong.dailyHelper.features.mqreport.q21.service.Q21RepService Q21RepService) {
        this.Q21RepService = Q21RepService;
    }

    public List<Q21Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return Q21RepService.getList(Q21Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "HI7其中60岁以上老人，学生-住院按照支出构成.xlsx";
    }

    public XSSFWorkTable getQDataTable(List<Q21Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return XSSFWorkBookTool.getXSSFWorkTable("HI7其中60岁以上老人，学生-住院按照支出构成", list, new Q21DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
