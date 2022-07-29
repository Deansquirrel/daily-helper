package com.yuansong.dailyHelper.features.common.c0001.service;

import com.github.deansquirrel.tools.poi.WorkBookTool;
import com.github.deansquirrel.tools.poi.WorkTableData;
import com.yuansong.dailyHelper.features.common.c0001.repository.C0001Do;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class C0001Service {

    private final C0001RepService c0001RepService;

    public C0001Service(C0001RepService c0001RepService) {
        this.c0001RepService = c0001RepService;
    }

    public List<C0001Do> getMData() {

        return c0001RepService.getList();
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "金额.xlsx";
    }

    public WorkTableData getMDataTable(List<C0001Do> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return WorkBookTool.getXSSFWorkTable("金额", list, new C0001DataMapper());
    }


}
