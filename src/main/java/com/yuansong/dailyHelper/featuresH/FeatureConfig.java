package com.yuansong.dailyHelper.featuresH;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "feature")
public class FeatureConfig {

    private FeatureDbConfig db;

    public FeatureDbConfig getDb() {
        return db;
    }

    public void setDb(FeatureDbConfig db) {
        this.db = db;
    }
}
