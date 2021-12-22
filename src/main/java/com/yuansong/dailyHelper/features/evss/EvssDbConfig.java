package com.yuansong.dailyHelper.features.evss;

import com.github.deansquirrel.tools.db.IToolsDbHelper;
import com.github.deansquirrel.tools.db.MySqlConnHelper;
import com.github.deansquirrel.tools.secret.SimpleOne;
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
        String connStr = "EQMZGDO4rI4SF7povQ9z0l1u3x4TAxsaEQEcHxQAHRwVQk5ET0VPQV1GX0UNU0VHXAEYGxNKY2RRV1hSGn9Bf157Z19AQFISb1h9VUphb2tDRV5zT2c=";

        String[] configList = SimpleOne.DecryptFromBase64Format(connStr, "1233211234567").split("\\|");
        System.out.println(SimpleOne.DecryptFromBase64Format(connStr, "1233211234567"));
        System.out.println(configList.length);
        if(configList.length > 0) {
            MySqlConnHelper zg = MySqlConnHelper.builder(EvssConstant.DB_CONN_ZG)
                    .setServer(configList[0])
                    .setPort(Integer.valueOf(configList[1]))
                    .setDbName(configList[2])
                    .setUserName(configList[3])
                    .setPassword(configList[4]);
            iToolsDbHelper.addDataSource(zg.getName(),zg.getDataSource(3600, 5));
            MySqlConnHelper jm = MySqlConnHelper.builder(EvssConstant.DB_CONN_JM)
                    .setServer(configList[0])
                    .setPort(Integer.valueOf(configList[1]))
                    .setDbName(configList[2])
                    .setUserName(configList[3])
                    .setPassword(configList[4]);
            iToolsDbHelper.addDataSource(zg.getName(),jm.getDataSource(3600, 5));
        }
//        MySqlConnHelper zg = MySqlConnHelper.builder(EvssConstant.DB_CONN_ZG)
//                .setServer("remotemysql.com,3306")
//                .setDbName("LKqfry9MiU")
//                .setUserName("LKqfry9MiU")
//                .setPassword("iQBFdqvYmW");
//        iToolsDbHelper.addDataSource(zg.getName(),zg.getDataSource(3600, 5));
//        MySqlConnHelper jm = MySqlConnHelper.builder(EvssConstant.DB_CONN_JM)
//                .setServer("remotemysql.com,3306")
//                .setDbName("LKqfry9MiU")
//                .setUserName("LKqfry9MiU")
//                .setPassword("iQBFdqvYmW");
//        iToolsDbHelper.addDataSource(jm.getName(),jm.getDataSource(3600, 5));
    }
}
