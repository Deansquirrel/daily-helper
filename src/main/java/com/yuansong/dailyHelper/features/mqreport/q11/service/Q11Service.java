package com.yuansong.dailyHelper.features.mqreport.q11.service;

import com.github.deansquirrel.tools.poi.WorkBookTool;
import com.github.deansquirrel.tools.poi.WorkTableData;
import com.yuansong.dailyHelper.features.mqreport.q11.repository.Q11Do;
import com.yuansong.dailyHelper.features.mqreport.q11.repository.Q11Query;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q11Service {

    private final com.yuansong.dailyHelper.features.mqreport.q11.service.Q11RepService Q11RepService;

    public Q11Service(com.yuansong.dailyHelper.features.mqreport.q11.service.Q11RepService Q11RepService) {
        this.Q11RepService = Q11RepService;
    }

    public List<Q11Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return Q11RepService.getList(Q11Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "HI4.1住院按照支出构成-医疗级别.xlsx";
    }

    public WorkTableData getQDataTable(List<Q11Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return WorkBookTool.getXSSFWorkTable("HI4.1住院按照支出构成-医疗级别", list, new Q11DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
