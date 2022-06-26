package com.yuansong.dailyHelper.features.mqreport.q10.repository;

import java.util.Date;

public class Q10Query {

    private Date month;

    private Q10Query() {}

    public static Q10Query builder() {
        return new Q10Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q10Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
