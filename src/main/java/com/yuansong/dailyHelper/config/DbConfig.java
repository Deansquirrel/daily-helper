package com.yuansong.dailyHelper.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "db")
public class DbConfig {

    private String mwm;

    public String getMwm() {
        return mwm;
    }

    public void setMwm(String mwm) {
        this.mwm = mwm;
    }
}
