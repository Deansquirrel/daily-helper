package com.yuansong.dailyHelper.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app-config")
public class AppConfig {

    private String version;

    private String mailSenderConfig;

    private String timestamp;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMailSenderConfig() {
        return mailSenderConfig;
    }

    public void setMailSenderConfig(String mailSenderConfig) {
        this.mailSenderConfig = mailSenderConfig;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
