package com.yuansong.dailyHelper.features.evss;

import com.github.deansquirrel.tools.db.IToolsDbHelper;
import com.github.deansquirrel.tools.db.MySqlConnHelper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EvssDbConfig implements CommandLineRunner {

    private final IToolsDbHelper iToolsDbHelper;

    public EvssDbConfig(IToolsDbHelper iToolsDbHelper) {
        this.iToolsDbHelper = iToolsDbHelper;
    }

    @Override
    public void run(String... args) throws Exception {
        MySqlConnHelper zg = MySqlConnHelper.builder(EvssConstant.DB_CONN_ZG)
                .setServer("remotemysql.com,3306")
                .setDbName("LKqfry9MiU")
                .setUserName("LKqfry9MiU")
                .setPassword("iQBFdqvYmW");
        iToolsDbHelper.addDataSource(zg.getName(),zg.getDataSource(3600, 5));
        MySqlConnHelper jm = MySqlConnHelper.builder(EvssConstant.DB_CONN_JM)
                .setServer("remotemysql.com,3306")
                .setDbName("LKqfry9MiU")
                .setUserName("LKqfry9MiU")
                .setPassword("iQBFdqvYmW");
        iToolsDbHelper.addDataSource(jm.getName(),jm.getDataSource(3600, 5));
    }
}
