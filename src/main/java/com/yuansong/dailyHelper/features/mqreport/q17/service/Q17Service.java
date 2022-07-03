package com.yuansong.dailyHelper.features.mqreport.q17.service;

import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.q17.repository.Q17Do;
import com.yuansong.dailyHelper.features.mqreport.q17.repository.Q17Query;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q17Service {

    private final com.yuansong.dailyHelper.features.mqreport.q17.service.Q17RepService Q17RepService;

    public Q17Service(com.yuansong.dailyHelper.features.mqreport.q17.service.Q17RepService Q17RepService) {
        this.Q17RepService = Q17RepService;
    }

    public List<Q17Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return Q17RepService.getList(Q17Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "HI7其中建档立卡贫困人员-住院按照支出构成.xlsx";
    }

    public XSSFWorkTable getQDataTable(List<Q17Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return XSSFWorkBookTool.getXSSFWorkTable("HI7其中建档立卡贫困人员-住院按照支出构成", list, new Q17DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
