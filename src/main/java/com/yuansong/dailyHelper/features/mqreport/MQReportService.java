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
import com.yuansong.dailyHelper.features.mqreport.q03.repository.Q03Do;
import com.yuansong.dailyHelper.features.mqreport.q03.service.Q03Service;
import com.yuansong.dailyHelper.features.mqreport.q04.repository.Q04Do;
import com.yuansong.dailyHelper.features.mqreport.q04.service.Q04Service;
import com.yuansong.dailyHelper.features.mqreport.q05.repository.Q05Do;
import com.yuansong.dailyHelper.features.mqreport.q05.service.Q05Service;
import com.yuansong.dailyHelper.features.mqreport.q06.repository.Q06Do;
import com.yuansong.dailyHelper.features.mqreport.q06.service.Q06Service;
import com.yuansong.dailyHelper.features.mqreport.q07.repository.Q07Do;
import com.yuansong.dailyHelper.features.mqreport.q07.service.Q07Service;
import com.yuansong.dailyHelper.features.mqreport.q08.repository.Q08Do;
import com.yuansong.dailyHelper.features.mqreport.q08.service.Q08Service;
import com.yuansong.dailyHelper.features.mqreport.q09.repository.Q09Do;
import com.yuansong.dailyHelper.features.mqreport.q09.service.Q09Service;
import com.yuansong.dailyHelper.features.mqreport.q10.repository.Q10Do;
import com.yuansong.dailyHelper.features.mqreport.q10.service.Q10Service;
import com.yuansong.dailyHelper.features.mqreport.q11.repository.Q11Do;
import com.yuansong.dailyHelper.features.mqreport.q11.service.Q11Service;
import com.yuansong.dailyHelper.features.mqreport.q12.repository.Q12Do;
import com.yuansong.dailyHelper.features.mqreport.q12.service.Q12Service;
import com.yuansong.dailyHelper.features.mqreport.q13.repository.Q13Do;
import com.yuansong.dailyHelper.features.mqreport.q13.service.Q13Service;
import com.yuansong.dailyHelper.features.mqreport.q14.repository.Q14Do;
import com.yuansong.dailyHelper.features.mqreport.q14.service.Q14Service;
import com.yuansong.dailyHelper.features.mqreport.q15.repository.Q15Do;
import com.yuansong.dailyHelper.features.mqreport.q15.service.Q15Service;
import com.yuansong.dailyHelper.features.mqreport.q16.repository.Q16Do;
import com.yuansong.dailyHelper.features.mqreport.q16.service.Q16Service;
import com.yuansong.dailyHelper.features.mqreport.q17.repository.Q17Do;
import com.yuansong.dailyHelper.features.mqreport.q17.service.Q17Service;
import com.yuansong.dailyHelper.features.mqreport.q18.repository.Q18Do;
import com.yuansong.dailyHelper.features.mqreport.q18.service.Q18Service;
import com.yuansong.dailyHelper.features.mqreport.q19.repository.Q19Do;
import com.yuansong.dailyHelper.features.mqreport.q19.service.Q19Service;
import com.yuansong.dailyHelper.features.mqreport.q20.repository.Q20Do;
import com.yuansong.dailyHelper.features.mqreport.q20.service.Q20Service;
import com.yuansong.dailyHelper.features.mqreport.q21.repository.Q21Do;
import com.yuansong.dailyHelper.features.mqreport.q21.service.Q21Service;
import com.yuansong.dailyHelper.features.mqreport.q22.repository.Q22Do;
import com.yuansong.dailyHelper.features.mqreport.q22.service.Q22Service;
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
    private final Q03Service q03Service;        //HI3一次性缴费
    private final Q04Service q04Service;        //HI4普通门诊-普通门诊在职退休
    private final Q05Service q05Service;        //HI4普通门诊-普通门诊医疗级别
    private final Q06Service q06Service;        //HI4门诊大病-门诊大病在职退休
    private final Q07Service q07Service;        //HI4门诊大病-门诊大病医疗级别
    private final Q08Service q08Service;        //HI4药店-药店在职退休
    private final Q10Service q10Service;        //HI4享受待遇人数
    private final Q09Service q09Service;        //HI4.1住院按照支出构成-在职退休
    private final Q11Service q11Service;        //HI4.1住院按照支出构成-医疗级别
    private final Q12Service q12Service;        //HI4.1住院按照支出类别-在职退休
    private final Q13Service q13Service;        //HI4.1住院按照支出类别-医疗级别
    private final Q14Service q14Service;        //HI4.1住院人数
    private final Q15Service q15Service;        //HI7其中建档立卡贫困人员-普通门急诊
    private final Q16Service q16Service;        //HI7其中建档立卡贫困人员-门诊大病
    private final Q17Service q17Service;        //HI7其中建档立卡贫困人员-住院按照支出构成
    private final Q18Service q18Service;        //HI7其中建档立卡贫困人员-住院按照支出类别
    private final Q19Service q19Service;        //HI7其中60岁以上老人，学生-门诊
    private final Q20Service q20Service;        //HI7其中60岁以上老人，学生-慢病
    private final Q21Service q21Service;        //HI7其中60岁以上老人，学生-住院按照支出构成
    private final Q22Service q22Service;        //HI7其中60岁以上老人，学生-住院按照支出类别

    public MQReportService(M01Service m01Service, M02Service m02Service, M03Service m03Service,
                           M04Service m04Service, M05Service m05Service, M06Service m06Service,
                           M07Service m07Service, M08Service m08Service, M09Service m09Service,
                           Q01Service q01Service, Q02Service q02Service, Q03Service q03Service,
                           Q04Service q04Service, Q05Service q05Service, Q06Service q06Service,
                           Q07Service q07Service, Q08Service q08Service, Q10Service q10Service,
                           Q09Service q09Service, Q11Service q11Service, Q12Service q12Service,
                           Q13Service q13Service, Q14Service q14Service, Q15Service q15Service,
                           Q16Service q16Service, Q17Service q17Service, Q18Service q18Service,
                           Q19Service q19Service, Q20Service q20Service, Q21Service q21Service, Q22Service q22Service) {
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
        this.q03Service = q03Service;
        this.q04Service = q04Service;
        this.q05Service = q05Service;
        this.q06Service = q06Service;
        this.q07Service = q07Service;
        this.q08Service = q08Service;
        this.q10Service = q10Service;
        this.q09Service = q09Service;
        this.q11Service = q11Service;
        this.q12Service = q12Service;
        this.q13Service = q13Service;
        this.q14Service = q14Service;
        this.q15Service = q15Service;
        this.q16Service = q16Service;
        this.q17Service = q17Service;
        this.q18Service = q18Service;
        this.q19Service = q19Service;
        this.q20Service = q20Service;
        this.q21Service = q21Service;
        this.q22Service = q22Service;
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
        flag = false;
        List<Q03Do> q03Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q03数据");
                q03Data = q03Service.getQData(queryMonth);
                list.add(q03Service.getQDataTable(q03Data));
                logger.debug(taskId + " 查询Q03数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q03Service.getExportFileName(), q03Service.getQDataTable(q03Data),"Q03");
        flag = false;
        List<Q04Do> q04Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q04数据");
                q04Data = q04Service.getQData(queryMonth);
                list.add(q04Service.getQDataTable(q04Data));
                logger.debug(taskId + " 查询Q04数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q04Service.getExportFileName(), q04Service.getQDataTable(q04Data),"Q04");
        flag = false;
        List<Q05Do> q05Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q05数据");
                q05Data = q05Service.getQData(queryMonth);
                list.add(q05Service.getQDataTable(q05Data));
                logger.debug(taskId + " 查询Q05数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q05Service.getExportFileName(), q05Service.getQDataTable(q05Data),"Q05");
        flag = false;
        List<Q06Do> q06Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q06数据");
                q06Data = q06Service.getQData(queryMonth);
                list.add(q06Service.getQDataTable(q06Data));
                logger.debug(taskId + " 查询Q06数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q06Service.getExportFileName(), q06Service.getQDataTable(q06Data),"Q06");
        flag = false;
        List<Q07Do> q07Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q07数据");
                q07Data = q07Service.getQData(queryMonth);
                list.add(q07Service.getQDataTable(q07Data));
                logger.debug(taskId + " 查询Q07数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q07Service.getExportFileName(), q07Service.getQDataTable(q07Data),"Q07");
        flag = false;
        List<Q08Do> q08Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q08数据");
                q08Data = q08Service.getQData(queryMonth);
                list.add(q08Service.getQDataTable(q08Data));
                logger.debug(taskId + " 查询Q08数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q08Service.getExportFileName(), q08Service.getQDataTable(q08Data),"Q08");
        flag = false;
        List<Q10Do> q10Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q10数据");
                q10Data = q10Service.getQData(queryMonth);
                list.add(q10Service.getQDataTable(q10Data));
                logger.debug(taskId + " 查询Q10数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q10Service.getExportFileName(), q10Service.getQDataTable(q10Data),"Q10");
        flag = false;
        List<Q09Do> q09Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q09数据");
                q09Data = q09Service.getQData(queryMonth);
                list.add(q09Service.getQDataTable(q09Data));
                logger.debug(taskId + " 查询Q09数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q09Service.getExportFileName(), q09Service.getQDataTable(q09Data),"Q09");
        flag = false;
        List<Q11Do> q11Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q11数据");
                q11Data = q11Service.getQData(queryMonth);
                list.add(q11Service.getQDataTable(q11Data));
                logger.debug(taskId + " 查询Q11数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q11Service.getExportFileName(), q11Service.getQDataTable(q11Data),"Q11");
        flag = false;
        List<Q12Do> q12Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q12数据");
                q12Data = q12Service.getQData(queryMonth);
                list.add(q12Service.getQDataTable(q12Data));
                logger.debug(taskId + " 查询Q12数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q12Service.getExportFileName(), q12Service.getQDataTable(q12Data),"Q12");
        flag = false;
        List<Q13Do> q13Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q13数据");
                q13Data = q13Service.getQData(queryMonth);
                list.add(q13Service.getQDataTable(q13Data));
                logger.debug(taskId + " 查询Q13数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q13Service.getExportFileName(), q13Service.getQDataTable(q13Data),"Q13");
        flag = false;
        List<Q14Do> q14Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q14数据");
                q14Data = q14Service.getQData(queryMonth);
                list.add(q14Service.getQDataTable(q14Data));
                logger.debug(taskId + " 查询Q14数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q14Service.getExportFileName(), q14Service.getQDataTable(q14Data),"Q14");
        flag = false;
        List<Q15Do> q15Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q15数据");
                q15Data = q15Service.getQData(queryMonth);
                list.add(q15Service.getQDataTable(q15Data));
                logger.debug(taskId + " 查询Q15数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q15Service.getExportFileName(), q15Service.getQDataTable(q15Data),"Q15");
        flag = false;
        List<Q16Do> q16Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q16数据");
                q16Data = q16Service.getQData(queryMonth);
                list.add(q16Service.getQDataTable(q16Data));
                logger.debug(taskId + " 查询Q16数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q16Service.getExportFileName(), q16Service.getQDataTable(q16Data),"Q16");
        flag = false;
        List<Q17Do> q17Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q17数据");
                q17Data = q17Service.getQData(queryMonth);
                list.add(q17Service.getQDataTable(q17Data));
                logger.debug(taskId + " 查询Q17数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q17Service.getExportFileName(), q17Service.getQDataTable(q17Data),"Q17");
        flag = false;
        List<Q18Do> q18Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q18数据");
                q18Data = q18Service.getQData(queryMonth);
                list.add(q18Service.getQDataTable(q18Data));
                logger.debug(taskId + " 查询Q18数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q18Service.getExportFileName(), q18Service.getQDataTable(q18Data),"Q18");
        flag = false;
        List<Q19Do> q19Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q19数据");
                q19Data = q19Service.getQData(queryMonth);
                list.add(q19Service.getQDataTable(q19Data));
                logger.debug(taskId + " 查询Q19数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q19Service.getExportFileName(), q19Service.getQDataTable(q19Data),"Q19");
        flag = false;
        List<Q20Do> q20Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q20数据");
                q20Data = q20Service.getQData(queryMonth);
                list.add(q20Service.getQDataTable(q20Data));
                logger.debug(taskId + " 查询Q20数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q20Service.getExportFileName(), q20Service.getQDataTable(q20Data),"Q20");
        flag = false;
        List<Q21Do> q21Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q21数据");
                q21Data = q21Service.getQData(queryMonth);
                list.add(q21Service.getQDataTable(q21Data));
                logger.debug(taskId + " 查询Q21数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q21Service.getExportFileName(), q21Service.getQDataTable(q21Data),"Q21");
        flag = false;
        List<Q22Do> q22Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q22数据");
                q22Data = q22Service.getQData(queryMonth);
                list.add(q22Service.getQDataTable(q22Data));
                logger.debug(taskId + " 查询Q22数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q22Service.getExportFileName(), q22Service.getQDataTable(q22Data),"Q22");
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

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ03File(Date queryMonth) {
        boolean flag = false;
        List<Q03Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q03数据");
                logger.debug(taskId + " 开始查询Q03数据");
                qData =  q03Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q03数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q03Service.getExportFileName(), q03Service.getQDataTable(qData), "Q03");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ04File(Date queryMonth) {
        boolean flag = false;
        List<Q04Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q04数据");
                logger.debug(taskId + " 开始查询Q04数据");
                qData =  q04Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q04数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q04Service.getExportFileName(), q04Service.getQDataTable(qData), "Q04");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ05File(Date queryMonth) {
        boolean flag = false;
        List<Q05Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q05数据");
                logger.debug(taskId + " 开始查询Q05数据");
                qData =  q05Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q05数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q05Service.getExportFileName(), q05Service.getQDataTable(qData), "Q05");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ06File(Date queryMonth) {
        boolean flag = false;
        List<Q06Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q06数据");
                logger.debug(taskId + " 开始查询Q06数据");
                qData =  q06Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q06数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q06Service.getExportFileName(), q06Service.getQDataTable(qData), "Q06");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ07File(Date queryMonth) {
        boolean flag = false;
        List<Q07Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q07数据");
                logger.debug(taskId + " 开始查询Q07数据");
                qData =  q07Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q07数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q07Service.getExportFileName(), q07Service.getQDataTable(qData), "Q07");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ08File(Date queryMonth) {
        boolean flag = false;
        List<Q08Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q08数据");
                logger.debug(taskId + " 开始查询Q08数据");
                qData =  q08Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q08数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q08Service.getExportFileName(), q08Service.getQDataTable(qData), "Q08");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ09File(Date queryMonth) {
        boolean flag = false;
        List<Q09Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q09数据");
                logger.debug(taskId + " 开始查询Q09数据");
                qData =  q09Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q09数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q09Service.getExportFileName(), q09Service.getQDataTable(qData), "Q09");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ10File(Date queryMonth) {
        boolean flag = false;
        List<Q10Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q10数据");
                logger.debug(taskId + " 开始查询Q10数据");
                qData =  q10Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q10数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q10Service.getExportFileName(), q10Service.getQDataTable(qData), "Q10");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ11File(Date queryMonth) {
        boolean flag = false;
        List<Q11Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q11数据");
                logger.debug(taskId + " 开始查询Q11数据");
                qData =  q11Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q11数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1100L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q11Service.getExportFileName(), q11Service.getQDataTable(qData), "Q11");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ12File(Date queryMonth) {
        boolean flag = false;
        List<Q12Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q12数据");
                logger.debug(taskId + " 开始查询Q12数据");
                qData =  q12Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q12数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q12Service.getExportFileName(), q12Service.getQDataTable(qData), "Q12");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ13File(Date queryMonth) {
        boolean flag = false;
        List<Q13Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q13数据");
                logger.debug(taskId + " 开始查询Q13数据");
                qData =  q13Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q13数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q13Service.getExportFileName(), q13Service.getQDataTable(qData), "Q13");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ14File(Date queryMonth) {
        boolean flag = false;
        List<Q14Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q14数据");
                logger.debug(taskId + " 开始查询Q14数据");
                qData =  q14Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q14数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q14Service.getExportFileName(), q14Service.getQDataTable(qData), "Q14");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ15File(Date queryMonth) {
        boolean flag = false;
        List<Q15Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q15数据");
                logger.debug(taskId + " 开始查询Q15数据");
                qData =  q15Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q15数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q15Service.getExportFileName(), q15Service.getQDataTable(qData), "Q15");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ16File(Date queryMonth) {
        boolean flag = false;
        List<Q16Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q16数据");
                logger.debug(taskId + " 开始查询Q16数据");
                qData =  q16Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q16数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q16Service.getExportFileName(), q16Service.getQDataTable(qData), "Q16");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ17File(Date queryMonth) {
        boolean flag = false;
        List<Q17Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q17数据");
                logger.debug(taskId + " 开始查询Q17数据");
                qData =  q17Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q17数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q17Service.getExportFileName(), q17Service.getQDataTable(qData), "Q17");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ18File(Date queryMonth) {
        boolean flag = false;
        List<Q18Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q18数据");
                logger.debug(taskId + " 开始查询Q18数据");
                qData =  q18Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q18数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q18Service.getExportFileName(), q18Service.getQDataTable(qData), "Q18");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ19File(Date queryMonth) {
        boolean flag = false;
        List<Q19Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q19数据");
                logger.debug(taskId + " 开始查询Q19数据");
                qData =  q19Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q19数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q19Service.getExportFileName(), q19Service.getQDataTable(qData), "Q19");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ20File(Date queryMonth) {
        boolean flag = false;
        List<Q20Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q20数据");
                logger.debug(taskId + " 开始查询Q20数据");
                qData =  q20Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q20数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q20Service.getExportFileName(), q20Service.getQDataTable(qData), "Q20");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ21File(Date queryMonth) {
        boolean flag = false;
        List<Q21Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q21数据");
                logger.debug(taskId + " 开始查询Q21数据");
                qData =  q21Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q21数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q21Service.getExportFileName(), q21Service.getQDataTable(qData), "Q21");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ22File(Date queryMonth) {
        boolean flag = false;
        List<Q22Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q22数据");
                logger.debug(taskId + " 开始查询Q22数据");
                qData =  q22Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q22数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q22Service.getExportFileName(), q22Service.getQDataTable(qData), "Q22");
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
