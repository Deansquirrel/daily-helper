package com.yuansong.dailyHelper.features.mqreport.q37.repository;

import java.util.Date;

public class Q37Query {

    private Date month;

    private Q37Query() {}

    public static Q37Query builder() {
        return new Q37Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q37Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
