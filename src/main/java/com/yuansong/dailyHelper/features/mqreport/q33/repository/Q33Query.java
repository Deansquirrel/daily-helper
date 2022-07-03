package com.yuansong.dailyHelper.features.mqreport.q33.repository;

import java.util.Date;

public class Q33Query {

    private Date month;

    private Q33Query() {}

    public static Q33Query builder() {
        return new Q33Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q33Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
