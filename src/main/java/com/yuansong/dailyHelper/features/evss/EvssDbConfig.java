package com.yuansong.dailyHelper.features.evss;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "evss-db")
public class EvssDbConfig {

    private String zgConnStr;
    private String jmConnStr;

    public String getZgConnStr() {
        return zgConnStr;
    }

    public void setZgConnStr(String zgConnStr) {
        this.zgConnStr = zgConnStr;
    }

    public String getJmConnStr() {
        return jmConnStr;
    }

    public void setJmConnStr(String jmConnStr) {
        this.jmConnStr = jmConnStr;
    }
}
