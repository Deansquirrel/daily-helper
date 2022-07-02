package com.yuansong.dailyHelper.features.mqreport.q25.repository;

import java.util.Date;

public class Q25Query {

    private Date month;

    private Q25Query() {}

    public static Q25Query builder() {
        return new Q25Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q25Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
