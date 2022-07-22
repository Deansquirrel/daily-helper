package com.yuansong.dailyHelper.features.mqreport.q29.service;

import com.github.deansquirrel.tools.poi.WorkBookTool;
import com.github.deansquirrel.tools.poi.WorkTableData;
import com.yuansong.dailyHelper.features.mqreport.q29.repository.Q29Do;
import com.yuansong.dailyHelper.features.mqreport.q29.repository.Q29Query;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q29Service {

    private final com.yuansong.dailyHelper.features.mqreport.q29.service.Q29RepService Q29RepService;

    public Q29Service(com.yuansong.dailyHelper.features.mqreport.q29.service.Q29RepService Q29RepService) {
        this.Q29RepService = Q29RepService;
    }

    public List<Q29Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return Q29RepService.getList(Q29Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "HI8-慢特病.xlsx";
    }

    public WorkTableData getQDataTable(List<Q29Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return WorkBookTool.getXSSFWorkTable("HI8-慢特病", list, new Q29DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
