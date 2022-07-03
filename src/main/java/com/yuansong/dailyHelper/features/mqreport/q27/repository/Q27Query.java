package com.yuansong.dailyHelper.features.mqreport.q27.repository;

import java.util.Date;

public class Q27Query {

    private Date month;

    private Q27Query() {}

    public static Q27Query builder() {
        return new Q27Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q27Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
