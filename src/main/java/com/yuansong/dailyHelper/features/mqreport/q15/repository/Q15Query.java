package com.yuansong.dailyHelper.features.mqreport.q15.repository;

import java.util.Date;

public class Q15Query {

    private Date month;

    private Q15Query() {}

    public static Q15Query builder() {
        return new Q15Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q15Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
