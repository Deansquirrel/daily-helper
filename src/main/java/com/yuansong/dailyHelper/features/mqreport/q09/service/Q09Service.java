package com.yuansong.dailyHelper.features.mqreport.q09.service;

import com.github.deansquirrel.tools.poi.WorkBookTool;
import com.github.deansquirrel.tools.poi.WorkTableData;
import com.yuansong.dailyHelper.features.mqreport.q09.repository.Q09Do;
import com.yuansong.dailyHelper.features.mqreport.q09.repository.Q09Query;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q09Service {

    private final com.yuansong.dailyHelper.features.mqreport.q09.service.Q09RepService Q09RepService;

    public Q09Service(com.yuansong.dailyHelper.features.mqreport.q09.service.Q09RepService Q09RepService) {
        this.Q09RepService = Q09RepService;
    }

    public List<Q09Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return Q09RepService.getList(Q09Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "HI4.1住院按照支出构成-在职退休.xlsx";
    }

    public WorkTableData getQDataTable(List<Q09Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return WorkBookTool.getXSSFWorkTable("HI4.1住院按照支出构成-在职退休", list, new Q09DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
