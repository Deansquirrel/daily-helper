package com.yuansong.dailyHelper.features.mqreport.q36.repository;

import java.util.Date;

public class Q36Query {

    private Date month;

    private Q36Query() {}

    public static Q36Query builder() {
        return new Q36Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q36Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
