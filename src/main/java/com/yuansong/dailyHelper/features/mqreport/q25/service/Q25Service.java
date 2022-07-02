package com.yuansong.dailyHelper.features.mqreport.q25.service;

import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.q25.repository.Q25Do;
import com.yuansong.dailyHelper.features.mqreport.q25.repository.Q25Query;
import com.yuansong.dailyHelper.util.io.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q25Service {

    private final com.yuansong.dailyHelper.features.mqreport.q25.service.Q25RepService Q25RepService;

    public Q25Service(com.yuansong.dailyHelper.features.mqreport.q25.service.Q25RepService Q25RepService) {
        this.Q25RepService = Q25RepService;
    }

    public List<Q25Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return Q25RepService.getList(Q25Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "HI7按照医疗级别-住院按照支出构成.xlsx";
    }

    public XSSFWorkTable getQDataTable(List<Q25Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return XSSFWorkBookTool.getXSSFWorkTable("HI7按照医疗级别-住院按照支出构成", list, new Q25DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
