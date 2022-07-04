package com.yuansong.dailyHelper.features.mqreport.q40.repository;

import java.util.Date;

public class Q40Query {

    private Date month;

    private Q40Query() {}

    public static Q40Query builder() {
        return new Q40Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q40Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
