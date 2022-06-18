package com.yuansong.dailyHelper.features.mqreport.m01.controller;

import com.yuansong.dailyHelper.features.mqreport.MQReportService;
import com.yuansong.dailyHelper.features.mqreport.m01.service.M01Service;
import com.yuansong.dailyHelper.util.io.Response;
import com.yuansong.dailyHelper.util.io.ResponseResult;
import com.yuansong.dailyHelper.util.io.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@Api(tags={"MQReport"})
@RequestMapping(value = "/feature/mqreport")
public class M01Controller {

    private final M01Service m01Service;
    private final MQReportService mqReportService;

    public M01Controller(M01Service m01Service, MQReportService mqReportService) {
        this.m01Service = m01Service;
        this.mqReportService = mqReportService;
    }

    @ApiOperation(value="M01")
    @RequestMapping(value="/m01",method = RequestMethod.GET)
    public ResponseResult<?> getM01Data(HttpServletResponse response) {
        mqReportService.getM01File(null);
        return Response.makeOKResp();
//        List<XSSFWorkTable> list = new ArrayList<>();
//        list.add(m01Service.getM01DataTable(m01Service.getM01Data(null)));
//        XSSFWorkbook f = XSSFWorkBookTool.getXSSFWorkBook(list);
//        String fileName = m01Service.getExportFileName();
//        try {
//            FileUtil.saveXSSFWorkbook(fileName, f);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            ResponseUtil.setResponseDownloadExcel(response,fileName, f);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
