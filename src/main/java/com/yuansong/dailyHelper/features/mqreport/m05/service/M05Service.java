package com.yuansong.dailyHelper.features.mqreport.m05.service;

import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.m04.repository.M04Do;
import com.yuansong.dailyHelper.features.mqreport.m04.repository.M04Query;
import com.yuansong.dailyHelper.features.mqreport.m04.service.M04DataMapper;
import com.yuansong.dailyHelper.features.mqreport.m04.service.M04RepService;
import com.yuansong.dailyHelper.features.mqreport.m05.repository.M05Do;
import com.yuansong.dailyHelper.features.mqreport.m05.repository.M05Query;
import com.yuansong.dailyHelper.util.io.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class M05Service {

    private final M05RepService m05RepService;

    public M05Service(M05RepService m05RepService) {
        this.m05RepService = m05RepService;
    }

    public List<M05Do> getMData(Date queryMonth) {
        if(queryMonth == null) {
            queryMonth = this.getDefaultQueryMonth();
        }
        return m05RepService.getList(M05Query.builder().setMonth(queryMonth));
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "生育.xlsx";
    }

    public XSSFWorkTable getMDataTable(List<M05Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return XSSFWorkBookTool.getXSSFWorkTable("生育", list, new M05DataMapper());
    }

    private Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}
