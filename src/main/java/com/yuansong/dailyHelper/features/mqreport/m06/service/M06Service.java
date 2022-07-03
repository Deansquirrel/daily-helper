package com.yuansong.dailyHelper.features.mqreport.m06.service;

import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.m06.repository.M06Do;
import com.yuansong.dailyHelper.features.mqreport.m06.repository.M06Query;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class M06Service {

    private final M06RepService m06RepService;

    public M06Service(M06RepService m06RepService) {
        this.m06RepService = m06RepService;
    }

    public List<M06Do> getMData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return m06RepService.getList(M06Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "职工实施统账在职.xlsx";
    }

    public XSSFWorkTable getMDataTable(List<M06Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return XSSFWorkBookTool.getXSSFWorkTable("职工实施统账在职", list, new M06DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
