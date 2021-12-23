package com.yuansong.dailyHelper.common;

import com.github.deansquirrel.tools.common.ExceptionTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.MessageFormat;

@ControllerAdvice
public class ExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @org.springframework.web.bind.annotation.ExceptionHandler(value=Exception.class)
    @ResponseBody
    public ResponseResult<?> exceptionHandler(Exception e) {
        logger.error(ExceptionTool.getStackTrace(e));
        return Response.makeErrRsp(MessageFormat.format("{0}[{1}]",Response.FAIL, e.getMessage()));
    }

}
