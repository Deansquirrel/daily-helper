package com.yuansong.dailyHelper.global.runner;

import com.github.deansquirrel.tools.db.IToolsDbHelper;
import com.yuansong.dailyHelper.config.AppConfig;
import com.yuansong.dailyHelper.repository.IRepTiDbOne;
import com.yuansong.dailyHelper.util.tool.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(TRunner.class);

    private final AppConfig appConfig;

    private final IRepTiDbOne repTiDbOne;

    private final IToolsDbHelper toolsDbHelper;

    public TRunner(AppConfig appConfig, IRepTiDbOne repTiDbOne, IToolsDbHelper toolsDbHelper) {
        this.appConfig = appConfig;
        this.repTiDbOne = repTiDbOne;
        this.toolsDbHelper = toolsDbHelper;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.debug("========================= TRunner Begin =================================");
        logger.info("Build timestamp " + appConfig.getTimestamp());
        logger.debug("========================== TRunner ======================================");
        logger.debug(FileUtil.getCurrPath());
//        List<SetlDDo> list = repTiDbOne.getSetlDList(null);
//        logger.debug(MessageFormat.format("总记录数 {0}",list.size()));
//        for(SetlDDo d:list) {
//            System.out.println(MessageFormat.format("{0}-{1}-{2}-{3}-{4}",
//                            DateTool.GetDateTimeStr(d.getSetlTime()),
//                    d.getFixmedinsCode(),
//                    d.getFixmedinsName(),
//                    d.getSetlId(),
//                    d.getMedfeeSumamt()
//                    ));
//        }

        logger.debug("========================== TRunner End ==================================");
    }
}
