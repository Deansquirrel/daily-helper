package com.yuansong.dailyHelper.features.mqreport.q39.service;

import com.github.deansquirrel.tools.poi.WorkBookTool;
import com.github.deansquirrel.tools.poi.WorkTableData;
import com.yuansong.dailyHelper.features.mqreport.q39.repository.Q39Do;
import com.yuansong.dailyHelper.features.mqreport.q39.repository.Q39Query;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q39Service {

    private final Q39RepService q39RepService;

    public Q39Service(Q39RepService q39RepService) {
        this.q39RepService = q39RepService;
    }

    public List<Q39Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return q39RepService.getList(Q39Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "SI2公务员补助.xlsx";
    }

    public WorkTableData getQDataTable(List<Q39Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return WorkBookTool.getXSSFWorkTable("SI2公务员补助", list, new Q39DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
