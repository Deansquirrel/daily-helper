package com.yuansong.dailyHelper.features.mqreport.m04.repository;

import java.util.Date;

public class M04Query {

    private Date month;

    private M04Query() {}

    public static M04Query builder() {
        return new M04Query();
    }

    public Date getMonth() {
        return month;
    }

    public M04Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
