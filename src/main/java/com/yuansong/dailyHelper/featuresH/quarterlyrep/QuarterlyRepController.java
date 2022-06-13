package com.yuansong.dailyHelper.featuresH.quarterlyrep;

import com.yuansong.dailyHelper.util.io.Response;
import com.yuansong.dailyHelper.util.io.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags={"QuarterlyRep"})
@RequestMapping(value = "/feature")
public class QuarterlyRepController {

    private static final Logger logger = LoggerFactory.getLogger(QuarterlyRepController.class);

    @ApiOperation(value="测试")
    @RequestMapping(value="/quarterlyrep",method = RequestMethod.GET)
    public ResponseResult<?> subTest() {
        logger.debug("QuarterlyRep test");
        return Response.makeOKResp();
    }

}
