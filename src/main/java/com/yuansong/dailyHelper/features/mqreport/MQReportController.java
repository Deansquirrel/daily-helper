package com.yuansong.dailyHelper.features.mqreport;

import com.yuansong.dailyHelper.util.io.Response;
import com.yuansong.dailyHelper.util.io.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

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
//        Calendar cal = Calendar.getInstance();
//        cal.set(cal.get(Calendar.YEAR), Calendar.JUNE, 1,0,0,0);
//        mqReportService.getAllMFile(cal.getTime());
        mqReportService.getAllMFile(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="全部季报")
    @RequestMapping(value="/allq",method = RequestMethod.GET)
    public ResponseResult<?> getAllQData() {
//        Calendar cal = Calendar.getInstance();
//        cal.set(cal.get(Calendar.YEAR), Calendar.JUNE, 1,0,0,0);
//        mqReportService.getAllQFile(cal.getTime());
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

    @ApiOperation(value="HI4.1住院人数")
    @RequestMapping(value="/q14",method = RequestMethod.GET)
    public ResponseResult<?> getQ14Data() {
        mqReportService.getQ14File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="HI7其中建档立卡贫困人员-普通门急诊")
    @RequestMapping(value="/q15",method = RequestMethod.GET)
    public ResponseResult<?> getQ15Data() {
        mqReportService.getQ15File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="HI7其中建档立卡贫困人员-门诊大病")
    @RequestMapping(value="/q16",method = RequestMethod.GET)
    public ResponseResult<?> getQ16Data() {
        mqReportService.getQ16File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="HI7其中建档立卡贫困人员-住院按照支出构成")
    @RequestMapping(value="/q17",method = RequestMethod.GET)
    public ResponseResult<?> getQ17Data() {
        mqReportService.getQ17File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="HI7其中建档立卡贫困人员-住院按照支出类别")
    @RequestMapping(value="/q18",method = RequestMethod.GET)
    public ResponseResult<?> getQ18Data() {
        mqReportService.getQ18File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="HI7其中60岁以上老人，学生-门诊")
    @RequestMapping(value="/q19",method = RequestMethod.GET)
    public ResponseResult<?> getQ19Data() {
        mqReportService.getQ19File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="HI7其中60岁以上老人，学生-慢病")
    @RequestMapping(value="/q20",method = RequestMethod.GET)
    public ResponseResult<?> getQ20Data() {
        mqReportService.getQ20File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="HI7其中60岁以上老人，学生-住院按照支出构成")
    @RequestMapping(value="/q21",method = RequestMethod.GET)
    public ResponseResult<?> getQ21Data() {
        mqReportService.getQ21File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="HI7其中60岁以上老人，学生-住院按照支出类别")
    @RequestMapping(value="/q22",method = RequestMethod.GET)
    public ResponseResult<?> getQ22Data() {
        mqReportService.getQ22File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="HI7按照医疗级别-门诊")
    @RequestMapping(value="/q23",method = RequestMethod.GET)
    public ResponseResult<?> getQ23Data() {
        mqReportService.getQ23File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="HI7按照医疗级别-慢特病")
    @RequestMapping(value="/q24",method = RequestMethod.GET)
    public ResponseResult<?> getQ24Data() {
        mqReportService.getQ24File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="HI7按照医疗级别-住院按照支出构成")
    @RequestMapping(value="/q25",method = RequestMethod.GET)
    public ResponseResult<?> getQ25Data() {
        mqReportService.getQ25File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="HI7按照支出类别-住院按照支出类别")
    @RequestMapping(value="/q26",method = RequestMethod.GET)
    public ResponseResult<?> getQ26Data() {
        mqReportService.getQ26File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="HI7.1、HI7.2慢病、两病用药")
    @RequestMapping(value="/q27",method = RequestMethod.GET)
    public ResponseResult<?> getQ27Data() {
        mqReportService.getQ27File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="HI8-普通门诊")
    @RequestMapping(value="/q28",method = RequestMethod.GET)
    public ResponseResult<?> getQ28Data() {
        mqReportService.getQ28File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="HI8-慢特病")
    @RequestMapping(value="/q29",method = RequestMethod.GET)
    public ResponseResult<?> getQ29Data() {
        mqReportService.getQ29File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="HI8-住院")
    @RequestMapping(value="/q30",method = RequestMethod.GET)
    public ResponseResult<?> getQ30Data() {
        mqReportService.getQ30File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="HI8.1-普通门诊")
    @RequestMapping(value="/q31",method = RequestMethod.GET)
    public ResponseResult<?> getQ31Data() {
        mqReportService.getQ31File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="HI8.1-门诊慢特病")
    @RequestMapping(value="/q32",method = RequestMethod.GET)
    public ResponseResult<?> getQ32Data() {
        mqReportService.getQ32File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="HI8.1-住院")
    @RequestMapping(value="/q33",method = RequestMethod.GET)
    public ResponseResult<?> getQ33Data() {
        mqReportService.getQ33File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="HI8.1-异地结算总人数")
    @RequestMapping(value="/q34",method = RequestMethod.GET)
    public ResponseResult<?> getQ34Data() {
        mqReportService.getQ34File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="HI9-城乡居民大病保险情况")
    @RequestMapping(value="/q35",method = RequestMethod.GET)
    public ResponseResult<?> getQ35Data() {
        mqReportService.getQ35File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="HI10-转移相关查询")
    @RequestMapping(value="/q36",method = RequestMethod.GET)
    public ResponseResult<?> getQ36Data() {
        mqReportService.getQ36File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="MI3-生育相关报表")
    @RequestMapping(value="/q37",method = RequestMethod.GET)
    public ResponseResult<?> getQ37Data() {
        mqReportService.getQ37File(null);
        return Response.makeOKResp();
    }

    @ApiOperation(value="SI2大额报销人数")
    @RequestMapping(value="/q38",method = RequestMethod.GET)
    public ResponseResult<?> getQ38Data() {
        mqReportService.getQ38File(null);
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
