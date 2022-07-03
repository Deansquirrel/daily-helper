package com.yuansong.dailyHelper.features.mqreport.q29.repository;

import java.util.Date;

public class Q29Query {

    private Date month;

    private Q29Query() {}

    public static Q29Query builder() {
        return new Q29Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q29Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
