package com.yuansong.dailyHelper.features.mqreport.m01.service;

import com.github.deansquirrel.tools.common.DateTool;
import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.m01.repository.M01Do;
import com.yuansong.dailyHelper.features.mqreport.m01.repository.M01Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class M01Service {

    private final M01RepService m01RepService;

    public M01Service(M01RepService m01RepService) {
        this.m01RepService = m01RepService;
    }

    public List<M01Do> getM01Data(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return m01RepService.getList(M01Query.builder().setMonth(queryMonth));
    }

    public XSSFWorkTable getM01DataTable(List<M01Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return XSSFWorkBookTool.getXSSFWorkTable("M01", list, new M01DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
