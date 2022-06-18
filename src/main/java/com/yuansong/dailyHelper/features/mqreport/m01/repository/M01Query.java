package com.yuansong.dailyHelper.features.mqreport.m01.repository;

import java.util.Date;

public class M01Query {

    private Date month;

    private M01Query() {}

    public static M01Query builder() {
        return new M01Query();
    }

    public Date getMonth() {
        return month;
    }

    public M01Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
