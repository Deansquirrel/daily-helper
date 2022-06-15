package com.yuansong.dailyHelper.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "conn")
public class ConnConfig {

    private String tidbOne;
    private String tidbTwo;


    public String getTidbOne() {
        return tidbOne;
    }

    public void setTidbOne(String tidbOne) {
        this.tidbOne = tidbOne;
    }

    public String getTidbTwo() {
        return tidbTwo;
    }

    public void setTidbTwo(String tidbTwo) {
        this.tidbTwo = tidbTwo;
    }
}
