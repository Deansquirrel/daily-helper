package com.yuansong.dailyHelper.features.common;

import com.yuansong.dailyHelper.util.io.Response;
import com.yuansong.dailyHelper.util.io.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags={"CommonQuery"})
@RequestMapping(value = "/feature/cquery")
public class CommonQueryController {

    private final CommonQueryService commonQueryService;

    public CommonQueryController(CommonQueryService commonQueryService) {
        this.commonQueryService = commonQueryService;
    }

    @ApiOperation(value="月结预留金和实拨金额查询")
    @RequestMapping(value="/c0001",method = RequestMethod.GET)
    public ResponseResult<?> getC0001File() {
        commonQueryService.getC0001File();
        return Response.makeOKResp();
    }





}
