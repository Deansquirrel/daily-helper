package com.yuansong.dailyHelper.features.mqreport.q16.service;

import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.q16.repository.Q16Do;
import com.yuansong.dailyHelper.features.mqreport.q16.repository.Q16Query;
import com.yuansong.dailyHelper.util.io.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q16Service {

    private final com.yuansong.dailyHelper.features.mqreport.q16.service.Q16RepService Q16RepService;

    public Q16Service(com.yuansong.dailyHelper.features.mqreport.q16.service.Q16RepService Q16RepService) {
        this.Q16RepService = Q16RepService;
    }

    public List<Q16Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return Q16RepService.getList(Q16Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "HI7其中建档立卡贫困人员-门诊大病.xlsx";
    }

    public XSSFWorkTable getQDataTable(List<Q16Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return XSSFWorkBookTool.getXSSFWorkTable("HI7其中建档立卡贫困人员-门诊大病", list, new Q16DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
