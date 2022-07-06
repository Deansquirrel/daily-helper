package com.yuansong.dailyHelper.features.mqreport.q42.repository;

import java.util.Date;

public class Q42Query {

    private Date month;

    private Q42Query() {}

    public static Q42Query builder() {
        return new Q42Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q42Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
