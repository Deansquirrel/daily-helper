package com.yuansong.dailyHelper.features.mqreport.q10.service;

import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.q10.repository.Q10Do;
import com.yuansong.dailyHelper.features.mqreport.q10.repository.Q10Query;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q10Service {

    private final Q10RepService Q10RepService;

    public Q10Service(Q10RepService Q10RepService) {
        this.Q10RepService = Q10RepService;
    }

    public List<Q10Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return Q10RepService.getList(Q10Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "HI4享受待遇人数.xlsx";
    }

    public XSSFWorkTable getQDataTable(List<Q10Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return XSSFWorkBookTool.getXSSFWorkTable("HI4享受待遇人数", list, new Q10DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
