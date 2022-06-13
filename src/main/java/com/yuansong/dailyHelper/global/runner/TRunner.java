package com.yuansong.dailyHelper.global.runner;

import com.yuansong.dailyHelper.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(TRunner.class);

    private final AppConfig appConfig;

    public TRunner(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.debug("========================= TRunner Begin =================================");
        logger.info("Build timestamp " + appConfig.getTimestamp());
        logger.debug("========================== TRunner ======================================");
        logger.debug("========================== TRunner End ==================================");
    }
}
