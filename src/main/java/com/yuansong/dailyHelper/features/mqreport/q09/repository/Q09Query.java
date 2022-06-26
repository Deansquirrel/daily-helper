package com.yuansong.dailyHelper.features.mqreport.q09.repository;

import java.util.Date;

public class Q09Query {

    private Date month;

    private Q09Query() {}

    public static Q09Query builder() {
        return new Q09Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q09Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
