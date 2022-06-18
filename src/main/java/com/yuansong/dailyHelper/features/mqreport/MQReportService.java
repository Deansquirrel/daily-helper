package com.yuansong.dailyHelper.features.mqreport;

import com.github.deansquirrel.tools.common.CommonTool;
import com.github.deansquirrel.tools.common.ExceptionTool;
import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.m01.service.M01Service;
import com.yuansong.dailyHelper.global.DHConstant;
import com.yuansong.dailyHelper.util.io.FileUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MQReportService {

    private static final Logger logger = LoggerFactory.getLogger(MQReportService.class);

    private final M01Service m01Service;

    public MQReportService(M01Service m01Service) {
        this.m01Service = m01Service;
    }

    /**
     * 异步导出M01
     * @param queryMonth 查询月份（月份首日）
     */
    @Async(DHConstant.TASK_EXECUTOR)
    public void getM01File(Date queryMonth) {
        boolean flag = false;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + "开始导出M01月报数据");
                List<XSSFWorkTable> list = new ArrayList<>();
                logger.debug(taskId + "开始查询M01月报数据");
                list.add(m01Service.getM01DataTable(m01Service.getM01Data(null)));
                logger.debug(taskId + "查询M01月报数据完成");
                logger.debug(taskId + "开始生成M01月报数据文件");
                XSSFWorkbook f = XSSFWorkBookTool.getXSSFWorkBook(list);
                logger.debug(taskId + "生成M01月报数据文件完成");
                logger.debug(taskId + "开始保存M01月报数据文件");
                String fileName = m01Service.getExportFileName();
                logger.debug(fileName);
                FileUtil.saveXSSFWorkbook(fileName, f);
                logger.debug(taskId + "保存M01月报数据文件完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }

    }

}
