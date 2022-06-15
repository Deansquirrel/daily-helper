package com.yuansong.dailyHelper.global.runner;

import com.github.deansquirrel.tools.common.ExceptionTool;
import com.github.deansquirrel.tools.db.MySqlLoadHelper;
import com.yuansong.dailyHelper.config.ConnConfig;
import com.yuansong.dailyHelper.global.DHConstant;
import com.yuansong.dailyHelper.service.secret.ISecretService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
public class DbInitRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DbInitRunner.class);

    private final ConnConfig connConfig;
    private final MySqlLoadHelper mySqlLoadHelper;
    private final ISecretService secretService;

    public DbInitRunner(ConnConfig connConfig, MySqlLoadHelper mySqlLoadHelper, ISecretService secretService) {
        this.connConfig = connConfig;
        this.mySqlLoadHelper = mySqlLoadHelper;
        this.secretService = secretService;
    }

//    private final IDbCheckService dbCheckService;
//    private final DbConfig dbConfig;
//    private final SQLiteLoadHelper sqLiteLoadHelper;
//
//    public DbInitRunner(IDbCheckService dbCheckService, DbConfig dbConfig, SQLiteLoadHelper sqLiteLoadHelper) {
//        this.dbCheckService = dbCheckService;
//        this.dbConfig = dbConfig;
//        this.sqLiteLoadHelper = sqLiteLoadHelper;
//    }

    @Override
    public void run(String... args) throws Exception {
        logger.debug("========================= TRunner Begin =================================");
        addMySQLConn(DHConstant.DB_CONN_STR_TIDB_ONE, connConfig.getTidbOne());
        addMySQLConn(DHConstant.DB_CONN_STR_TIDB_TWO, connConfig.getTidbTwo());
        logger.debug("========================= TRunner End ===================================");
    }

    private void addMySQLConn(String connName, String connStr) {
        try {
            mySqlLoadHelper.addMySQLConn(connName, secretService.decrypt(connStr));
        } catch (Exception e) {
            logger.error(MessageFormat.format("加载数据配置【{0}】时遇到错误",connName));
            logger.error(ExceptionTool.getStackTrace(e));
        }
    }
}
