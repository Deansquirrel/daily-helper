package com.yuansong.dailyHelper.features.mqreport.q35.repository;

import java.util.Date;

public class Q35Query {

    private Date month;

    private Q35Query() {}

    public static Q35Query builder() {
        return new Q35Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q35Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
