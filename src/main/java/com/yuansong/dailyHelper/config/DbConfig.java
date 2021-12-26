package com.yuansong.dailyHelper.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "db-config")
public class DbConfig {

    private String ywDbPath;
    private String zlDbPath;
    private String configDbPath;

    public String getYwDbPath() {
        return ywDbPath;
    }

    public void setYwDbPath(String ywDbPath) {
        this.ywDbPath = ywDbPath;
    }

    public String getZlDbPath() {
        return zlDbPath;
    }

    public void setZlDbPath(String zlDbPath) {
        this.zlDbPath = zlDbPath;
    }

    public String getConfigDbPath() {
        return configDbPath;
    }

    public void setConfigDbPath(String configDbPath) {
        this.configDbPath = configDbPath;
    }
}
