package com.yuansong.dailyHelper.features.mqreport.q04.service;

import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.q04.repository.Q04Do;
import com.yuansong.dailyHelper.features.mqreport.q04.repository.Q04Query;
import com.yuansong.dailyHelper.util.io.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q04Service {

    private final Q04RepService Q04RepService;

    public Q04Service(com.yuansong.dailyHelper.features.mqreport.q04.service.Q04RepService Q04RepService) {
        this.Q04RepService = Q04RepService;
    }

    public List<Q04Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return Q04RepService.getList(Q04Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "HI4普通门诊-普通门诊在职退休.xlsx";
    }

    public XSSFWorkTable getQDataTable(List<Q04Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return XSSFWorkBookTool.getXSSFWorkTable("HI4普通门诊-普通门诊在职退休", list, new Q04DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
