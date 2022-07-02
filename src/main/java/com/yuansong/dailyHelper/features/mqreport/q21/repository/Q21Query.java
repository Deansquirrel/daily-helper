package com.yuansong.dailyHelper.features.mqreport.q21.repository;

import java.util.Date;

public class Q21Query {

    private Date month;

    private Q21Query() {}

    public static Q21Query builder() {
        return new Q21Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q21Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
