package com.yuansong.dailyHelper.features.mqreport.q08.service;

import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.q08.repository.Q08Do;
import com.yuansong.dailyHelper.features.mqreport.q08.repository.Q08Query;
import com.yuansong.dailyHelper.util.io.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q08Service {

    private final com.yuansong.dailyHelper.features.mqreport.q08.service.Q08RepService Q08RepService;

    public Q08Service(com.yuansong.dailyHelper.features.mqreport.q08.service.Q08RepService Q08RepService) {
        this.Q08RepService = Q08RepService;
    }

    public List<Q08Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return Q08RepService.getList(Q08Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "HI4药店-药店在职退休.xlsx";
    }

    public XSSFWorkTable getQDataTable(List<Q08Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return XSSFWorkBookTool.getXSSFWorkTable("HI4药店-药店在职退休", list, new Q08DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
