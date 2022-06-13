package com.yuansong.dailyHelper.featuresH.evss;

import com.github.deansquirrel.tools.common.DateTool;
import com.yuansong.dailyHelper.util.io.ResponseUtil;
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

@RestController
@Api(tags={"Evss"})
@RequestMapping(value = "/feature")
public class EvssController {

    private static final Logger logger = LoggerFactory.getLogger(EvssController.class);

    private final EvssService evssService;

    public EvssController(EvssService evssService) {
        this.evssService = evssService;
    }

    @ApiOperation(value="电子凭证取数合并")
    @RequestMapping(value="/evss",method = RequestMethod.GET)
    public void getEvss(HttpServletResponse response) {
        XSSFWorkbook f = evssService.getWorkBook(evssService.getData());
        String fileName = "电子凭证结算统计" + DateTool.GetStr("yyyyMMddHHmmss") + ".xlsx";
        try {
            ResponseUtil.setResponseDownloadExcel(response,fileName, f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
