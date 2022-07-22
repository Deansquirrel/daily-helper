package com.yuansong.dailyHelper.features.mqreport.q37.service;

import com.github.deansquirrel.tools.poi.WorkBookTool;
import com.github.deansquirrel.tools.poi.WorkTableData;
import com.yuansong.dailyHelper.features.mqreport.q37.repository.Q37Do;
import com.yuansong.dailyHelper.features.mqreport.q37.repository.Q37Query;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q37Service {

    private final Q37RepService q37RepService;

    public Q37Service(Q37RepService q37RepService) {
        this.q37RepService = q37RepService;
    }

    public List<Q37Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return q37RepService.getList(Q37Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "MI3-生育相关报表.xlsx";
    }

    public WorkTableData getQDataTable(List<Q37Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return WorkBookTool.getXSSFWorkTable("MI3-生育相关报表", list, new Q37DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
