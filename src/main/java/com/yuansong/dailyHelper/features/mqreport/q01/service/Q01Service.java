package com.yuansong.dailyHelper.features.mqreport.q01.service;

import com.github.deansquirrel.tools.poi.WorkBookTool;
import com.github.deansquirrel.tools.poi.WorkTableData;
import com.yuansong.dailyHelper.features.mqreport.q01.repository.Q01Do;
import com.yuansong.dailyHelper.features.mqreport.q01.repository.Q01Query;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q01Service {

    private final Q01RepService Q01RepService;

    public Q01Service(Q01RepService Q01RepService) {
        this.Q01RepService = Q01RepService;
    }

    public List<Q01Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return Q01RepService.getList(Q01Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "HI2参保人数.xlsx";
    }

    public WorkTableData getQDataTable(List<Q01Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return WorkBookTool.getXSSFWorkTable("HI2参保人数", list, new Q01DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
