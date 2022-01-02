package com.yuansong.dailyHelper.common;

import com.yuansong.dailyHelper.config.DbConfig;
import com.yuansong.dailyHelper.global.Constant;
import com.yuansong.dailyHelper.util.DbLoaderHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbLoader implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DbLoader.class);

    private final DbConfig dbConfig;

    private final DbLoaderHelper dbLoaderHelper;

    public DbLoader(DbConfig dbConfig, DbLoaderHelper dbLoaderHelper) {
        this.dbConfig = dbConfig;
        this.dbLoaderHelper = dbLoaderHelper;
    }

    @Override
    public void run(String... args) throws Exception {
        dbLoaderHelper.addSSQLiteConn(Constant.DB_CONFIG, dbConfig.getConfigDbPath());
        dbLoaderHelper.addSSQLiteConn(Constant.DB_ZL, dbConfig.getZlDbPath());
        dbLoaderHelper.addSSQLiteConn(Constant.DB_YW, dbConfig.getYwDbPath());
    }
}
