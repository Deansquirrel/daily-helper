package com.yuansong.dailyHelper.features;

import com.github.deansquirrel.tools.common.ExceptionTool;
import com.github.deansquirrel.tools.db.IToolsDbHelper;
import com.github.deansquirrel.tools.db.MySqlConnHelper;
import com.github.deansquirrel.tools.secret.SimpleOne;
import com.sun.istack.internal.NotNull;
import com.yuansong.dailyHelper.global.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DbLoaderHelper {

    private static final Logger logger = LoggerFactory.getLogger(DbLoaderHelper.class);

    private final IToolsDbHelper iToolsDbHelper;

    public DbLoaderHelper(IToolsDbHelper iToolsDbHelper) {
        this.iToolsDbHelper = iToolsDbHelper;
    }

    public void addMySQLConn(@NotNull String connName,@NotNull String connStr) {
        if("".equals(connStr)) {
            logger.warn("conn[{}] is empty", connName);
            return;
        }
        String[] configList;
        try {
            configList = SimpleOne.DecryptFromBase64Format(connStr, Constant.DB_CONN_KEY)
                    .split("\\|");
        } catch (Exception e) {
            logger.warn("add conn[{}] failed", connName);
            logger.warn(ExceptionTool.getStackTrace(e));
            return;
        }
        if(configList.length < 5) {
            logger.warn("conn[{}]配置异常, exp 5 act {}",connName,configList.length);
            return;
        }
        int port;
        try{
            port = Integer.parseInt(configList[1]);
        } catch (NumberFormatException e) {
            logger.warn("add conn[{}] failed, trans port[{}] error", connName, configList[1]);
            logger.warn(ExceptionTool.getStackTrace(e));
            return;
        }
        MySqlConnHelper conn = MySqlConnHelper.builder(connName)
                .setServer(configList[0])
                .setPort(port)
                .setDbName(configList[2])
                .setUserName(configList[3])
                .setPassword(configList[4]);
        iToolsDbHelper.removeDataSource(conn.getName());
        iToolsDbHelper.addDataSource(conn.getName(), conn.getDataSource());
    }
}
