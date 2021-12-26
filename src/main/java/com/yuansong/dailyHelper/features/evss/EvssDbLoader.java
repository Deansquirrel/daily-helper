package com.yuansong.dailyHelper.features.evss;

import com.yuansong.dailyHelper.features.DbLoaderHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EvssDbLoader implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(EvssDbLoader.class);

    private final EvssDbConfig evssDbConfig;
    private final DbLoaderHelper dbLoaderHelper;

    public EvssDbLoader(EvssDbConfig evssDbConfig, DbLoaderHelper dbLoaderHelper) {
        this.evssDbConfig = evssDbConfig;
        this.dbLoaderHelper = dbLoaderHelper;
    }

    @Override
    public void run(String... args) throws Exception {
        dbLoaderHelper.addMySQLConn(EvssConstant.DB_CONN_ZG, evssDbConfig.getZgConnStr());
        dbLoaderHelper.addMySQLConn(EvssConstant.DB_CONN_JM, evssDbConfig.getJmConnStr());
    }

}
