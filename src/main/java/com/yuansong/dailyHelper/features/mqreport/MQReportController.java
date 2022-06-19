package com.yuansong.dailyHelper.features.mqreport;

import com.yuansong.dailyHelper.features.mqreport.m01.service.M01Service;
import com.yuansong.dailyHelper.util.io.Response;
import com.yuansong.dailyHelper.util.io.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@Api(tags={"MQReport"})
@RequestMapping(value = "/feature/mqreport")
public class MQReportController {

    private final MQReportService mqReportService;

    public MQReportController(MQReportService mqReportService) {
        this.mqReportService = mqReportService;
    }

    @ApiOperation(value="全部月报")
    @RequestMapping(value="/all",method = RequestMethod.GET)
    public ResponseResult<?> getAllMData() {
        mqReportService.getAllMFile(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="职工参保")
    @RequestMapping(value="/m01",method = RequestMethod.GET)
    public ResponseResult<?> getM01Data() {
        mqReportService.getM01File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="居民参保")
    @RequestMapping(value="/m02",method = RequestMethod.GET)
    public ResponseResult<?> getM02Data() {
        mqReportService.getM02File(null);
        return Response.makeOKResp();
    }
}
