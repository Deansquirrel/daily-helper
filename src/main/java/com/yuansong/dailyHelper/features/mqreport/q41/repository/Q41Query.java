package com.yuansong.dailyHelper.features.mqreport.q41.repository;

import java.util.Date;

public class Q41Query {

    private Date month;

    private Q41Query() {}

    public static Q41Query builder() {
        return new Q41Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q41Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
