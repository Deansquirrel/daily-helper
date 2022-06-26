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

    @ApiOperation(value="全部季报")
    @RequestMapping(value="/allq",method = RequestMethod.GET)
    public ResponseResult<?> getAllQData() {
        mqReportService.getAllQFile(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="HI2参保人数")
    @RequestMapping(value="/q01",method = RequestMethod.GET)
    public ResponseResult<?> getQ01Data() {
        mqReportService.getQ01File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="HI3保险费征缴情况")
    @RequestMapping(value="/q02",method = RequestMethod.GET)
    public ResponseResult<?> getQ02Data() {
        mqReportService.getQ02File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="HI3一次性缴费")
    @RequestMapping(value="/q03",method = RequestMethod.GET)
    public ResponseResult<?> getQ03Data() {
        mqReportService.getQ03File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="HI4普通门诊-普通门诊在职退休")
    @RequestMapping(value="/q04",method = RequestMethod.GET)
    public ResponseResult<?> getQ04Data() {
        mqReportService.getQ04File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="HI4普通门诊-普通门诊医疗级别")
    @RequestMapping(value="/q05",method = RequestMethod.GET)
    public ResponseResult<?> getQ05Data() {
        mqReportService.getQ05File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="HI4门诊大病-门诊大病在职退休")
    @RequestMapping(value="/q06",method = RequestMethod.GET)
    public ResponseResult<?> getQ06Data() {
        mqReportService.getQ06File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="HI4门诊大病-门诊大病医疗级别")
    @RequestMapping(value="/q07",method = RequestMethod.GET)
    public ResponseResult<?> getQ07Data() {
        mqReportService.getQ07File(null);
        return Response.makeOKResp();
    }
    @ApiOperation(value="HI4药店-药店在职退休")
    @RequestMapping(value="/q08",method = RequestMethod.GET)
    public ResponseResult<?> getQ08Data() {
        mqReportService.getQ08File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="HI4享受待遇人数")
    @RequestMapping(value="/q10",method = RequestMethod.GET)
    public ResponseResult<?> getQ10Data() {
        mqReportService.getQ10File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="HI4.1住院按照支出构成-在职退休")
    @RequestMapping(value="/q09",method = RequestMethod.GET)
    public ResponseResult<?> getQ09Data() {
        mqReportService.getQ09File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="HI4.1住院按照支出构成-医疗级别")
    @RequestMapping(value="/q11",method = RequestMethod.GET)
    public ResponseResult<?> getQ11Data() {
        mqReportService.getQ11File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="HI4.1住院按照支出类别-在职退休")
    @RequestMapping(value="/q12",method = RequestMethod.GET)
    public ResponseResult<?> getQ12Data() {
        mqReportService.getQ12File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="HI4.1住院按照支出类别-医疗级别")
    @RequestMapping(value="/q13",method = RequestMethod.GET)
    public ResponseResult<?> getQ13Data() {
        mqReportService.getQ13File(null);
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

    @ApiOperation(value="职工实施统账退休")
    @RequestMapping(value="/m07",method = RequestMethod.GET)
    public ResponseResult<?> getM07Data() {
        mqReportService.getM07File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="农民工（进城务工人员参加职工基本医疗保险的人数）")
    @RequestMapping(value="/m08",method = RequestMethod.GET)
    public ResponseResult<?> getM08Data() {
        mqReportService.getM08File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="一次性缴费")
    @RequestMapping(value="/m09",method = RequestMethod.GET)
    public ResponseResult<?> getM09Data() {
        mqReportService.getM09File(null);
        return Response.makeOKResp();
    }
}
