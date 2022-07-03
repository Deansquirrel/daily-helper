package com.yuansong.dailyHelper.features.mqreport.q34.repository;

import java.util.Date;

public class Q34Query {

    private Date month;

    private Q34Query() {}

    public static Q34Query builder() {
        return new Q34Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q34Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
