package com.yuansong.dailyHelper.features.mqreport.m02.repository;

import java.util.Date;

public class M02Query {

    private Date month;

    private M02Query() {}

    public static M02Query builder() {
        return new M02Query();
    }

    public Date getMonth() {
        return month;
    }

    public M02Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
