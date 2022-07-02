package com.yuansong.dailyHelper.features.mqreport.q22.repository;

import java.util.Date;

public class Q22Query {

    private Date month;

    private Q22Query() {}

    public static Q22Query builder() {
        return new Q22Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q22Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
