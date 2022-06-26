package com.yuansong.dailyHelper.features.mqreport.q12.repository;

import java.util.Date;

public class Q12Query {

    private Date month;

    private Q12Query() {}

    public static Q12Query builder() {
        return new Q12Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q12Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
