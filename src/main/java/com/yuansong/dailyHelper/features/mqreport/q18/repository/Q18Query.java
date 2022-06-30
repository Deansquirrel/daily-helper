package com.yuansong.dailyHelper.features.mqreport.q18.repository;

import java.util.Date;

public class Q18Query {

    private Date month;

    private Q18Query() {}

    public static Q18Query builder() {
        return new Q18Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q18Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
