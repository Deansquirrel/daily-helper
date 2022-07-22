package com.yuansong.dailyHelper.features.mqreport.q41.service;

import com.github.deansquirrel.tools.poi.WorkBookTool;
import com.github.deansquirrel.tools.poi.WorkTableData;
import com.yuansong.dailyHelper.features.mqreport.q41.repository.Q41Do;
import com.yuansong.dailyHelper.features.mqreport.q41.repository.Q41Query;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q41Service {

    private final Q41RepService q41RepService;

    public Q41Service(Q41RepService q41RepService) {
        this.q41RepService = q41RepService;
    }

    public List<Q41Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return q41RepService.getList(Q41Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "居民普通门诊、慢特病、和住院人数.xlsx";
    }

    public WorkTableData getQDataTable(List<Q41Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return WorkBookTool.getXSSFWorkTable("居民普通门诊、慢特病、和住院人数", list, new Q41DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
