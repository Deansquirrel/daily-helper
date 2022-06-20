package com.yuansong.dailyHelper.features.mqreport.m06.repository;

import java.util.Date;

public class M06Query {

    private Date month;

    private M06Query() {}

    public static M06Query builder() {
        return new M06Query();
    }

    public Date getMonth() {
        return month;
    }

    public M06Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
