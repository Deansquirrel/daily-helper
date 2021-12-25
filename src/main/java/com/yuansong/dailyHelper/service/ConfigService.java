package com.yuansong.dailyHelper.service;

import com.github.deansquirrel.tools.common.ExceptionTool;
import com.github.deansquirrel.tools.db.IToolsDbHelper;
import com.github.deansquirrel.tools.db.MySqlConnHelper;
import com.github.deansquirrel.tools.secret.SimpleOne;
import com.sun.istack.internal.NotNull;
import com.yuansong.dailyHelper.features.evss.EvssConstant;
import com.yuansong.dailyHelper.global.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ConfigService {

    private static final Logger logger = LoggerFactory.getLogger(ConfigService.class);

    private final IToolsDbHelper iToolsDbHelper;

    public ConfigService(IToolsDbHelper iToolsDbHelper) {
        this.iToolsDbHelper = iToolsDbHelper;
    }

    public boolean loadMySQL(@NotNull String connName, @NotNull String connStr) {
        if("".equals(connName)) {
            logger.warn("{} conn is empty;",connName);
            return false;
        }
        String[] configList;
        try{
            configList = SimpleOne.DecryptFromBase64Format(connStr, Constant.DB_CONN_KEY).split("\\|");
        }catch (Exception e) {
            logger.warn(ExceptionTool.getStackTrace(e));
            return false;
        }
        if(configList.length < 5) {
            logger.warn("[{}]配置异常, exp 5 act {}",connName, configList.length);
            return false;
        }
        int port;
        try{
            port = Integer.parseInt(configList[1]);
        } catch (NumberFormatException e) {
            logger.warn(ExceptionTool.getStackTrace(e));
            return false;
        }
        MySqlConnHelper jm = MySqlConnHelper.builder(EvssConstant.DB_CONN_JM)
            .setServer(configList[0])
            .setPort(port)
            .setDbName(configList[2])
            .setUserName(configList[3])
            .setPassword(configList[4]);
        iToolsDbHelper.addDataSource(jm.getName(),jm.getDataSource(10, 5));
        return true;
    }

}
