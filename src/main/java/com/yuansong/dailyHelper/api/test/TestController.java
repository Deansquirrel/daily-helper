package com.yuansong.dailyHelper.api.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.deansquirrel.tools.common.DateTool;
import com.github.deansquirrel.tools.common.SQLTool;
import com.github.deansquirrel.tools.db.Constant;
import com.github.deansquirrel.tools.db.IToolsDbHelper;
import com.github.deansquirrel.tools.db.MySqlConnHelper;
import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import com.google.gson.Gson;
import com.yuansong.dailyHelper.api.test.dao.StudentDao;
import com.yuansong.dailyHelper.common.Response;
import com.yuansong.dailyHelper.common.ResponseResult;
import com.yuansong.dailyHelper.config.AppConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@RestController
@Api(tags={"test"})
@RequestMapping(value = "/test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    private final AppConfig appConfig;
    private final IToolsDbHelper iToolsDbHelper;
    private final JdbcTemplate jdbcTemplate;

    public TestController(AppConfig appConfig,
                          IToolsDbHelper iToolsDbHelper,
                          @Qualifier(Constant.BEAN_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.appConfig = appConfig;
        this.iToolsDbHelper = iToolsDbHelper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @ApiOperation(value="subTest")
    @RequestMapping(value="/subtest",method = RequestMethod.GET)
    public ResponseResult<?> subTest() {
        XSSFWorkbook f = this.getTestXSSFWorkbook();
        logger.debug(f == null ? "null" : f.toString());
        return Response.makeOKResp();
    }

    @ApiOperation(value="获取版本")
    @RequestMapping(value="/version",method = RequestMethod.GET)
    public ResponseResult<String> version() {
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
            this.setResponseDownloadExcel(response,fileName, f);
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

        XSSFWorkTable workTable = XSSFWorkTable.builder("First");
        if(nameList.size() <= 0) {
            logger.warn("list is empty");
        } else {
            List<List<Object>> rows = new ArrayList<>();
            for(StudentDao stu : nameList) {
                List<Object> row = new ArrayList<>();
                row.add(stu.getId());
                row.add(stu.getName());
                row.add(stu.getSex());
                row.add(stu.getBirth());
                row.add(stu.getTel());
                row.add(stu.getAddr());
                rows.add(row);
            }
            workTable.setRows(rows);
        }
        if(workTable.getRows() != null && workTable.getRows().size() > 0) {
            List<String> title = new ArrayList<>();
            title.add("ID");
            title.add("姓名");
            title.add("性别");
            title.add("生日");
            title.add("Tel");
            title.add("Addr");
            workTable.setTitle(title);
        }
        Gson gson = new Gson();
        logger.debug(gson.toJson(workTable));

        List<XSSFWorkTable> list = new ArrayList<>();
        list.add(workTable);

        return XSSFWorkBookTool.getXSSFWorkBook(list);

//        Font font = book.createFont();
//        font.setFontName("Calibri");
//
//        XSSFSheet sheet = book.createSheet("123");
//        Row titleRow = sheet.createRow(0);
//        for(int i = 0; i < eData.getTitle().size(); i++) {
//            Cell cell = titleRow.createCell(i);
//            cell.setCellValue(eData.getTitle().get(i));
//        }
//        for(int i = 0; i < eData.getRows().size(); i++) {
//            Row row = sheet.createRow(i + 1);
//            List<Object> rowsData = eData.getRows().get(i);
//            for(int j = 0; j < rowsData.size(); j++) {
//                Cell cell = row.createCell(j);
//                Object data = rowsData.get(j);
//                if (data instanceof Date) {
//                    Date d = (Date) data;
////                    cell.setCellValue(DateTool.GetDateTimeStr(d));
//                    cell.setCellValue(d);
//                } else {
//                    cell.setCellValue(String.valueOf(data));
//                }
//            }
//        }
//        return book;
    }

    private void setResponseDownloadExcel(HttpServletResponse response, String fileName, XSSFWorkbook book) throws IOException {
        response.setContentType("application/octet-stream;charset=ISO8859-1");
        response.setHeader("Content-Disposition","attachment;filename="
                + new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
        response.addHeader("Pragma", "no-cache");
        response.addHeader("Cache-Control", "no-cache");

        OutputStream os = response.getOutputStream();
        book.write(os);
        os.flush();
        os.close();
    }
}
