package com.yuansong.dailyHelper.features.evss;

import com.github.deansquirrel.tools.common.ExceptionTool;
import com.github.deansquirrel.tools.db.IToolsDbHelper;
import com.github.deansquirrel.tools.db.MySqlConnHelper;
import com.github.deansquirrel.tools.secret.SimpleOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EvssDbConfig implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(EvssDbConfig.class);

    private final IToolsDbHelper iToolsDbHelper;

    public EvssDbConfig(IToolsDbHelper iToolsDbHelper) {
        this.iToolsDbHelper = iToolsDbHelper;
    }

    @Override
    public void run(String... args) throws Exception {
        String connStr = "EQMZGDO4rI4SF7povQ9z0l1u3x4TAxsaEQEcHxQAHRwVQk5ET0VPQV1GX0UNU0VHXAEYGxNKY2RRV1hSGn9Bf157Z19AQFISb1h9VUphb2tDRV5zT2c=";

        String[] configList;
        try{
            configList = SimpleOne.DecryptFromBase64Format(connStr, EvssConstant.DB_CONN_KEY).split("\\|");
        }catch (Exception e) {
            logger.warn(ExceptionTool.getStackTrace(e));
            return;
        }
        if(configList.length < 5) {
            logger.warn("配置异常, exp 5 act {}",configList.length);
            return;
        }

//        System.out.println(SimpleOne.DecryptFromBase64Format(connStr, EvssConstant.DB_CONN_KEY));
//        System.out.println(configList.length);

        int port;
        try{
            port = Integer.parseInt(configList[1]);
        } catch (NumberFormatException e) {
            logger.warn(ExceptionTool.getStackTrace(e));
            return;
        }
        MySqlConnHelper zg = MySqlConnHelper.builder(EvssConstant.DB_CONN_ZG)
                .setServer(configList[0])
//                .setPort(13306)
                .setDbName(configList[2])
                .setUserName(configList[3])
                .setPassword(configList[4]);
        iToolsDbHelper.addDataSource(zg.getName(),zg.getDataSource(10, 5));
        logger.debug("url {}",zg.getDataSource().getUrl());
        MySqlConnHelper jm = MySqlConnHelper.builder(EvssConstant.DB_CONN_JM)
                .setServer(configList[0])
//                .setPort(port)
                .setDbName(configList[2])
                .setUserName(configList[3])
                .setPassword(configList[4]);
        iToolsDbHelper.addDataSource(jm.getName(),jm.getDataSource(10, 5));
        logger.debug("url {}",jm.getDataSource().getUrl());
    }
}
