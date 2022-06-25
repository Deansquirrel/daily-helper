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
import com.yuansong.dailyHelper.features.mqreport.m06.repository.M06Do;
import com.yuansong.dailyHelper.features.mqreport.m06.service.M06Service;
import com.yuansong.dailyHelper.features.mqreport.m07.repository.M07Do;
import com.yuansong.dailyHelper.features.mqreport.m07.service.M07Service;
import com.yuansong.dailyHelper.features.mqreport.m08.repository.M08Do;
import com.yuansong.dailyHelper.features.mqreport.m08.service.M08Service;
import com.yuansong.dailyHelper.features.mqreport.m09.repository.M09Do;
import com.yuansong.dailyHelper.features.mqreport.m09.service.M09Service;
import com.yuansong.dailyHelper.features.mqreport.q01.repository.Q01Do;
import com.yuansong.dailyHelper.features.mqreport.q01.service.Q01Service;
import com.yuansong.dailyHelper.features.mqreport.q02.repository.Q02Do;
import com.yuansong.dailyHelper.features.mqreport.q02.service.Q02Service;
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
    private final M06Service m06Service;        //职工实施统账在职
    private final M07Service m07Service;        //职工实施统账退休
    private final M08Service m08Service;        //农民工（进城务工人员参加职工基本医疗保险的人数）
    private final M09Service m09Service;        //一次性缴费

    private final Q01Service q01Service;        //HI2参保人数
    private final Q02Service q02Service;        //HI3保险费征缴情况

    public MQReportService(M01Service m01Service, M02Service m02Service, M03Service m03Service,
                           M04Service m04Service, M05Service m05Service, M06Service m06Service,
                           M07Service m07Service, M08Service m08Service, M09Service m09Service,
                           Q01Service q01Service, Q02Service q02Service) {
        this.m01Service = m01Service;
        this.m02Service = m02Service;
        this.m03Service = m03Service;
        this.m04Service = m04Service;
        this.m05Service = m05Service;
        this.m06Service = m06Service;
        this.m07Service = m07Service;
        this.m08Service = m08Service;
        this.m09Service = m09Service;
        this.q01Service = q01Service;
        this.q02Service = q02Service;
    }

    private String getMExportFileName() {
        return FileUtil.getNextStr() + "月报.xlsx";
    }
    private String getQExportFileName() {
        return FileUtil.getNextStr() + "季报.xlsx";
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
    public void getAllQFile(Date queryMonth) {
        String taskId = "";
        logger.debug(taskId + "开始导出全部季报数据");
        boolean flag = false;
        List<XSSFWorkTable> list = new ArrayList<>();
        List<Q01Do> q01Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q01数据");
                q01Data = q01Service.getQData(queryMonth);
                list.add(q01Service.getQDataTable(q01Data));
                logger.debug(taskId + " 查询Q01数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q01Service.getExportFileName(), q01Service.getQDataTable(q01Data),"Q01");
        flag = false;
        List<Q02Do> q02Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q02数据");
                q02Data = q02Service.getQData(queryMonth);
                list.add(q02Service.getQDataTable(q02Data));
                logger.debug(taskId + " 查询Q02数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q02Service.getExportFileName(), q02Service.getQDataTable(q02Data),"Q02");
        this.saveFile(this.getQExportFileName(), list, "AllQ季报");
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
        flag = false;
        List<M06Do> m06Data = null;
        while(!flag){
            taskId = CommonTool.UUID().replace("-", "");
            try{
                logger.debug(taskId + " 开始查询M06月报数据");
                m06Data = m06Service.getMData(queryMonth);
                list.add(m06Service.getMDataTable(m06Data));
                logger.debug(taskId + " 查询M06月报数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(m06Service.getExportFileName(), m06Service.getMDataTable(m06Data),"M06");
        flag = false;
        List<M07Do> m07Data = null;
        while(!flag){
            taskId = CommonTool.UUID().replace("-", "");
            try{
                logger.debug(taskId + " 开始查询M07月报数据");
                m07Data = m07Service.getMData(queryMonth);
                list.add(m07Service.getMDataTable(m07Data));
                logger.debug(taskId + " 查询M07月报数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(m07Service.getExportFileName(), m07Service.getMDataTable(m07Data),"M07");
        flag = false;
        List<M08Do> m08Data = null;
        while(!flag){
            taskId = CommonTool.UUID().replace("-", "");
            try{
                logger.debug(taskId + " 开始查询M08月报数据");
                m08Data = m08Service.getMData(queryMonth);
                list.add(m08Service.getMDataTable(m08Data));
                logger.debug(taskId + " 查询M08月报数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(m08Service.getExportFileName(), m08Service.getMDataTable(m08Data),"M08");
        flag = false;
        List<M09Do> m09Data = null;
        while(!flag){
            taskId = CommonTool.UUID().replace("-", "");
            try{
                logger.debug(taskId + " 开始查询M09月报数据");
                m09Data = m09Service.getMData(queryMonth);
                list.add(m09Service.getMDataTable(m09Data));
                logger.debug(taskId + " 查询M09月报数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(m09Service.getExportFileName(), m09Service.getMDataTable(m09Data),"M09");
        this.saveFile(this.getMExportFileName(), list, "AllM月报");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ01File(Date queryMonth) {
        boolean flag = false;
        List<Q01Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q01数据");
                logger.debug(taskId + " 开始查询Q01数据");
                qData =  q01Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q01数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q01Service.getExportFileName(), q01Service.getQDataTable(qData), "Q01");
    }
    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ02File(Date queryMonth) {
        boolean flag = false;
        List<Q02Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q02数据");
                logger.debug(taskId + " 开始查询Q02数据");
                qData =  q02Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q02数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q02Service.getExportFileName(), q02Service.getQDataTable(qData), "Q02");
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

    @Async(DHConstant.TASK_EXECUTOR)
    public void getM06File(Date queryMonth) {
        boolean flag = false;
        List<M06Do> mData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出M06月报数据");
                logger.debug(taskId + " 开始查询M06月报数据");
                mData = m06Service.getMData(queryMonth);
                logger.debug(taskId + " 查询M06月报数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(m06Service.getExportFileName(), m06Service.getMDataTable(mData), "M06月报");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getM07File(Date queryMonth) {
        boolean flag = false;
        List<M07Do> mData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出M07月报数据");
                logger.debug(taskId + " 开始查询M07月报数据");
                mData = m07Service.getMData(queryMonth);
                logger.debug(taskId + " 查询M07月报数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(m07Service.getExportFileName(), m07Service.getMDataTable(mData), "M07月报");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getM08File(Date queryMonth) {
        boolean flag = false;
        List<M08Do> mData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出M08月报数据");
                logger.debug(taskId + " 开始查询M08月报数据");
                mData = m08Service.getMData(queryMonth);
                logger.debug(taskId + " 查询M08月报数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(m08Service.getExportFileName(), m08Service.getMDataTable(mData), "M08月报");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getM09File(Date queryMonth) {
        boolean flag = false;
        List<M09Do> mData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出M09月报数据");
                logger.debug(taskId + " 开始查询M09月报数据");
                mData = m09Service.getMData(queryMonth);
                logger.debug(taskId + " 查询M09月报数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(m09Service.getExportFileName(), m09Service.getMDataTable(mData), "M09月报");
    }

}
