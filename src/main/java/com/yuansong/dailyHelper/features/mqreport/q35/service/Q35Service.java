package com.yuansong.dailyHelper.features.mqreport.q35.service;

import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.q35.repository.Q35Do;
import com.yuansong.dailyHelper.features.mqreport.q35.repository.Q35Query;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class Q35Service {

    private final Q35RepService Q35RepService;

    public Q35Service(Q35RepService Q35RepService) {
        this.Q35RepService = Q35RepService;
    }

    public List<Q35Do> getQData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return Q35RepService.getList(Q35Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "HI9-城乡居民大病保险情况.xlsx";
    }

    public XSSFWorkTable getQDataTable(List<Q35Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return XSSFWorkBookTool.getXSSFWorkTable("HI9-城乡居民大病保险情况", list, new Q35DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
