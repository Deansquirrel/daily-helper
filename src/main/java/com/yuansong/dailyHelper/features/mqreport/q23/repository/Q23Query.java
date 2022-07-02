package com.yuansong.dailyHelper.features.mqreport.q23.repository;

import java.util.Date;

public class Q23Query {

    private Date month;

    private Q23Query() {}

    public static Q23Query builder() {
        return new Q23Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q23Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
