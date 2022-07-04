package com.yuansong.dailyHelper.features.mqreport.q38.service;

import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.q38.repository.Q38Do;
import com.yuansong.dailyHelper.features.mqreport.q38.repository.Q38Query;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q38Service {

    private final Q38RepService q38RepService;

    public Q38Service(com.yuansong.dailyHelper.features.mqreport.q38.service.Q38RepService q38RepService) {
        this.q38RepService = q38RepService;
    }

    public List<Q38Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return q38RepService.getList(Q38Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "SI2大额报销人数.xlsx";
    }

    public XSSFWorkTable getQDataTable(List<Q38Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return XSSFWorkBookTool.getXSSFWorkTable("SI2大额报销人数", list, new Q38DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
