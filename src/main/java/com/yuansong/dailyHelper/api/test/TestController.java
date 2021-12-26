package com.yuansong.dailyHelper.api.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.deansquirrel.tools.common.DateTool;
import com.github.deansquirrel.tools.common.SQLTool;
import com.github.deansquirrel.tools.db.Constant;
import com.github.deansquirrel.tools.db.IToolsDbHelper;
import com.github.deansquirrel.tools.db.MySqlConnHelper;
import com.github.deansquirrel.tools.poi.IDataMapper;
import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.yuansong.dailyHelper.api.test.dao.StudentDao;
import com.yuansong.dailyHelper.common.Response;
import com.yuansong.dailyHelper.common.ResponseResult;
import com.yuansong.dailyHelper.config.AppConfig;
import com.yuansong.dailyHelper.features.evss.EvssService;
import com.yuansong.dailyHelper.repository.db.config.ConnT;
import com.yuansong.dailyHelper.util.Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@RestController
@Api(tags={"test"})
@RequestMapping(value = "/test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    private final AppConfig appConfig;
    private final IToolsDbHelper iToolsDbHelper;
    private final JdbcTemplate jdbcTemplate;

    private final EvssService evssService;

    @Autowired
    private ConnT connT;

    public TestController(AppConfig appConfig,
                          IToolsDbHelper iToolsDbHelper,
                          @Qualifier(Constant.BEAN_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate, EvssService evssService) {
        this.appConfig = appConfig;
        this.iToolsDbHelper = iToolsDbHelper;
        this.jdbcTemplate = jdbcTemplate;
        this.evssService = evssService;
    }

    @ApiOperation(value="subTest")
    @RequestMapping(value="/subtest",method = RequestMethod.GET)
    public ResponseResult<?> subTest() {
//        XSSFWorkbook f = this.getTestXSSFWorkbook();
//        logger.debug(f == null ? "null" : f.toString());
        logger.debug(appConfig.getTimestamp());
        connT.getTest();
        return Response.makeOKResp();
    }

    @ApiOperation(value="获取版本")
    @RequestMapping(value="/version",method = RequestMethod.GET)
    public ResponseResult<String> version() {
        logger.debug(appConfig.getTimestamp());
        return Response.makeOKStringResp(this.appConfig.getVersion());
    }

    @ApiOperation(value="发送测试邮件（文本）")
    @RequestMapping(value="/sendmail",method = RequestMethod.GET)
    public ResponseResult<?> sendmail() {

        JavaMailSenderImpl jms = new JavaMailSenderImpl();
        jms.setHost("smtp.163.com");
        jms.setPort(465);
        jms.setUsername("yuansong6@163.com");
        jms.setPassword("WHHYMOCUQNPBEVIT");
        jms.setDefaultEncoding("utf-8");
        Properties p = new Properties();
        p.setProperty("mail.smtp.auth","true");
        p.setProperty("mail.smtp.socketFactoryClass","javax.net.ssl.SSLSocketFactory");
        p.setProperty("mail.debug","false");
        p.setProperty("mail.mine.splitlongparameters","false");
        jms.setProtocol("smtps");
        jms.setJavaMailProperties(p);

        SimpleMailMessage message = new SimpleMailMessage();
        // 设置邮件主题
        message.setSubject("AutoMail" + DateTool.GetDateTimeStr()
                .replace("-","")
                .replace(":","")
                .replace(" ", ""));
        // 设置邮件发送者，这个跟application.yml中设置的要一致
        message.setFrom("yuansong6@163.com");
        message.setTo("yuansong6@163.com");
        // 设置邮件发送日期
        message.setSentDate(new Date());
        // 设置邮件的正文
        message.setText(DateTool.GetDateTimeWithMillionSecond());

        // 发送邮件
        jms.send(message);

        return Response.makeOKResp();
    }

    @ApiOperation(value="excel")
    @RequestMapping(value="/excel",method = RequestMethod.GET)
    public void excel(HttpServletResponse response) {
        XSSFWorkbook f = this.getTestXSSFWorkbook();
//        logger.debug(f == null ? "null" : f.toString());
//        return Response.makeOKResp();
        String fileName = DateTool.GetDateTimeWithMillionSecond();
        fileName = fileName.replace(" ","");
        fileName = fileName.replace("-","");
        fileName = fileName.replace(":","");
        fileName = fileName.replace(".","");
        fileName = fileName + ".xlsx";
        try {
            Util.setResponseDownloadExcel(response,fileName, f);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        return Response.makeOKResp();
    }


//    测试发送带附件的邮件
//    测试直接下载excel

//    测试直接获取Excel
    private XSSFWorkbook getTestXSSFWorkbook() {

        MySqlConnHelper mySqlConnHelper = MySqlConnHelper.builder("test")
                .setServer("remotemysql.com,3306")
                .setDbName("LKqfry9MiU")
                .setUserName("LKqfry9MiU")
                .setPassword("iQBFdqvYmW");

        DruidDataSource dataSource = mySqlConnHelper.getDataSource();
        logger.debug(dataSource.getName());
        logger.debug(String.valueOf(dataSource.getQueryTimeout()));
        logger.debug(String.valueOf(dataSource.getMaxActive()));
        iToolsDbHelper.addDataSource(dataSource.getName(), dataSource);
        iToolsDbHelper.setDataSourceKey(mySqlConnHelper.getName());

        List<StudentDao> nameList = this.jdbcTemplate.query("select id,name,sex,birth,tel,addr from TbStudent;", new RowMapper<StudentDao>() {
            @Override
            public StudentDao mapRow(ResultSet rs, int rowNum) throws SQLException {
                StudentDao d = new StudentDao();
                d.setId(SQLTool.getLong(rs, "id"));
                d.setName(SQLTool.getString(rs, "name"));
                d.setSex(SQLTool.getInt(rs, "sex"));
                d.setBirth(SQLTool.getDatetime(rs, "birth"));
                d.setTel(SQLTool.getString(rs,"tel"));
                d.setAddr(SQLTool.getString(rs, "addr"));
                return d;
            }
        });
        iToolsDbHelper.remove();
        iToolsDbHelper.removeDataSource(mySqlConnHelper.getName());
        logger.debug("length {}",nameList.size());
        logger.debug("=========================================================================");

        IDataMapper<StudentDao> iDataMapper = new IDataMapper<StudentDao>() {
            @Override
            public List<String> getTitleList() {
                return Arrays.asList("ID","姓名","性别","生日","Tel","Addr");
            }

            @Override
            public List<Object> getRowData(StudentDao studentDao) {
                List<Object> d = new ArrayList<>();
                d.add(studentDao.getId());
                d.add(studentDao.getName());
                d.add(studentDao.getSex());
                d.add(studentDao.getBirth());
                d.add(studentDao.getTel());
                d.add(studentDao.getAddr());
                return d;
            }
        };

        XSSFWorkTable workTableF = XSSFWorkBookTool.getXSSFWorkTable("First", nameList, iDataMapper);
        XSSFWorkTable workTableS = XSSFWorkBookTool.getXSSFWorkTable("Second", nameList, iDataMapper);

        return XSSFWorkBookTool.getXSSFWorkBook(Arrays.asList(workTableF,workTableS));
//        return XSSFWorkBookTool.getXSSFWorkBook(Collections.singletonList(workTable));
    }

}
