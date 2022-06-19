package com.yuansong.dailyHelper.features.mqreport.m03.service;

import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.m02.repository.M02Do;
import com.yuansong.dailyHelper.features.mqreport.m02.repository.M02Query;
import com.yuansong.dailyHelper.features.mqreport.m02.service.M02DataMapper;
import com.yuansong.dailyHelper.features.mqreport.m02.service.M02RepService;
import com.yuansong.dailyHelper.features.mqreport.m03.repository.M03Do;
import com.yuansong.dailyHelper.features.mqreport.m03.repository.M03Query;
import com.yuansong.dailyHelper.util.io.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class M03Service {

    private final M03RepService m03RepService;

    public M03Service(M03RepService m03RepService) {
        this.m03RepService = m03RepService;
    }

    public List<M03Do> getMData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return m03RepService.getList(M03Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "职工待遇.xlsx";
    }

    public XSSFWorkTable getMDataTable(List<M03Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return XSSFWorkBookTool.getXSSFWorkTable("职工待遇", list, new M03DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}