package com.yuansong.dailyHelper.features.mqreport.q01.repository;

import java.util.Date;

public class Q01Query {

    private Date month;

    private Q01Query() {}

    public static Q01Query builder() {
        return new Q01Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q01Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
