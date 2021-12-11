package com.yuansong.tools.controller;

import com.github.deansquirrel.tools.common.CommonTool;
import com.github.deansquirrel.tools.common.ExceptionTool;
import com.yuansong.dailyHelper.common.Response;
import com.yuansong.dailyHelper.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@Api(tags={"tools-common"})
@RequestMapping(value = "/common")
public class CommonController {

    private static final Logger logger = LoggerFactory.getLogger(CommonController.class);

    @ApiOperation(value="获取MD5")
    @RequestMapping(value="/common/md5Encode",method = RequestMethod.GET)
    public ResponseResult<String> md5Encode(
            @ApiParam(name = "str", value = "文本", required = true)
            @RequestParam String str) {
        try {
            return Response.makeOKStringResp(CommonTool.Md5Encode(str.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e) {
            logger.debug(ExceptionTool.getStackTrace(e));
            return Response.makeErrRsp("获取MD5时遇到错误：" +e.getMessage());
        }
    }

    @ApiOperation(value="获取MD5")
    @RequestMapping(value="/common/md5EncodeStr",method = RequestMethod.GET)
    public ResponseResult<String> md5EncodeStr(
            @ApiParam(name = "str", value = "文本", required = true)
            @RequestParam String str) {
        try {
            return Response.makeOKStringResp(CommonTool.Md5Encode(str));
        } catch (NoSuchAlgorithmException e) {
            logger.debug(ExceptionTool.getStackTrace(e));
            return Response.makeErrRsp("获取MD5时遇到错误：" +e.getMessage());
        }
    }

    @ApiOperation(value="获取GUID")
    @RequestMapping(value="/common/uuid",method = RequestMethod.GET)
    public ResponseResult<String> uuid() {
        return Response.makeOKStringResp(CommonTool.UUID());
    }

    @ApiOperation(value="列表拆分")
    @RequestMapping(value="/common/splitDataList",method = RequestMethod.GET)
    public ResponseResult<List<String>> splitDataList(
            @ApiParam(name = "str", value = "以竖线分割的文本", required = true)
            @RequestParam String str,
            @ApiParam(name = "length", value = "长度", required = true)
            @RequestParam int length) {
        List<String> result = new ArrayList<>();
        List<String> source = Arrays.asList(str.split("\\|"));
        List<List<String>> ls = CommonTool.splitDataList(source, length);
        for(List<String> item :ls) {
            result.add(String.join("|",item));
        }
        return Response.makeOKResp(result);
    }
}
