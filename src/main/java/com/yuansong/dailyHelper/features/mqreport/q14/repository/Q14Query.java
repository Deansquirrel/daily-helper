package com.yuansong.dailyHelper.features.mqreport.q14.repository;

import java.util.Date;

public class Q14Query {

    private Date month;

    private Q14Query() {}

    public static Q14Query builder() {
        return new Q14Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q14Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
