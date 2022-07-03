package com.yuansong.dailyHelper.features.mqreport.q33.service;

import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.q33.repository.Q33Do;
import com.yuansong.dailyHelper.features.mqreport.q33.repository.Q33Query;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q33Service {

    private final Q33RepService Q33RepService;

    public Q33Service(Q33RepService Q33RepService) {
        this.Q33RepService = Q33RepService;
    }

    public List<Q33Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return Q33RepService.getList(Q33Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "HI8.1-住院.xlsx";
    }

    public XSSFWorkTable getQDataTable(List<Q33Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return XSSFWorkBookTool.getXSSFWorkTable("HI8.1-住院", list, new Q33DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
