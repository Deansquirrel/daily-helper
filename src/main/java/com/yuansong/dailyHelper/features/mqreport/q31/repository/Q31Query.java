package com.yuansong.dailyHelper.features.mqreport.q31.repository;

import java.util.Date;

public class Q31Query {

    private Date month;

    private Q31Query() {}

    public static Q31Query builder() {
        return new Q31Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q31Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
