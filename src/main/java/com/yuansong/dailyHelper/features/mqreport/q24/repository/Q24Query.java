package com.yuansong.dailyHelper.features.mqreport.q24.repository;

import java.util.Date;

public class Q24Query {

    private Date month;

    private Q24Query() {}

    public static Q24Query builder() {
        return new Q24Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q24Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
