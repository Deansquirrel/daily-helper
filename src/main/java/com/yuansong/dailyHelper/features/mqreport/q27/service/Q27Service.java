package com.yuansong.dailyHelper.features.mqreport.q27.service;

import com.github.deansquirrel.tools.poi.WorkBookTool;
import com.github.deansquirrel.tools.poi.WorkTableData;
import com.yuansong.dailyHelper.features.mqreport.q27.repository.Q27Do;
import com.yuansong.dailyHelper.features.mqreport.q27.repository.Q27Query;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q27Service {

    private final Q27RepService Q27RepService;

    public Q27Service(Q27RepService Q27RepService) {
        this.Q27RepService = Q27RepService;
    }

    public List<Q27Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return Q27RepService.getList(Q27Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "HI7.1、HI7.2慢病、两病用药.xlsx";
    }

    public WorkTableData getQDataTable(List<Q27Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return WorkBookTool.getXSSFWorkTable("HI7.1、HI7.2慢病、两病用药", list, new Q27DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
