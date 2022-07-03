package com.yuansong.dailyHelper.features.mqreport.q32.service;

import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.q32.repository.Q32Do;
import com.yuansong.dailyHelper.features.mqreport.q32.repository.Q32Query;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q32Service {

    private final Q32RepService Q32RepService;

    public Q32Service(Q32RepService Q32RepService) {
        this.Q32RepService = Q32RepService;
    }

    public List<Q32Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return Q32RepService.getList(Q32Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "HI8.1-门诊慢特病.xlsx";
    }

    public XSSFWorkTable getQDataTable(List<Q32Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return XSSFWorkBookTool.getXSSFWorkTable("HI8.1-门诊慢特病", list, new Q32DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
