package com.yuansong.dailyHelper.features.evss;

import com.github.deansquirrel.tools.common.DateTool;
import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.yuansong.dailyHelper.common.Response;
import com.yuansong.dailyHelper.common.ResponseResult;
import com.yuansong.dailyHelper.global.Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;

@RestController
@Api(tags={"Evss"})
@RequestMapping(value = "/feature/evss")
public class EvssController {

    private static final Logger logger = LoggerFactory.getLogger(EvssController.class);

    private final EvssService evssService;

    public EvssController(EvssService evssService) {
        this.evssService = evssService;
    }

    @ApiOperation(value="电子凭证取数合并")
    @RequestMapping(value="/",method = RequestMethod.GET)
    public void getEvss(HttpServletResponse response) {
        logger.debug("============================================");
        XSSFWorkbook f = evssService.getWorkBook(evssService.getData());
        logger.debug("============================================");
        String fileName = DateTool.GetDateTimeWithMillionSecond();
        fileName = fileName.replace(" ","");
        fileName = fileName.replace("-","");
        fileName = fileName.replace(":","");
        fileName = fileName.replace(".","");
        fileName = fileName + ".xlsx";
        try {
            Util.setResponseDownloadExcel(response,fileName, f);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        return Response.makeOKResp();
    }

}
