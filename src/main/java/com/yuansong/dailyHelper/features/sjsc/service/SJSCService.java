package com.yuansong.dailyHelper.features.sjsc.service;

import com.github.deansquirrel.tools.common.CommonTool;
import com.github.deansquirrel.tools.common.ExceptionTool;
import com.github.deansquirrel.tools.poi.WorkBookTool;
import com.github.deansquirrel.tools.poi.WorkTableData;
import com.yuansong.dailyHelper.features.sjsc.repository.SJSCDo;
import com.yuansong.dailyHelper.features.sjsc.repository.SJSCQuery;
import com.yuansong.dailyHelper.global.DHConstant;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.ArrayList;
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

    public WorkTableData getDataTable(List<SJSCDo> list) {
        if(list == null) {
            list = new ArrayList<>();
        }
        return WorkBookTool.getXSSFWorkTable("三级四从", list, new SJSCDataMapper());
    }


    private void saveFile(String fileName, WorkTableData table, String logKey) {
        List<WorkTableData> list = new ArrayList<>();
        list.add(table);
        this.saveFile(fileName, list, logKey);
    }

    //保存文件
    private void saveFile(String fileName, List<WorkTableData> list, String taskId) {
        boolean flag = false;
        while (!flag) {
            try {
                logger.debug(MessageFormat.format("{0} 开始生成{1}数据文件", taskId, "三级四从"));
                SXSSFWorkbook f = WorkBookTool.getSXSSFWorkBook(list);
                logger.debug(MessageFormat.format("{0} 生成{1}数据文件完成", taskId, "三级四从"));
                logger.debug(MessageFormat.format("{0} 开始{1}保存数据文件", taskId, "三级四从"));
//                FileUtil.saveXSSFWorkbook(fileName, f);
                FileUtil.saveSXSSFWorkbook(fileName, f);
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
                List<SJSCDo> list = sjscRepService.getList01(query);
                logger.debug(MessageFormat.format("data row count: {0}", list.size()));
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
        while (!flag) {
            try{
                List<SJSCDo> list = sjscRepService.getList02(query);
                logger.debug(MessageFormat.format("data row count: {0}", list.size()));
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
        while (!flag) {
            try{
                List<SJSCDo> list = sjscRepService.getList03(query);
                logger.debug(MessageFormat.format("data row count: {0}", list.size()));
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
        while (!flag) {
            try{
                List<SJSCDo> list = sjscRepService.getList04(query);
                logger.debug(MessageFormat.format("data row count: {0}", list.size()));
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
        while (!flag) {
            try{
                List<SJSCDo> list = sjscRepService.getList05(query);
                logger.debug(MessageFormat.format("data row count: {0}", list.size()));
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
        while (!flag) {
            try{
                List<SJSCDo> list = sjscRepService.getList06(query);
                logger.debug(MessageFormat.format("data row count: {0}", list.size()));
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
        while (!flag) {
            try{
                List<SJSCDo> list = sjscRepService.getList07(query);
                logger.debug(MessageFormat.format("data row count: {0}", list.size()));
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
        while (!flag) {
            try{
                List<SJSCDo> list = sjscRepService.getList08(query);
                logger.debug(MessageFormat.format("data row count: {0}", list.size()));
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
        while (!flag) {
            try{
                List<SJSCDo> list = sjscRepService.getList09(query);
                logger.debug(MessageFormat.format("data row count: {0}", list.size()));
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
        while (!flag) {
            try{
                List<SJSCDo> list = sjscRepService.getList10(query);
                logger.debug(MessageFormat.format("data row count: {0}", list.size()));
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
        while (!flag) {
            try{
                List<SJSCDo> list = sjscRepService.getList11(query);
                logger.debug(MessageFormat.format("data row count: {0}", list.size()));
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
        while (!flag) {
            try{
                List<SJSCDo> list = sjscRepService.getList12(query);
                logger.debug(MessageFormat.format("data row count: {0}", list.size()));
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
        while (!flag) {
            try{
                List<SJSCDo> list = sjscRepService.getList13(query);
                logger.debug(MessageFormat.format("data row count: {0}", list.size()));
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
        while (!flag) {
            try{
                List<SJSCDo> list = sjscRepService.getList14(query);
                logger.debug(MessageFormat.format("data row count: {0}", list.size()));
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
        while (!flag) {
            try{
                List<SJSCDo> list = sjscRepService.getList15(query);
                logger.debug(MessageFormat.format("data row count: {0}", list.size()));
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
        while (!flag) {
            try{
                List<SJSCDo> list = sjscRepService.getList16(query);
                logger.debug(MessageFormat.format("data row count: {0}", list.size()));
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
        while (!flag) {
            try{
                List<SJSCDo> list = sjscRepService.getList17(query);
                logger.debug(MessageFormat.format("data row count: {0}", list.size()));
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
        while (!flag) {
            try{
                List<SJSCDo> list = sjscRepService.getList18(query);
                logger.debug(MessageFormat.format("data row count: {0}", list.size()));
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
        while (!flag) {
            try{
                List<SJSCDo> list = sjscRepService.getList19(query);
                logger.debug(MessageFormat.format("data row count: {0}", list.size()));
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

        this.saveFile(this.getExportFileName(),this.getDataTable(result),taskId);
    }

}
