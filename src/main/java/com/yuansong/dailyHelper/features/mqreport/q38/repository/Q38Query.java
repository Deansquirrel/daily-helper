package com.yuansong.dailyHelper.features.mqreport.q38.repository;

import java.util.Date;

public class Q38Query {

    private Date month;

    private Q38Query() {}

    public static Q38Query builder() {
        return new Q38Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q38Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
