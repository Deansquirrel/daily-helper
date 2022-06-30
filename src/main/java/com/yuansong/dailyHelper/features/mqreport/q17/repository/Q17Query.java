package com.yuansong.dailyHelper.features.mqreport.q17.repository;

import java.util.Date;

public class Q17Query {

    private Date month;

    private Q17Query() {}

    public static Q17Query builder() {
        return new Q17Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q17Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
