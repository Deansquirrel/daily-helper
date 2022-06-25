package com.yuansong.dailyHelper.features.mqreport.q05.repository;

import java.util.Date;

public class Q05Query {

    private Date month;

    private Q05Query() {}

    public static Q05Query builder() {
        return new Q05Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q05Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
