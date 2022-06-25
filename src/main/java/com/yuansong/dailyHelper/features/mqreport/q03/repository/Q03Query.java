package com.yuansong.dailyHelper.features.mqreport.q03.repository;

import java.util.Date;

public class Q03Query {

    private Date month;

    private Q03Query() {}

    public static Q03Query builder() {
        return new Q03Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q03Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
