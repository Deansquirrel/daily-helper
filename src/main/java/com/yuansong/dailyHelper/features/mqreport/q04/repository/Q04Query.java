package com.yuansong.dailyHelper.features.mqreport.q04.repository;

import java.util.Date;

public class Q04Query {

    private Date month;

    private Q04Query() {}

    public static Q04Query builder() {
        return new Q04Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q04Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
