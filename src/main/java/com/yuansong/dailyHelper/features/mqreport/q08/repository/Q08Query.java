package com.yuansong.dailyHelper.features.mqreport.q08.repository;

import java.util.Date;

public class Q08Query {

    private Date month;

    private Q08Query() {}

    public static Q08Query builder() {
        return new Q08Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q08Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
