package com.yuansong.dailyHelper.features.mqreport;

import com.github.deansquirrel.tools.common.CommonTool;
import com.github.deansquirrel.tools.common.ExceptionTool;
import com.github.deansquirrel.tools.poi.WorkBookTool;
import com.github.deansquirrel.tools.poi.WorkTableData;
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
import com.yuansong.dailyHelper.features.mqreport.q23.repository.Q23Do;
import com.yuansong.dailyHelper.features.mqreport.q23.service.Q23Service;
import com.yuansong.dailyHelper.features.mqreport.q24.repository.Q24Do;
import com.yuansong.dailyHelper.features.mqreport.q24.service.Q24Service;
import com.yuansong.dailyHelper.features.mqreport.q25.repository.Q25Do;
import com.yuansong.dailyHelper.features.mqreport.q25.service.Q25Service;
import com.yuansong.dailyHelper.features.mqreport.q26.repository.Q26Do;
import com.yuansong.dailyHelper.features.mqreport.q26.service.Q26Service;
import com.yuansong.dailyHelper.features.mqreport.q27.repository.Q27Do;
import com.yuansong.dailyHelper.features.mqreport.q27.service.Q27Service;
import com.yuansong.dailyHelper.features.mqreport.q28.repository.Q28Do;
import com.yuansong.dailyHelper.features.mqreport.q28.service.Q28Service;
import com.yuansong.dailyHelper.features.mqreport.q29.repository.Q29Do;
import com.yuansong.dailyHelper.features.mqreport.q29.service.Q29Service;
import com.yuansong.dailyHelper.features.mqreport.q30.repository.Q30Do;
import com.yuansong.dailyHelper.features.mqreport.q30.service.Q30Service;
import com.yuansong.dailyHelper.features.mqreport.q31.repository.Q31Do;
import com.yuansong.dailyHelper.features.mqreport.q31.service.Q31Service;
import com.yuansong.dailyHelper.features.mqreport.q32.repository.Q32Do;
import com.yuansong.dailyHelper.features.mqreport.q32.service.Q32Service;
import com.yuansong.dailyHelper.features.mqreport.q33.repository.Q33Do;
import com.yuansong.dailyHelper.features.mqreport.q33.service.Q33Service;
import com.yuansong.dailyHelper.features.mqreport.q34.repository.Q34Do;
import com.yuansong.dailyHelper.features.mqreport.q34.service.Q34Service;
import com.yuansong.dailyHelper.features.mqreport.q35.repository.Q35Do;
import com.yuansong.dailyHelper.features.mqreport.q35.service.Q35Service;
import com.yuansong.dailyHelper.features.mqreport.q36.repository.Q36Do;
import com.yuansong.dailyHelper.features.mqreport.q36.service.Q36Service;
import com.yuansong.dailyHelper.features.mqreport.q37.repository.Q37Do;
import com.yuansong.dailyHelper.features.mqreport.q37.service.Q37Service;
import com.yuansong.dailyHelper.features.mqreport.q38.repository.Q38Do;
import com.yuansong.dailyHelper.features.mqreport.q38.service.Q38Service;
import com.yuansong.dailyHelper.features.mqreport.q39.repository.Q39Do;
import com.yuansong.dailyHelper.features.mqreport.q39.service.Q39Service;
import com.yuansong.dailyHelper.features.mqreport.q40.repository.Q40Do;
import com.yuansong.dailyHelper.features.mqreport.q40.service.Q40Service;
import com.yuansong.dailyHelper.features.mqreport.q41.repository.Q41Do;
import com.yuansong.dailyHelper.features.mqreport.q41.service.Q41Service;
import com.yuansong.dailyHelper.features.mqreport.q42.repository.Q42Do;
import com.yuansong.dailyHelper.features.mqreport.q42.service.Q42Service;
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
    private final Q23Service q23Service;        //HI7按照医疗级别-门诊
    private final Q24Service q24Service;        //HI7按照医疗级别-慢特病
    private final Q25Service q25Service;        //HI7按照医疗级别-住院按照支出构成
    private final Q26Service q26Service;        //HI7按照支出类别-住院按照支出类别
    private final Q27Service q27Service;        //HI7.1、HI7.2慢病、两病用药
    private final Q28Service q28Service;        //HI8-普通门诊
    private final Q29Service q29Service;        //HI8-慢特病
    private final Q30Service q30Service;        //HI8-住院
    private final Q31Service q31Service;        //HI8.1-普通门诊
    private final Q32Service q32Service;        //HI8.1-门诊慢特病
    private final Q33Service q33Service;        //HI8.1-住院
    private final Q34Service q34Service;        //HI8.1-异地结算总人数
    private final Q35Service q35Service;        //HI9-城乡居民大病保险情况
    private final Q36Service q36Service;        //HI10-转移相关查询
    private final Q37Service q37Service;        //MI3-生育相关报表
    private final Q38Service q38Service;        //SI2大额报销人数
    private final Q39Service q39Service;        //SI2大额+公务员补助
    private final Q40Service q40Service;        //SI大额参保人数
    private final Q41Service q41Service;        //居民普通门诊、慢特病、和住院人数
    private final Q42Service q42Service;        //异地备案人次

    public MQReportService(M01Service m01Service, M02Service m02Service, M03Service m03Service,
                           M04Service m04Service, M05Service m05Service, M06Service m06Service,
                           M07Service m07Service, M08Service m08Service, M09Service m09Service,
                           Q01Service q01Service, Q02Service q02Service, Q03Service q03Service,
                           Q04Service q04Service, Q05Service q05Service, Q06Service q06Service,
                           Q07Service q07Service, Q08Service q08Service, Q10Service q10Service,
                           Q09Service q09Service, Q11Service q11Service, Q12Service q12Service,
                           Q13Service q13Service, Q14Service q14Service, Q15Service q15Service,
                           Q16Service q16Service, Q17Service q17Service, Q18Service q18Service,
                           Q19Service q19Service, Q20Service q20Service, Q21Service q21Service,
                           Q22Service q22Service, Q23Service q23Service, Q24Service q24Service,
                           Q25Service q25Service, Q26Service q26Service, Q27Service q27Service,
                           Q28Service q28Service, Q29Service q29Service, Q30Service q30Service,
                           Q31Service q31Service, Q32Service q32Service, Q33Service q33Service,
                           Q34Service q34Service, Q35Service q35Service, Q36Service q36Service,
                           Q37Service q37Service, Q38Service q38Service, Q39Service q39Service,
                           Q40Service q40Service, Q41Service q41Service, Q42Service q42Service) {
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
        this.q23Service = q23Service;
        this.q24Service = q24Service;
        this.q25Service = q25Service;
        this.q26Service = q26Service;
        this.q27Service = q27Service;
        this.q28Service = q28Service;
        this.q29Service = q29Service;
        this.q30Service = q30Service;
        this.q31Service = q31Service;
        this.q32Service = q32Service;
        this.q33Service = q33Service;
        this.q34Service = q34Service;
        this.q35Service = q35Service;
        this.q36Service = q36Service;
        this.q37Service = q37Service;
        this.q38Service = q38Service;
        this.q39Service = q39Service;
        this.q40Service = q40Service;
        this.q41Service = q41Service;
        this.q42Service = q42Service;
    }

    private String getMExportFileName() {
        return FileUtil.getNextStr() + "月报.xlsx";
    }
    private String getQExportFileName() {
        return FileUtil.getNextStr() + "季报.xlsx";
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
    public void getAllQFile(Date queryMonth) {
        String taskId = "";
        logger.debug(taskId + "开始导出全部季报数据");
        boolean flag = false;
        List<WorkTableData> list = new ArrayList<>();
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
        flag = false;
        List<Q23Do> q23Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q23数据");
                q23Data = q23Service.getQData(queryMonth);
                list.add(q23Service.getQDataTable(q23Data));
                logger.debug(taskId + " 查询Q23数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q23Service.getExportFileName(), q23Service.getQDataTable(q23Data),"Q23");
        flag = false;
        List<Q24Do> q24Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q24数据");
                q24Data = q24Service.getQData(queryMonth);
                list.add(q24Service.getQDataTable(q24Data));
                logger.debug(taskId + " 查询Q24数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q24Service.getExportFileName(), q24Service.getQDataTable(q24Data),"Q24");
        flag = false;
        List<Q25Do> q25Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q25数据");
                q25Data = q25Service.getQData(queryMonth);
                list.add(q25Service.getQDataTable(q25Data));
                logger.debug(taskId + " 查询Q25数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q25Service.getExportFileName(), q25Service.getQDataTable(q25Data),"Q25");
        flag = false;
        List<Q26Do> q26Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q26数据");
                q26Data = q26Service.getQData(queryMonth);
                list.add(q26Service.getQDataTable(q26Data));
                logger.debug(taskId + " 查询Q26数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q26Service.getExportFileName(), q26Service.getQDataTable(q26Data),"Q26");
        flag = false;
        List<Q27Do> q27Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q27数据");
                q27Data = q27Service.getQData(queryMonth);
                list.add(q27Service.getQDataTable(q27Data));
                logger.debug(taskId + " 查询Q27数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q27Service.getExportFileName(), q27Service.getQDataTable(q27Data),"Q27");
        flag = false;
        List<Q28Do> q28Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q28数据");
                q28Data = q28Service.getQData(queryMonth);
                list.add(q28Service.getQDataTable(q28Data));
                logger.debug(taskId + " 查询Q28数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q28Service.getExportFileName(), q28Service.getQDataTable(q28Data),"Q28");
        flag = false;
        List<Q29Do> q29Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q29数据");
                q29Data = q29Service.getQData(queryMonth);
                list.add(q29Service.getQDataTable(q29Data));
                logger.debug(taskId + " 查询Q29数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q29Service.getExportFileName(), q29Service.getQDataTable(q29Data),"Q29");
        flag = false;
        List<Q30Do> q30Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q30数据");
                q30Data = q30Service.getQData(queryMonth);
                list.add(q30Service.getQDataTable(q30Data));
                logger.debug(taskId + " 查询Q30数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q30Service.getExportFileName(), q30Service.getQDataTable(q30Data),"Q30");
        flag = false;
        List<Q31Do> q31Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q31数据");
                q31Data = q31Service.getQData(queryMonth);
                list.add(q31Service.getQDataTable(q31Data));
                logger.debug(taskId + " 查询Q31数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q31Service.getExportFileName(), q31Service.getQDataTable(q31Data),"Q31");
        flag = false;
        List<Q32Do> q32Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q32数据");
                q32Data = q32Service.getQData(queryMonth);
                list.add(q32Service.getQDataTable(q32Data));
                logger.debug(taskId + " 查询Q32数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q32Service.getExportFileName(), q32Service.getQDataTable(q32Data),"Q32");
        flag = false;
        List<Q33Do> q33Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q33数据");
                q33Data = q33Service.getQData(queryMonth);
                list.add(q33Service.getQDataTable(q33Data));
                logger.debug(taskId + " 查询Q33数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q33Service.getExportFileName(), q33Service.getQDataTable(q33Data),"Q33");
        flag = false;
        List<Q34Do> q34Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q34数据");
                q34Data = q34Service.getQData(queryMonth);
                list.add(q34Service.getQDataTable(q34Data));
                logger.debug(taskId + " 查询Q34数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q34Service.getExportFileName(), q34Service.getQDataTable(q34Data),"Q34");
        flag = false;
        List<Q35Do> q35Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q35数据");
                q35Data = q35Service.getQData(queryMonth);
                list.add(q35Service.getQDataTable(q35Data));
                logger.debug(taskId + " 查询Q35数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q35Service.getExportFileName(), q35Service.getQDataTable(q35Data),"Q35");
        flag = false;
        List<Q36Do> q36Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q36数据");
                q36Data = q36Service.getQData(queryMonth);
                list.add(q36Service.getQDataTable(q36Data));
                logger.debug(taskId + " 查询Q36数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q36Service.getExportFileName(), q36Service.getQDataTable(q36Data),"Q36");
        flag = false;
        List<Q37Do> q37Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q37数据");
                q37Data = q37Service.getQData(queryMonth);
                list.add(q37Service.getQDataTable(q37Data));
                logger.debug(taskId + " 查询Q37数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q37Service.getExportFileName(), q37Service.getQDataTable(q37Data),"Q37");
        flag = false;
        List<Q38Do> q38Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q38数据");
                q38Data = q38Service.getQData(queryMonth);
                list.add(q38Service.getQDataTable(q38Data));
                logger.debug(taskId + " 查询Q38数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q38Service.getExportFileName(), q38Service.getQDataTable(q38Data),"Q38");
        flag = false;
        List<Q39Do> q39Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q39数据");
                q39Data = q39Service.getQData(queryMonth);
                list.add(q39Service.getQDataTable(q39Data));
                logger.debug(taskId + " 查询Q39数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q39Service.getExportFileName(), q39Service.getQDataTable(q39Data),"Q39");
        flag = false;
        List<Q40Do> q40Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q40数据");
                q40Data = q40Service.getQData(queryMonth);
                list.add(q40Service.getQDataTable(q40Data));
                logger.debug(taskId + " 查询Q40数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q40Service.getExportFileName(), q40Service.getQDataTable(q40Data),"Q40");
        flag = false;
        List<Q41Do> q41Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q41数据");
                q41Data = q41Service.getQData(queryMonth);
                list.add(q41Service.getQDataTable(q41Data));
                logger.debug(taskId + " 查询Q41数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q41Service.getExportFileName(), q41Service.getQDataTable(q41Data),"Q41");
        flag = false;
        List<Q42Do> q42Data = null;
        while(!flag) {
            taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始查询Q42数据");
                q42Data = q42Service.getQData(queryMonth);
                list.add(q42Service.getQDataTable(q42Data));
                logger.debug(taskId + " 查询Q42数据完成");
                flag = true;
            }catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q42Service.getExportFileName(), q42Service.getQDataTable(q42Data),"Q42");
        this.saveFile(this.getQExportFileName(), list, "AllQ季报");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getAllMFile(Date queryMonth) {
        String taskId = "";
        logger.debug(taskId + "开始导出全部月报数据");
        boolean flag = false;
        List<WorkTableData> list = new ArrayList<>();
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

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ23File(Date queryMonth) {
        boolean flag = false;
        List<Q23Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q23数据");
                logger.debug(taskId + " 开始查询Q23数据");
                qData =  q23Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q23数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q23Service.getExportFileName(), q23Service.getQDataTable(qData), "Q23");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ24File(Date queryMonth) {
        boolean flag = false;
        List<Q24Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q24数据");
                logger.debug(taskId + " 开始查询Q24数据");
                qData =  q24Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q24数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q24Service.getExportFileName(), q24Service.getQDataTable(qData), "Q24");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ25File(Date queryMonth) {
        boolean flag = false;
        List<Q25Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q25数据");
                logger.debug(taskId + " 开始查询Q25数据");
                qData =  q25Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q25数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q25Service.getExportFileName(), q25Service.getQDataTable(qData), "Q25");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ26File(Date queryMonth) {
        boolean flag = false;
        List<Q26Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q26数据");
                logger.debug(taskId + " 开始查询Q26数据");
                qData =  q26Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q26数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q26Service.getExportFileName(), q26Service.getQDataTable(qData), "Q26");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ27File(Date queryMonth) {
        boolean flag = false;
        List<Q27Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q27数据");
                logger.debug(taskId + " 开始查询Q27数据");
                qData =  q27Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q27数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q27Service.getExportFileName(), q27Service.getQDataTable(qData), "Q27");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ28File(Date queryMonth) {
        boolean flag = false;
        List<Q28Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q28数据");
                logger.debug(taskId + " 开始查询Q28数据");
                qData =  q28Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q28数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q28Service.getExportFileName(), q28Service.getQDataTable(qData), "Q28");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ29File(Date queryMonth) {
        boolean flag = false;
        List<Q29Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q29数据");
                logger.debug(taskId + " 开始查询Q29数据");
                qData =  q29Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q29数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q29Service.getExportFileName(), q29Service.getQDataTable(qData), "Q29");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ30File(Date queryMonth) {
        boolean flag = false;
        List<Q30Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q30数据");
                logger.debug(taskId + " 开始查询Q30数据");
                qData =  q30Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q30数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q30Service.getExportFileName(), q30Service.getQDataTable(qData), "Q30");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ31File(Date queryMonth) {
        boolean flag = false;
        List<Q31Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q31数据");
                logger.debug(taskId + " 开始查询Q31数据");
                qData =  q31Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q31数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q31Service.getExportFileName(), q31Service.getQDataTable(qData), "Q31");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ32File(Date queryMonth) {
        boolean flag = false;
        List<Q32Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q32数据");
                logger.debug(taskId + " 开始查询Q32数据");
                qData =  q32Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q32数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q32Service.getExportFileName(), q32Service.getQDataTable(qData), "Q32");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ33File(Date queryMonth) {
        boolean flag = false;
        List<Q33Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q33数据");
                logger.debug(taskId + " 开始查询Q33数据");
                qData =  q33Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q33数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q33Service.getExportFileName(), q33Service.getQDataTable(qData), "Q33");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ34File(Date queryMonth) {
        boolean flag = false;
        List<Q34Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q34数据");
                logger.debug(taskId + " 开始查询Q34数据");
                qData =  q34Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q34数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q34Service.getExportFileName(), q34Service.getQDataTable(qData), "Q34");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ35File(Date queryMonth) {
        boolean flag = false;
        List<Q35Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q35数据");
                logger.debug(taskId + " 开始查询Q35数据");
                qData =  q35Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q35数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q35Service.getExportFileName(), q35Service.getQDataTable(qData), "Q35");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ36File(Date queryMonth) {
        boolean flag = false;
        List<Q36Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q36数据");
                logger.debug(taskId + " 开始查询Q36数据");
                qData =  q36Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q36数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q36Service.getExportFileName(), q36Service.getQDataTable(qData), "Q36");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ37File(Date queryMonth) {
        boolean flag = false;
        List<Q37Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q37数据");
                logger.debug(taskId + " 开始查询Q37数据");
                qData =  q37Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q37数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q37Service.getExportFileName(), q37Service.getQDataTable(qData), "Q37");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ38File(Date queryMonth) {
        boolean flag = false;
        List<Q38Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q38数据");
                logger.debug(taskId + " 开始查询Q38数据");
                qData =  q38Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q38数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q38Service.getExportFileName(), q38Service.getQDataTable(qData), "Q38");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ39File(Date queryMonth) {
        boolean flag = false;
        List<Q39Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q39数据");
                logger.debug(taskId + " 开始查询Q39数据");
                qData =  q39Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q39数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q39Service.getExportFileName(), q39Service.getQDataTable(qData), "Q39");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ40File(Date queryMonth) {
        boolean flag = false;
        List<Q40Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q40数据");
                logger.debug(taskId + " 开始查询Q40数据");
                qData =  q40Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q40数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q40Service.getExportFileName(), q40Service.getQDataTable(qData), "Q40");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ41File(Date queryMonth) {
        boolean flag = false;
        List<Q41Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q41数据");
                logger.debug(taskId + " 开始查询Q41数据");
                qData =  q41Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q41数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q41Service.getExportFileName(), q41Service.getQDataTable(qData), "Q41");
    }

    @Async(DHConstant.TASK_EXECUTOR)
    public void getQ42File(Date queryMonth) {
        boolean flag = false;
        List<Q42Do> qData = null;
        while(!flag) {
            String taskId = CommonTool.UUID().replace("-", "");
            try {
                logger.debug(taskId + " 开始导出Q42数据");
                logger.debug(taskId + " 开始查询Q42数据");
                qData =  q42Service.getQData(queryMonth);
                logger.debug(taskId + " 查询Q42数据完成");
                flag = true;
            } catch (Exception e) {
                logger.debug(ExceptionTool.getStackTrace(e));
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException ignored) {
                }
            }
        }
        this.saveFile(q42Service.getExportFileName(), q42Service.getQDataTable(qData), "Q42");
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
