package com.yuansong.dailyHelper.config;

import com.github.deansquirrel.tools.swagger.ISwaggerConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig implements ISwaggerConfig {

    private final AppConfig appConfig;

    public SwaggerConfig(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @Override
    public Boolean getEnable() {
        return appConfig.isSwagger();
    }

    @Override
    public String getTitle() {
        return "DailyHelper";
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public String getVersion() {
        return appConfig.getVersion();
    }

    @Override
    public String getBasePackage() {
        return "com.yuansong.dailyHelper.controller";
    }
}
