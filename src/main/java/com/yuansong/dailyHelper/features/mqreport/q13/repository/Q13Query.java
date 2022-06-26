package com.yuansong.dailyHelper.features.mqreport.q13.repository;

import java.util.Date;

public class Q13Query {

    private Date month;

    private Q13Query() {}

    public static Q13Query builder() {
        return new Q13Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q13Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
