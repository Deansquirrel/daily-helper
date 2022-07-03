package com.yuansong.dailyHelper.features.mqreport.q28.repository;

import java.util.Date;

public class Q28Query {

    private Date month;

    private Q28Query() {}

    public static Q28Query builder() {
        return new Q28Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q28Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
