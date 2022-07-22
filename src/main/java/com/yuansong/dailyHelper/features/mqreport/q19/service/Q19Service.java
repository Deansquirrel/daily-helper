package com.yuansong.dailyHelper.features.mqreport.q19.service;

import com.github.deansquirrel.tools.poi.WorkBookTool;
import com.github.deansquirrel.tools.poi.WorkTableData;
import com.yuansong.dailyHelper.features.mqreport.q19.repository.Q19Do;
import com.yuansong.dailyHelper.features.mqreport.q19.repository.Q19Query;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q19Service {

    private final com.yuansong.dailyHelper.features.mqreport.q19.service.Q19RepService Q19RepService;

    public Q19Service(com.yuansong.dailyHelper.features.mqreport.q19.service.Q19RepService Q19RepService) {
        this.Q19RepService = Q19RepService;
    }

    public List<Q19Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return Q19RepService.getList(Q19Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "HI7其中60岁以上老人，学生-门诊.xlsx";
    }

    public WorkTableData getQDataTable(List<Q19Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return WorkBookTool.getXSSFWorkTable("HI7其中60岁以上老人，学生-门诊", list, new Q19DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
