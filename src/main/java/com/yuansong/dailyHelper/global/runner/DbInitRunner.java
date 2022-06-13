package com.yuansong.dailyHelper.global.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbInitRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DbInitRunner.class);

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
        logger.debug("========================= TRunner End ===================================");
//        sqLiteLoadHelper.addSQLiteConn(DConstant.DB_MWM_CONN_NAME, dbConfig.getMwm());
//        if(!dbCheckService.checkVersion()) {
//            throw new Exception("check db mwm version error");
//        }
//        logger.debug("db mwm OK");
    }
}
