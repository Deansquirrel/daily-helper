package com.yuansong.dailyHelper.config;

import com.github.deansquirrel.tools.common.ExceptionTool;
import com.yuansong.dailyHelper.util.io.Response;
import com.yuansong.dailyHelper.util.io.ResponseResult;
import com.yuansong.dailyHelper.util.io.ResultCode;
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

//        StackTraceElement stackTraceElement = e.getStackTrace()[0];
//        String errorMsg = "文件名："+stackTraceElement.getFileName()+
//                "\r\n类名："+stackTraceElement.getClassName()+
//                "\r\n方法名："+stackTraceElement.getMethodName()+
//                "\r\n抛出异常行号："+stackTraceElement.getLineNumber()+
//                "\r\n机构ID异常，无法获取本机构信息："+e;
//        System.out.println(errorMsg);
//        logger.error(errorMsg);

        //TODO 获取抛出异常的类名及行号
//        StackTraceElement stackTraceElement = e.getStackTrace()[0];
//        logger.debug(stackTraceElement.getFileName());
//        logger.debug(stackTraceElement.getClassName());
//        logger.debug(stackTraceElement.getMethodName());
//        logger.debug(String.valueOf(stackTraceElement.getLineNumber()));
//        StackTraceElement[] sList = e.getStackTrace();
//        for(int i = 0; i < sList.length; i++) {
//            StackTraceElement s1 = e.getStackTrace()[i];
//            logger.debug("--------------------------------------------");
//            logger.debug(s1.getClassName());
//            logger.debug(s1.getMethodName());
//            logger.debug(String.valueOf(s1.getLineNumber()));
//            logger.debug(String.valueOf(s1.isNativeMethod()));
//        }
        return Response.makeErrRsp(MessageFormat.format("{0}[{1}]", ResultCode.FAIL.msg, e.getMessage()));
    }

}
