package com.yuansong.dailyHelper.features.mqreport.q36.service;

import com.github.deansquirrel.tools.poi.WorkBookTool;
import com.github.deansquirrel.tools.poi.WorkTableData;
import com.yuansong.dailyHelper.features.mqreport.q36.repository.Q36Do;
import com.yuansong.dailyHelper.features.mqreport.q36.repository.Q36Query;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q36Service {

    private final Q36RepService q36RepService;

    public Q36Service(Q36RepService q36RepService) {
        this.q36RepService = q36RepService;
    }

    public List<Q36Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return q36RepService.getList(Q36Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "HI10-转移相关查询.xlsx";
    }

    public WorkTableData getQDataTable(List<Q36Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return WorkBookTool.getXSSFWorkTable("HI10-转移相关查询", list, new Q36DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
