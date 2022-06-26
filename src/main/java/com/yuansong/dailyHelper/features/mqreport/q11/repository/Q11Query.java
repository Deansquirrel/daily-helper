package com.yuansong.dailyHelper.features.mqreport.q11.repository;

import java.util.Date;

public class Q11Query {

    private Date month;

    private Q11Query() {}

    public static Q11Query builder() {
        return new Q11Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q11Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
