package com.yuansong.dailyHelper.featuresH;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FeatureDbLoader implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(FeatureDbLoader.class);

//    private final FeatureConfig featureConfig;
//    private final DbLoaderHelper dbLoaderHelper;

//    public FeatureDbLoader(FeatureConfig featureConfig, DbLoaderHelper dbLoaderHelper) {
//        this.featureConfig = featureConfig;
//        this.dbLoaderHelper = dbLoaderHelper;
//    }

    @Override
    public void run(String... args) throws Exception {
//        FeatureDbConfig dbConfig = featureConfig.getDb();
//        if(dbConfig != null) {
//            if(dbConfig.getZgFapConnStr() == null || "".equals(dbConfig.getZgFapConnStr())){
//                logger.warn("ignore {} conn", Constant.DB_FAP_ZG);
//            } else {
//                dbLoaderHelper.addMySQLConn(Constant.DB_FAP_ZG, featureConfig.getDb().getZgFapConnStr());
//            }
//            if(dbConfig.getJmFapConnStr() == null || "".equals(dbConfig.getJmFapConnStr())) {
//                logger.warn("ignore {} conn", Constant.DB_FAP_JM);
//            } else {
//                dbLoaderHelper.addMySQLConn(Constant.DB_FAP_JM, featureConfig.getDb().getJmFapConnStr());
//            }
//        }


    }

}
