package com.yuansong.dailyHelper.features.mqreport.q03.service;

import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.q03.repository.Q03Do;
import com.yuansong.dailyHelper.features.mqreport.q03.repository.Q03Query;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q03Service {

    private final Q03RepService Q03RepService;

    public Q03Service(com.yuansong.dailyHelper.features.mqreport.q03.service.Q03RepService Q03RepService) {
        this.Q03RepService = Q03RepService;
    }

    public List<Q03Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return Q03RepService.getList(Q03Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "HI3一次性缴费.xlsx";
    }

    public XSSFWorkTable getQDataTable(List<Q03Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return XSSFWorkBookTool.getXSSFWorkTable("HI3一次性缴费", list, new Q03DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
