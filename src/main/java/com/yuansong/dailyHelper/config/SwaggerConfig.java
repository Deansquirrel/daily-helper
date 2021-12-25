package com.yuansong.dailyHelper.config;

import com.github.deansquirrel.tools.swagger.ISwaggerConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig implements ISwaggerConfig {
    @Override
    public Boolean getEnable() {
        return true;
    }

    @Override
    public String getTitle() {
        return "Daily Helper";
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public String getVersion() {
        return "0.0.0";
    }

    @Override
    public String getBasePackage() {
        return "com.yuansong.dailyHelper.api";
    }
}
