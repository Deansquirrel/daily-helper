package com.yuansong.tools.controller;

import com.github.deansquirrel.tools.common.DateTool;
import com.yuansong.dailyHelper.common.Response;
import com.yuansong.dailyHelper.common.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
public class RootController {

    private static final Logger logger = LoggerFactory.getLogger(RootController.class);

    @ApiIgnore
    @RequestMapping(value="/root",method = RequestMethod.GET)
    public ResponseResult<String> root() {
        logger.debug("root");
        return Response.makeOKStringResp(DateTool.GetDateTimeStr());
    }

}
