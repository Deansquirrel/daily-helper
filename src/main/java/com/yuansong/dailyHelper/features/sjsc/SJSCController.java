package com.yuansong.dailyHelper.features.sjsc;

import com.yuansong.dailyHelper.features.sjsc.service.SJSCService;
import com.yuansong.dailyHelper.util.io.Response;
import com.yuansong.dailyHelper.util.io.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags={"SJSC"})
@RequestMapping(value = "/feature/sjsc")
public class SJSCController {

    private final SJSCService sjscService;

    public SJSCController(SJSCService sjscService) {
        this.sjscService = sjscService;
    }

    @ApiOperation(value="三级四从")
    @RequestMapping(value="/sjsc",method = RequestMethod.GET)
    public ResponseResult<?> getSJSCData(String begDate, String endDate) {
        sjscService.getFile(begDate,endDate);
        return Response.makeOKResp();
    }

}
