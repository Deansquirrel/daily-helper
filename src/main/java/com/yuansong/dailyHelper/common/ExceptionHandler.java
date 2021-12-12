package com.yuansong.dailyHelper.common;

import com.github.deansquirrel.tools.common.ExceptionTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @org.springframework.web.bind.annotation.ExceptionHandler(value=Exception.class)
    @ResponseBody
    public ResponseResult<?> exceptionHandler(Exception e) {
        logger.error(ExceptionTool.getStackTrace(e));
        return Response.makeErrResp();
    }

}
