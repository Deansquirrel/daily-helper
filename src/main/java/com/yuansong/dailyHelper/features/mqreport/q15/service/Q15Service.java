package com.yuansong.dailyHelper.features.mqreport.q15.service;

import com.github.deansquirrel.tools.poi.WorkBookTool;
import com.github.deansquirrel.tools.poi.WorkTableData;
import com.yuansong.dailyHelper.features.mqreport.q15.repository.Q15Do;
import com.yuansong.dailyHelper.features.mqreport.q15.repository.Q15Query;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q15Service {

    private final com.yuansong.dailyHelper.features.mqreport.q15.service.Q15RepService Q15RepService;

    public Q15Service(com.yuansong.dailyHelper.features.mqreport.q15.service.Q15RepService Q15RepService) {
        this.Q15RepService = Q15RepService;
    }

    public List<Q15Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return Q15RepService.getList(Q15Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "HI7其中建档立卡贫困人员-普通门急诊.xlsx";
    }

    public WorkTableData getQDataTable(List<Q15Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return WorkBookTool.getXSSFWorkTable("HI7其中建档立卡贫困人员-普通门急诊", list, new Q15DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
