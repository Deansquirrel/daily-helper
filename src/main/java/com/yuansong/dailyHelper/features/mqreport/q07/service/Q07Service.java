package com.yuansong.dailyHelper.features.mqreport.q07.service;

import com.github.deansquirrel.tools.poi.WorkBookTool;
import com.github.deansquirrel.tools.poi.WorkTableData;
import com.yuansong.dailyHelper.features.mqreport.q07.repository.Q07Do;
import com.yuansong.dailyHelper.features.mqreport.q07.repository.Q07Query;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q07Service {

    private final com.yuansong.dailyHelper.features.mqreport.q07.service.Q07RepService Q07RepService;

    public Q07Service(com.yuansong.dailyHelper.features.mqreport.q07.service.Q07RepService Q07RepService) {
        this.Q07RepService = Q07RepService;
    }

    public List<Q07Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return Q07RepService.getList(Q07Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "HI4门诊大病-门诊大病医疗级别.xlsx";
    }

    public WorkTableData getQDataTable(List<Q07Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return WorkBookTool.getXSSFWorkTable("HI4门诊大病-门诊大病医疗级别", list, new Q07DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
