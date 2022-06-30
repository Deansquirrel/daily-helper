package com.yuansong.dailyHelper.features.mqreport.q16.repository;

import java.util.Date;

public class Q16Query {

    private Date month;

    private Q16Query() {}

    public static Q16Query builder() {
        return new Q16Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q16Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
