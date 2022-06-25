package com.yuansong.dailyHelper.features.mqreport.q02.repository;

import java.util.Date;

public class Q02Query {

    private Date month;

    private Q02Query() {}

    public static Q02Query builder() {
        return new Q02Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q02Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
