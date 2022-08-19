package com.yuansong.dailyHelper.features.http;

import com.yuansong.dailyHelper.features.http.util.OkHttpHelper;
import com.yuansong.dailyHelper.features.http.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Api(tags={"http"})
@RequestMapping(value = "/feature/http")
public class HttpController {

    private static final Logger logger = LoggerFactory.getLogger(HttpController.class);

    @ApiOperation(value="成功返回")
    @RequestMapping(value="/success",method = RequestMethod.GET)
    public ResponseResult<?> getResponseSuccess() {
        return ResponseResult.success();
    }

    @ApiOperation(value="失败返回")
    @RequestMapping(value="/fail",method = RequestMethod.GET)
    public ResponseResult<?> getResponseFail() {
        return ResponseResult.fail();
    }

    @ApiOperation(value="调用")
    @RequestMapping(value="/call",method = RequestMethod.GET)
    public ResponseResult<?> getResponseCall() {
        try {
            logger.debug(OkHttpHelper.doGet("http://123.57.70.114:81/api/version"));
            logger.debug(OkHttpHelper.doGet("https://www.baidu.com"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResponseResult.success();
    }
}
