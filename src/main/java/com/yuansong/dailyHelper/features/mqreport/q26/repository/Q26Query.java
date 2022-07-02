package com.yuansong.dailyHelper.features.mqreport.q26.repository;

import java.util.Date;

public class Q26Query {

    private Date month;

    private Q26Query() {}

    public static Q26Query builder() {
        return new Q26Query();
    }

    public Date getMonth() {
        return month;
    }

    public Q26Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
