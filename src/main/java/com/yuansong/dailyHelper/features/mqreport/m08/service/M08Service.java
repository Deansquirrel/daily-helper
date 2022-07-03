package com.yuansong.dailyHelper.features.mqreport.m08.service;

import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.m08.repository.M08Do;
import com.yuansong.dailyHelper.features.mqreport.m08.repository.M08Query;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class M08Service {

    private final M08RepService m08RepService;

    public M08Service(M08RepService m08RepService) {
        this.m08RepService = m08RepService;
    }

    public List<M08Do> getMData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return m08RepService.getList(M08Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "农民工（进城务工人员参加职工基本医疗保险的人数）.xlsx";
    }

    public XSSFWorkTable getMDataTable(List<M08Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return XSSFWorkBookTool.getXSSFWorkTable("农民工（进城务工人员参加职工基本医疗保险的人数）",
                list, new M08DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
