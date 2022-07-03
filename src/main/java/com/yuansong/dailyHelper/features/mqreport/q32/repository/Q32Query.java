package com.yuansong.dailyHelper.features.mqreport.q32.repository;

import java.util.Date;

public class Q32Query {

    private Date month;

    private Q32Query() {}

    public static Q32Query builder() {
        return new Q32Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q32Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
