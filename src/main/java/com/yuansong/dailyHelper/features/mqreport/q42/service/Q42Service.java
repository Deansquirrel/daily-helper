package com.yuansong.dailyHelper.features.mqreport.q42.service;

import com.github.deansquirrel.tools.poi.WorkBookTool;
import com.github.deansquirrel.tools.poi.WorkTableData;
import com.yuansong.dailyHelper.features.mqreport.q42.repository.Q42Do;
import com.yuansong.dailyHelper.features.mqreport.q42.repository.Q42Query;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q42Service {

    private final Q42RepService q42RepService;

    public Q42Service(Q42RepService q42RepService) {
        this.q42RepService = q42RepService;
    }

    public List<Q42Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return q42RepService.getList(Q42Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "异地备案人次.xlsx";
    }

    public WorkTableData getQDataTable(List<Q42Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return WorkBookTool.getXSSFWorkTable("异地备案人次", list, new Q42DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
