package com.yuansong.dailyHelper.features.mqreport.m07.service;

import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.m07.repository.M07Do;
import com.yuansong.dailyHelper.features.mqreport.m07.repository.M07Query;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class M07Service {

    private final M07RepService m07RepService;

    public M07Service(M07RepService m07RepService) {
        this.m07RepService = m07RepService;
    }

    public List<M07Do> getMData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return m07RepService.getList(M07Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "职工实施统账退休.xlsx";
    }

    public XSSFWorkTable getMDataTable(List<M07Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return XSSFWorkBookTool.getXSSFWorkTable("职工实施统账退休", list, new M07DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
