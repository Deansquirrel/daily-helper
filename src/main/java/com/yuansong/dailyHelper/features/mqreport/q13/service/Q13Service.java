package com.yuansong.dailyHelper.features.mqreport.q13.service;

import com.github.deansquirrel.tools.poi.WorkBookTool;
import com.github.deansquirrel.tools.poi.WorkTableData;
import com.yuansong.dailyHelper.features.mqreport.q13.repository.Q13Do;
import com.yuansong.dailyHelper.features.mqreport.q13.repository.Q13Query;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q13Service {

    private final com.yuansong.dailyHelper.features.mqreport.q13.service.Q13RepService Q13RepService;

    public Q13Service(com.yuansong.dailyHelper.features.mqreport.q13.service.Q13RepService Q13RepService) {
        this.Q13RepService = Q13RepService;
    }

    public List<Q13Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return Q13RepService.getList(Q13Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "HI4.1住院按照支出类别-医疗级别.xlsx";
    }

    public WorkTableData getQDataTable(List<Q13Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return WorkBookTool.getXSSFWorkTable("HI4.1住院按照支出类别-医疗级别", list, new Q13DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
