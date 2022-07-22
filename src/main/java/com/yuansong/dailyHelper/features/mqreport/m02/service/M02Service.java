package com.yuansong.dailyHelper.features.mqreport.m02.service;

import com.github.deansquirrel.tools.poi.WorkBookTool;
import com.github.deansquirrel.tools.poi.WorkTableData;
import com.yuansong.dailyHelper.features.mqreport.m02.repository.M02Do;
import com.yuansong.dailyHelper.features.mqreport.m02.repository.M02Query;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class M02Service {

    private final M02RepService m02RepService;

    public M02Service(M02RepService m02RepService) {
        this.m02RepService = m02RepService;
    }

    public List<M02Do> getMData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return m02RepService.getList(M02Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "居民参保.xlsx";
    }

    public WorkTableData getMDataTable(List<M02Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return WorkBookTool.getXSSFWorkTable("居民参保", list, new M02DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
