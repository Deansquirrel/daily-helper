package com.yuansong.dailyHelper.features.mqreport.q07.repository;

import java.util.Date;

public class Q07Query {

    private Date month;

    private Q07Query() {}

    public static Q07Query builder() {
        return new Q07Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q07Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
