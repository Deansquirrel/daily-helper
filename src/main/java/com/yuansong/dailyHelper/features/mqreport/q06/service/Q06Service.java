package com.yuansong.dailyHelper.features.mqreport.q06.service;

import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.q06.repository.Q06Do;
import com.yuansong.dailyHelper.features.mqreport.q06.repository.Q06Query;
import com.yuansong.dailyHelper.util.io.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q06Service {

    private final com.yuansong.dailyHelper.features.mqreport.q06.service.Q06RepService Q06RepService;

    public Q06Service(com.yuansong.dailyHelper.features.mqreport.q06.service.Q06RepService Q06RepService) {
        this.Q06RepService = Q06RepService;
    }

    public List<Q06Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return Q06RepService.getList(Q06Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "HI4门诊大病-门诊大病在职退休.xlsx";
    }

    public XSSFWorkTable getQDataTable(List<Q06Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return XSSFWorkBookTool.getXSSFWorkTable("HI4门诊大病-门诊大病在职退休", list, new Q06DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
