package com.yuansong.dailyHelper.features.mqreport.q20.repository;

import java.util.Date;

public class Q20Query {

    private Date month;

    private Q20Query() {}

    public static Q20Query builder() {
        return new Q20Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q20Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
