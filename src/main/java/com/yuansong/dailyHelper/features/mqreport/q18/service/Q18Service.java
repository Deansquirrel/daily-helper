package com.yuansong.dailyHelper.features.mqreport.q18.service;

import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.q18.repository.Q18Do;
import com.yuansong.dailyHelper.features.mqreport.q18.repository.Q18Query;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q18Service {

    private final com.yuansong.dailyHelper.features.mqreport.q18.service.Q18RepService Q18RepService;

    public Q18Service(com.yuansong.dailyHelper.features.mqreport.q18.service.Q18RepService Q18RepService) {
        this.Q18RepService = Q18RepService;
    }

    public List<Q18Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return Q18RepService.getList(Q18Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "HI7其中建档立卡贫困人员-住院按照支出类别.xlsx";
    }

    public XSSFWorkTable getQDataTable(List<Q18Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return XSSFWorkBookTool.getXSSFWorkTable("HI7其中建档立卡贫困人员-住院按照支出类别", list, new Q18DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
