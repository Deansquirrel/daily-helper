package com.yuansong.dailyHelper.features.mqreport.m01.controller;

import com.github.deansquirrel.tools.common.CommonTool;
import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.m01.service.M01Service;
import com.yuansong.dailyHelper.util.io.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags={"MQReport"})
@RequestMapping(value = "/feature/mqreport")
public class M01Controller {

    private final M01Service m01Service;

    public M01Controller(M01Service m01Service) {
        this.m01Service = m01Service;
    }

    @ApiOperation(value="M01")
    @RequestMapping(value="/m01",method = RequestMethod.GET)
    public void getM01Data(HttpServletResponse response) {
        List<XSSFWorkTable> list = new ArrayList<>();
        list.add(m01Service.getM01DataTable(m01Service.getM01Data(null)));
        XSSFWorkbook f = XSSFWorkBookTool.getXSSFWorkBook(list);
        String fileName = "M01文件测试" + CommonTool.UUID() + ".xlsx";
        try {
            ResponseUtil.setResponseDownloadExcel(response,fileName, f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
