package com.yuansong.dailyHelper.features.mqreport;

import com.yuansong.dailyHelper.util.io.Response;
import com.yuansong.dailyHelper.util.io.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags={"MQReport"})
@RequestMapping(value = "/feature/mqreport")
public class MQReportController {

    private final MQReportService mqReportService;

    public MQReportController(MQReportService mqReportService) {
        this.mqReportService = mqReportService;
    }

    @ApiOperation(value="全部月报")
    @RequestMapping(value="/allm",method = RequestMethod.GET)
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

    @ApiOperation(value="职工待遇")
    @RequestMapping(value="/m03",method = RequestMethod.GET)
    public ResponseResult<?> getM03Data() {
        mqReportService.getM03File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="居民待遇")
    @RequestMapping(value="/m04",method = RequestMethod.GET)
    public ResponseResult<?> getM04Data() {
        mqReportService.getM04File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="生育")
    @RequestMapping(value="/m05",method = RequestMethod.GET)
    public ResponseResult<?> getM05Data() {
        mqReportService.getM05File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="职工实施统账在职")
    @RequestMapping(value="/m06",method = RequestMethod.GET)
    public ResponseResult<?> getM06Data() {
        mqReportService.getM06File(null);
        return Response.makeOKResp();
    }
}
