package com.yuansong.dailyHelper.features.tool.controller;

import com.yuansong.dailyHelper.global.DHConstant;
import com.yuansong.dailyHelper.service.secret.ISecretService;
import com.yuansong.dailyHelper.util.io.Response;
import com.yuansong.dailyHelper.util.io.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags={"Tools"})
@RequestMapping(value = "/feature/tool")
public class ToolController {

    private final ISecretService secretService;

    public ToolController(ISecretService secretService) {
        this.secretService = secretService;
    }

    /**
     * 加密文本
     * @param plainText 明文
     * @param key 密码
     * @return 密文
     */
    @ApiOperation(value="加密文本")
    @RequestMapping(value="/encrypt",method = RequestMethod.GET)
    public ResponseResult<String> encrypt(
            @ApiParam(name = "plainText", value = "明文", required = true)
            @RequestParam String plainText,
            @ApiParam(name = "key", value = "密码")
            @RequestParam String key) {
        try {
            if(key == null || "".equals(key)) {
                key = DHConstant.SECRET_KEY;
            }
            return Response.makeOKStringResp(secretService.encrypt(plainText, key));
        } catch (Exception e) {
            return Response.makeErrRsp("加密时遇到错误：" +e.getMessage());
        }
    }

    /**
     * 解密文本
     * @param cipherText 密文
     * @param key 密码
     * @return 明文
     */
    @ApiOperation(value="解密文本")
    @RequestMapping(value="/decrypt",method = RequestMethod.GET)
    public ResponseResult<String> decrypt(
            @ApiParam(name = "cipherText", value = "密文", required = true)
            @RequestParam String cipherText,
            @ApiParam(name = "key", value = "密码")
            @RequestParam String key) {
        try {
            if(key == null || "".equals(key)) {
                key = DHConstant.SECRET_KEY;
            }
            return Response.makeOKStringResp(secretService.decrypt(cipherText, key));
        } catch (Exception e) {
            return Response.makeErrRsp("解密时遇到错误：" +e.getMessage());
        }
    }

}
