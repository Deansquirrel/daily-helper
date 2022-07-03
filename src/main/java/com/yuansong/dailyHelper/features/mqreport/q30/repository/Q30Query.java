package com.yuansong.dailyHelper.features.mqreport.q30.repository;

import java.util.Date;

public class Q30Query {

    private Date month;

    private Q30Query() {}

    public static Q30Query builder() {
        return new Q30Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q30Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
