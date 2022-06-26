package com.yuansong.dailyHelper.features.mqreport.q06.repository;

import java.util.Date;

public class Q06Query {

    private Date month;

    private Q06Query() {}

    public static Q06Query builder() {
        return new Q06Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q06Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
