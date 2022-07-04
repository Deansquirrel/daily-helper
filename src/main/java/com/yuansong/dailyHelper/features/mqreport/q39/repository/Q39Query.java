package com.yuansong.dailyHelper.features.mqreport.q39.repository;

import java.util.Date;

public class Q39Query {

    private Date month;

    private Q39Query() {}

    public static Q39Query builder() {
        return new Q39Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q39Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
