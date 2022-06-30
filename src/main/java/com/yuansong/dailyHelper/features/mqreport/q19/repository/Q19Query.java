package com.yuansong.dailyHelper.features.mqreport.q19.repository;

import java.util.Date;

public class Q19Query {

    private Date month;

    private Q19Query() {}

    public static Q19Query builder() {
        return new Q19Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q19Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
