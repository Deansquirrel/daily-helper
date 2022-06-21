package com.yuansong.dailyHelper.features.mqreport.m08.repository;

import java.util.Date;

public class M08Query {

    private Date month;

    private M08Query() {}

    public static M08Query builder() {
        return new M08Query();
    }

    public Date getMonth() {
        return month;
    }

    public M08Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
