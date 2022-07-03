package com.yuansong.dailyHelper.features.mqreport.q31.service;

import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.q31.repository.Q31Do;
import com.yuansong.dailyHelper.features.mqreport.q31.repository.Q31Query;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q31Service {

    private final Q31RepService Q31RepService;

    public Q31Service(Q31RepService Q31RepService) {
        this.Q31RepService = Q31RepService;
    }

    public List<Q31Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return Q31RepService.getList(Q31Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "HI8.1-普通门诊.xlsx";
    }

    public XSSFWorkTable getQDataTable(List<Q31Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return XSSFWorkBookTool.getXSSFWorkTable("HI8.1-普通门诊", list, new Q31DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
