package com.yuansong.tools.controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.deansquirrel.tools.common.SQLTool;
import com.github.deansquirrel.tools.db.*;
import com.yuansong.dailyHelper.common.Response;
import com.yuansong.dailyHelper.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
@Api(tags={"tools-db"})
@RequestMapping(value = "/db")
public class DbController {
    private static final Logger logger = LoggerFactory.getLogger(DbController.class);

    private final IToolsDbHelper iToolsDbHelper;
    private final JdbcTemplate jdbcTemplate;
    private final DynamicRoutingDataSource dynamicRoutingDataSource;

    public DbController(IToolsDbHelper iToolsDbHelper,
                        @Qualifier(Constant.BEAN_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate,
                        @Qualifier(value = Constant.DYNAMIC_ROUTEING_DATASOURCE) DynamicRoutingDataSource dynamicRoutingDataSource) {
        this.iToolsDbHelper = iToolsDbHelper;
        this.jdbcTemplate = jdbcTemplate;
        this.dynamicRoutingDataSource = dynamicRoutingDataSource;
    }

//    @ApiOperation(value="mysql连接")
//    @RequestMapping(value="/mysql/conn",method = RequestMethod.GET)
//    public ResponseResult<String> mySqlConn() {
//
//        MySqlConnHelper mySqlConnHelper = MySqlConnHelper.builder("test")
//                .setServer("remotemysql.com,3306")
//                .setDbName("LKqfry9MiU")
//                .setUserName("LKqfry9MiU")
//                .setPassword("iQBFdqvYmW");
//
//        DruidDataSource dataSource = mySqlConnHelper.getDataSource(58,null);
//        logger.debug(dataSource.getName());
//        logger.debug(String.valueOf(dataSource.getQueryTimeout()));
//        logger.debug(String.valueOf(dataSource.getMaxActive()));
//        iToolsDbHelper.addDataSource(dataSource.getName(), dataSource);
//        dynamicRoutingDataSource.setDataSourceKey(mySqlConnHelper.getName());
//
//        List<String> nameList = this.jdbcTemplate.query("select `name` from TbStudent;", new RowMapper<String>() {
//            @Override
//            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
//                return SQLTool.getString(rs, "name");
//            }
//        });
//        dynamicRoutingDataSource.remove();
//        dynamicRoutingDataSource.removeDataSource(mySqlConnHelper.getName());
//        if(nameList.size() <= 0) {
//            logger.warn("list is empty");
//        } else {
//            for(String stuName : nameList) {
//                logger.debug(stuName);
//            }
//        }
//
//        return Response.makeOKResp();
//    }    @ApiOperation(value="mysql连接")
//    @RequestMapping(value="/mysql/conn",method = RequestMethod.GET)
//    public ResponseResult<String> mySqlConn() {
//
//        MySqlConnHelper mySqlConnHelper = MySqlConnHelper.builder("test")
//                .setServer("remotemysql.com,3306")
//                .setDbName("LKqfry9MiU")
//                .setUserName("LKqfry9MiU")
//                .setPassword("iQBFdqvYmW");
//
//        DruidDataSource dataSource = mySqlConnHelper.getDataSource(58,null);
//        logger.debug(dataSource.getName());
//        logger.debug(String.valueOf(dataSource.getQueryTimeout()));
//        logger.debug(String.valueOf(dataSource.getMaxActive()));
//        iToolsDbHelper.addDataSource(dataSource.getName(), dataSource);
//        dynamicRoutingDataSource.setDataSourceKey(mySqlConnHelper.getName());
//
//        List<String> nameList = this.jdbcTemplate.query("select `name` from TbStudent;", new RowMapper<String>() {
//            @Override
//            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
//                return SQLTool.getString(rs, "name");
//            }
//        });
//        dynamicRoutingDataSource.remove();
//        dynamicRoutingDataSource.removeDataSource(mySqlConnHelper.getName());
//        if(nameList.size() <= 0) {
//            logger.warn("list is empty");
//        } else {
//            for(String stuName : nameList) {
//                logger.debug(stuName);
//            }
//        }
//
//        return Response.makeOKResp();
//    }

    @ApiOperation(value="sqlite连接")
    @RequestMapping(value="/sqlite/conn",method = RequestMethod.GET)
    public ResponseResult<String> sqliteConn() {
        String connName = "sqlite-test";
        SQLiteConnHelper sqLiteConnHelper = SQLiteConnHelper.builder(connName)
                .setPath("123.db");
        DruidDataSource dataSource = sqLiteConnHelper.getDataSource();
        logger.debug(String.valueOf(dataSource.getQueryTimeout()));
        logger.debug(String.valueOf(dataSource.getMaxActive()));
        iToolsDbHelper.addDataSource(dataSource.getName(), dataSource);
        iToolsDbHelper.setDataSourceKey(connName);

        jdbcTemplate.update("CREATE TABLE IF NOT EXISTS t_user(uid integer primary key,uname varchar(20),mobile varchar(20))");

        dynamicRoutingDataSource.remove();
        dynamicRoutingDataSource.removeDataSource(connName);

        return Response.makeOKResp();
    }
}
