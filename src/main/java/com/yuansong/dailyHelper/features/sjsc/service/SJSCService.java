package com.yuansong.dailyHelper.features.sjsc.service;

import com.github.deansquirrel.tools.common.CommonTool;
import com.github.deansquirrel.tools.common.ExceptionTool;
import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.sjsc.repository.SJSCDo;
import com.yuansong.dailyHelper.features.sjsc.repository.SJSCQuery;
import com.yuansong.dailyHelper.global.DHConstant;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SJSCService {

    private static final Logger logger = LoggerFactory.getLogger(SJSCService.class);

    private final SJSCRepService sjscRepService;

    public SJSCService(SJSCRepService sjscRepService) {
        this.sjscRepService = sjscRepService;
    }

    public String getExportFileName() {
        return FileUtil.getNextStr() + "三级四从.xlsx";
    }

    public XSSFWorkTable getDataTable(List<SJSCDo> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return XSSFWorkBookTool.getXSSFWorkTable("三级四从", list, new SJSCDataMapper());
    }


    private void saveFile(String fileName, XSSFWorkTable table, String logKey) {
        List<XSSFWorkTable> list = new ArrayList<>();
        list.add(table);
        this.saveFile(fileName, list, logKey);
    }

    //保存文件
    private void saveFile(String fileName, List<XSSFWorkTable> list, String taskId) {
        boolean flag = false;
        while (!flag) {
            try {
                logger.debug(MessageFormat.format("{0} 开始生成{1}数据文件", taskId, "三级四从"));
                XSSFWorkbook f = XSSFWorkBookTool.getXSSFWorkBook(list);
                logger.debug(MessageFormat.format("{0} 生成{1}数据文件完成", taskId, "三级四从"));
                logger.debug(MessageFormat.format("{0} 开始{1}保存数据文件", taskId, "三级四从"));
                FileUtil.saveXSSFWorkbook(fileName, f);
                logger.debug(MessageFormat.format("{0} 保存{1}数据文件完成", taskId, "三级四从"));
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
    public void getFile(String begDate, String endDate) {
        String taskId = CommonTool.UUID().replace("-", "");
        logger.debug(MessageFormat.format("{0} 开始获取三级四从数据 {1} {2}", taskId, begDate, endDate));
        List<SJSCDo> result = new ArrayList<>();
        SJSCQuery query = SJSCQuery.builder().setBegDate(begDate).setEndDate(endDate);
        boolean flag = false;
        while (!flag) {
            try{
                List<SJSCDo> list = sjscRepService.getList(query);
                result.addAll(list);
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        flag = false;
        this.saveFile(this.getExportFileName(),this.getDataTable(result),taskId);
    }

}
