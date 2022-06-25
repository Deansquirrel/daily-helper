package com.yuansong.dailyHelper.features.mqreport.q05.service;

import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.q05.repository.Q05Do;
import com.yuansong.dailyHelper.features.mqreport.q05.repository.Q05Query;
import com.yuansong.dailyHelper.util.io.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q05Service {

    private final com.yuansong.dailyHelper.features.mqreport.q05.service.Q05RepService Q05RepService;

    public Q05Service(com.yuansong.dailyHelper.features.mqreport.q05.service.Q05RepService Q05RepService) {
        this.Q05RepService = Q05RepService;
    }

    public List<Q05Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return Q05RepService.getList(Q05Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "HI4普通门诊-普通门诊医疗级别.xlsx";
    }

    public XSSFWorkTable getQDataTable(List<Q05Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return XSSFWorkBookTool.getXSSFWorkTable("HI4普通门诊-普通门诊医疗级别", list, new Q05DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
