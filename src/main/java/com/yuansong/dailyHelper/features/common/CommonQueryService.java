package com.yuansong.dailyHelper.features.common;

import com.github.deansquirrel.tools.common.CommonTool;
import com.github.deansquirrel.tools.common.ExceptionTool;
import com.github.deansquirrel.tools.poi.WorkBookTool;
import com.github.deansquirrel.tools.poi.WorkTableData;
import com.yuansong.dailyHelper.features.common.c0001.repository.C0001Do;
import com.yuansong.dailyHelper.features.common.c0001.service.C0001Service;
import com.yuansong.dailyHelper.global.DHConstant;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommonQueryService {

    private static final Logger logger = LoggerFactory.getLogger(CommonQueryService.class);

    private final C0001Service c0001Service;


    public CommonQueryService(C0001Service c0001Service) {
        this.c0001Service = c0001Service;
    }

    private void saveFile(String fileName, WorkTableData table, String logKey) {
        List<WorkTableData> list = new ArrayList<>();
        list.add(table);
        this.saveFile(fileName, list, logKey);
    }

    //保存文件
    private void saveFile(String fileName, List<WorkTableData> list, String logKey) {
        String taskId = CommonTool.UUID().replace("-", "");
        boolean flag = false;
        while (!flag) {
            try {
                logger.debug(MessageFormat.format("{0} 开始生成{1}数据文件", taskId, logKey));
                XSSFWorkbook f = WorkBookTool.getXSSFWorkBook(list);
                logger.debug(MessageFormat.format("{0} 生成{1}数据文件完成", taskId, logKey));
                logger.debug(MessageFormat.format("{0} 开始{1}保存数据文件", taskId, logKey));
                FileUtil.saveXSSFWorkbook(fileName, f);
                logger.debug(MessageFormat.format("{0} 保存{1}数据文件完成", taskId, logKey));
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

    @Async(DHConstant.TASK_EXECUTOR)
    public void getC0001File() {
        boolean flag = false;
        List<C0001Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出C0001数据");
                logger.debug(taskId + " 开始查询C0001数据");
                qData =  c0001Service.getMData();
                logger.debug(taskId + " 查询C0001数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(c0001Service.getExportFileName(), c0001Service.getMDataTable(qData), "C0001");
    }

}
