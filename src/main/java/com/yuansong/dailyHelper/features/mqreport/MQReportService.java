package com.yuansong.dailyHelper.features.mqreport;

import com.github.deansquirrel.tools.common.CommonTool;
import com.github.deansquirrel.tools.common.ExceptionTool;
import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.features.mqreport.m01.repository.M01Do;
import com.yuansong.dailyHelper.features.mqreport.m01.service.M01Service;
import com.yuansong.dailyHelper.features.mqreport.m02.repository.M02Do;
import com.yuansong.dailyHelper.features.mqreport.m02.service.M02Service;
import com.yuansong.dailyHelper.features.mqreport.m03.repository.M03Do;
import com.yuansong.dailyHelper.features.mqreport.m03.service.M03Service;
import com.yuansong.dailyHelper.features.mqreport.m04.repository.M04Do;
import com.yuansong.dailyHelper.features.mqreport.m04.service.M04Service;
import com.yuansong.dailyHelper.features.mqreport.m05.repository.M05Do;
import com.yuansong.dailyHelper.features.mqreport.m05.service.M05Service;
import com.yuansong.dailyHelper.global.DHConstant;
import com.yuansong.dailyHelper.util.io.FileUtil;
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
public class MQReportService {

    private static final Logger logger = LoggerFactory.getLogger(MQReportService.class);

    private final M01Service m01Service;        //职工参保
    private final M02Service m02Service;        //居民参保
    private final M03Service m03Service;        //职工待遇
    private final M04Service m04Service;        //职工待遇
    private final M05Service m05Service;        //生育

    public MQReportService(M01Service m01Service, M02Service m02Service, M03Service m03Service, M04Service m04Service, M05Service m05Service) {
        this.m01Service = m01Service;
        this.m02Service = m02Service;
        this.m03Service = m03Service;
        this.m04Service = m04Service;
        this.m05Service = m05Service;
    }

    private String getExportFileName() {
        return FileUtil.getNextStr() + "月报.xlsx";
    }

    private void saveFile(String fileName, XSSFWorkTable table, String logKey) {
        List<XSSFWorkTable> list = new ArrayList<>();
        list.add(table);
        this.saveFile(fileName, list, logKey);
    }

    //保存文件
    private void saveFile(String fileName, List<XSSFWorkTable> list, String logKey) {
        String taskId = CommonTool.UUID().replace("-", "");
        boolean flag = false;
        while (!flag) {
            try {
                logger.debug(MessageFormat.format("{0} 开始生成{1}数据文件", taskId, logKey));
                XSSFWorkbook f = XSSFWorkBookTool.getXSSFWorkBook(list);
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
    public void getAllMFile(Date queryMonth) {
        String taskId = "";
        logger.debug(taskId + "开始导出全部月报数据");
        boolean flag = false;
        List<XSSFWorkTable> list = new ArrayList<>();
        List<M01Do> m01Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询M01月报数据");
                m01Data = m01Service.getMData(queryMonth);
                list.add(m01Service.getMDataTable(m01Data));
                logger.debug(taskId + " 查询M01月报数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(m01Service.getExportFileName(), m01Service.getMDataTable(m01Data),"M01");
        flag = false;
        List<M02Do> m02Data = null;
        while(!flag){
            taskId = CommonTool.UUID().replace("-", "");
            try{
                logger.debug(taskId + " 开始查询M02月报数据");
                m02Data = m02Service.getMData(queryMonth);
                list.add(m02Service.getMDataTable(m02Data));
                logger.debug(taskId + " 查询M02月报数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(m02Service.getExportFileName(), m02Service.getMDataTable(m02Data),"M02");
        flag = false;
        List<M03Do> m03Data = null;
        while(!flag){
            taskId = CommonTool.UUID().replace("-", "");
            try{
                logger.debug(taskId + " 开始查询M03月报数据");
                m03Data = m03Service.getMData(queryMonth);
                list.add(m03Service.getMDataTable(m03Data));
                logger.debug(taskId + " 查询M03月报数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(m03Service.getExportFileName(), m03Service.getMDataTable(m03Data),"M03");
        flag = false;
        List<M04Do> m04Data = null;
        while(!flag){
            taskId = CommonTool.UUID().replace("-", "");
            try{
                logger.debug(taskId + " 开始查询M04月报数据");
                m04Data = m04Service.getMData(queryMonth);
                list.add(m04Service.getMDataTable(m04Data));
                logger.debug(taskId + " 查询M04月报数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(m04Service.getExportFileName(), m04Service.getMDataTable(m04Data),"M04");
        flag = false;
        List<M05Do> m05Data = null;
        while(!flag){
            taskId = CommonTool.UUID().replace("-", "");
            try{
                logger.debug(taskId + " 开始查询M05月报数据");
                m05Data = m05Service.getMData(queryMonth);
                list.add(m05Service.getMDataTable(m05Data));
                logger.debug(taskId + " 查询M05月报数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(m05Service.getExportFileName(), m05Service.getMDataTable(m05Data),"M05");
        this.saveFile(this.getExportFileName(), list, "AllM月报");
    }

    /**
     * 异步导出M01
     * @param queryMonth 查询月份（月份首日）
     */
    @Async(DHConstant.TASK_EXECUTOR)
    public void getM01File(Date queryMonth) {
        boolean flag = false;
        List<M01Do> mData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出M01月报数据");
                logger.debug(taskId + " 开始查询M01月报数据");
                mData =  m01Service.getMData(queryMonth);
                logger.debug(taskId + " 查询M01月报数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(m01Service.getExportFileName(), m01Service.getMDataTable(mData), "M01月报");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getM02File(Date queryMonth) {
        boolean flag = false;
        List<M02Do> mData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出M02月报数据");
                logger.debug(taskId + " 开始查询M02月报数据");
                mData =  m02Service.getMData(queryMonth);
                logger.debug(taskId + " 查询M02月报数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(m02Service.getExportFileName(), m02Service.getMDataTable(mData), "M02月报");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getM03File(Date queryMonth) {
        boolean flag = false;
        List<M03Do> mData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出M03月报数据");
                logger.debug(taskId + " 开始查询M03月报数据");
                mData = m03Service.getMData(queryMonth);
                logger.debug(taskId + " 查询M03月报数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(m03Service.getExportFileName(), m03Service.getMDataTable(mData), "M03月报");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getM04File(Date queryMonth) {
        boolean flag = false;
        List<M04Do> mData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出M04月报数据");
                logger.debug(taskId + " 开始查询M04月报数据");
                mData = m04Service.getMData(queryMonth);
                logger.debug(taskId + " 查询M04月报数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(m04Service.getExportFileName(), m04Service.getMDataTable(mData), "M04月报");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getM05File(Date queryMonth) {
        boolean flag = false;
        List<M05Do> mData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出M05月报数据");
                logger.debug(taskId + " 开始查询M05月报数据");
                mData = m05Service.getMData(queryMonth);
                logger.debug(taskId + " 查询M05月报数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(m05Service.getExportFileName(), m05Service.getMDataTable(mData), "M05月报");
    }

}
