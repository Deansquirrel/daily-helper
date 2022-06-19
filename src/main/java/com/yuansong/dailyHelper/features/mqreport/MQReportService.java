package com.yuansong.dailyHelper.features.mqreport;

import com.github.deansquirrel.tools.common.CommonTool;
import com.github.deansquirrel.tools.common.ExceptionTool;
import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.m01.service.M01Service;
import com.yuansong.dailyHelper.features.mqreport.m02.service.M02Service;
import com.yuansong.dailyHelper.features.mqreport.m03.service.M03Service;
import com.yuansong.dailyHelper.global.DHConstant;
import com.yuansong.dailyHelper.util.io.FileUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MQReportService {

    private static final Logger logger = LoggerFactory.getLogger(MQReportService.class);

    private final M01Service m01Service;        //职工参保
    private final M02Service m02Service;        //居民参保
    private final M03Service m03Service;        //职工待遇

    public MQReportService(M01Service m01Service, M02Service m02Service, M03Service m03Service) {
        this.m01Service = m01Service;
        this.m02Service = m02Service;
        this.m03Service = m03Service;
    }

    private String getExportFileName() {
        return FileUtil.getNextStr() + "月报.xlsx";
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getAllMFile(Date queryMonth) {
        String taskId = "";
        logger.debug(taskId + "开始导出全部月报数据");
        boolean flag = false;
        List<XSSFWorkTable> list = new ArrayList<>();
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + "开始查询M01月报数据");
                list.add(m01Service.getM01DataTable(m01Service.getM01Data(null)));
                logger.debug(taskId + "查询M01月报数据完成");
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
        while(!flag){
            taskId = CommonTool.UUID().replace("-", "");
            try{
                logger.debug(taskId + "开始查询M02月报数据");
                list.add(m02Service.getM02DataTable(m02Service.getM02Data(null)));
                logger.debug(taskId + "查询M02月报数据完成");
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
        while(!flag){
            taskId = CommonTool.UUID().replace("-", "");
            try{
                logger.debug(taskId + "开始查询M03月报数据");
                list.add(m03Service.getM03DataTable(m03Service.getM03Data(null)));
                logger.debug(taskId + "查询M03月报数据完成");
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
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try{
                logger.debug(taskId + "开始生成AllM月报数据文件");
                XSSFWorkbook f = XSSFWorkBookTool.getXSSFWorkBook(list);
                logger.debug(taskId + "生成AllM月报数据文件完成");
                logger.debug(taskId + "开始保存AllM月报数据文件");
                String fileName = this.getExportFileName();
                logger.debug(fileName);
                FileUtil.saveXSSFWorkbook(fileName, f);
                logger.debug(taskId + "保存AllM月报数据文件完成");
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

    /**
     * 异步导出M01
     * @param queryMonth 查询月份（月份首日）
     */
    @Async(DHConstant.TASK_EXECUTOR)
    public void getM01File(Date queryMonth) {
        boolean flag = false;
        List<XSSFWorkTable> list = new ArrayList<>();
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + "开始导出M01月报数据");
                logger.debug(taskId + "开始查询M01月报数据");
                list.add(m01Service.getM01DataTable(m01Service.getM01Data(null)));
                logger.debug(taskId + "查询M01月报数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        flag = false;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try{
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

    @Async(DHConstant.TASK_EXECUTOR)
    public void getM02File(Date queryMonth) {
        boolean flag = false;
        List<XSSFWorkTable> list = new ArrayList<>();
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + "开始导出M02月报数据");
                logger.debug(taskId + "开始查询M02月报数据");
                list.add(m02Service.getM02DataTable(m02Service.getM02Data(null)));
                logger.debug(taskId + "查询M02月报数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        flag = false;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try{
                logger.debug(taskId + "开始生成M02月报数据文件");
                XSSFWorkbook f = XSSFWorkBookTool.getXSSFWorkBook(list);
                logger.debug(taskId + "生成M02月报数据文件完成");
                logger.debug(taskId + "开始保存M02月报数据文件");
                String fileName = m02Service.getExportFileName();
                logger.debug(fileName);
                FileUtil.saveXSSFWorkbook(fileName, f);
                logger.debug(taskId + "保存M02月报数据文件完成");
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
    public void getM03File(Date queryMonth) {
        boolean flag = false;
        List<XSSFWorkTable> list = new ArrayList<>();
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + "开始导出M03月报数据");
                logger.debug(taskId + "开始查询M03月报数据");
                list.add(m03Service.getM03DataTable(m03Service.getM03Data(null)));
                logger.debug(taskId + "查询M03月报数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        flag = false;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try{
                logger.debug(taskId + "开始生成M03月报数据文件");
                XSSFWorkbook f = XSSFWorkBookTool.getXSSFWorkBook(list);
                logger.debug(taskId + "生成M03月报数据文件完成");
                logger.debug(taskId + "开始保存M03月报数据文件");
                String fileName = m03Service.getExportFileName();
                logger.debug(fileName);
                FileUtil.saveXSSFWorkbook(fileName, f);
                logger.debug(taskId + "保存M03月报数据文件完成");
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
