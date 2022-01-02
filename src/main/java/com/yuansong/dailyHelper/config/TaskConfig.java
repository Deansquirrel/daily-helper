package com.yuansong.dailyHelper.config;

import com.github.deansquirrel.tools.task.ITaskConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskConfig implements ITaskConfig {
    @Override
    public String getDbPath() {
        return "db/task";
    }
}
