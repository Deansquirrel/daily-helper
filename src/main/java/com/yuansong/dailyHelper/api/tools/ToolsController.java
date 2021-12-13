package com.yuansong.dailyHelper.api.tools;

import com.github.deansquirrel.tools.common.ExceptionTool;
import com.github.deansquirrel.tools.secret.SimpleOne;
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

@RestController
@Api(tags={"tools"})
@RequestMapping(value = "/tools")
public class ToolsController {

    private static final Logger logger = LoggerFactory.getLogger(ToolsController.class);

    /**
     * 加密文本
     * @param plainText 明文
     * @param key 密码
     * @return 密文
     */
    @ApiOperation(value="加密文本")
    @RequestMapping(value="/secret/encrypt",method = RequestMethod.GET)
    public ResponseResult<String> encrypt(
            @ApiParam(name = "plainText", value = "明文", required = true)
            @RequestParam String plainText,
            @ApiParam(name = "key", value = "密码", required = true)
            @RequestParam String key) {
        try {
            return Response.makeOKStringResp(SimpleOne.EncryptToBase64Format(plainText, key));
        } catch (Exception e) {
            logger.debug(ExceptionTool.getStackTrace(e));
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
    @RequestMapping(value="/secret/decrypt",method = RequestMethod.GET)
    public ResponseResult<String> decrypt(
            @ApiParam(name = "cipherText", value = "密文", required = true)
            @RequestParam String cipherText,
            @ApiParam(name = "key", value = "密码", required = true)
            @RequestParam String key) {
        try {
            return Response.makeOKStringResp(SimpleOne.DecryptFromBase64Format(cipherText, key));
        } catch (Exception e) {
            logger.debug(ExceptionTool.getStackTrace(e));
            return Response.makeErrRsp("解密时遇到错误：" +e.getMessage());
        }
    }

}
