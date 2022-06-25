package com.yuansong.dailyHelper.features.mqreport.q02.service;

import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.q02.repository.Q02Do;
import com.yuansong.dailyHelper.features.mqreport.q02.repository.Q02Query;
import com.yuansong.dailyHelper.util.io.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q02Service {

    private final Q02RepService Q02RepService;

    public Q02Service(Q02RepService Q02RepService) {
        this.Q02RepService = Q02RepService;
    }

    public List<Q02Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return Q02RepService.getList(Q02Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "HI3保险费征缴情况.xlsx";
    }

    public XSSFWorkTable getQDataTable(List<Q02Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return XSSFWorkBookTool.getXSSFWorkTable("HI3保险费征缴情况", list, new Q02DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
