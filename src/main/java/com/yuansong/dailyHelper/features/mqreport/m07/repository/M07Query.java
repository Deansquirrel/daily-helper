package com.yuansong.dailyHelper.features.mqreport.m07.repository;

import java.util.Date;

public class M07Query {

    private Date month;

    private M07Query() {}

    public static M07Query builder() {
        return new M07Query();
    }

    public Date getMonth() {
        return month;
    }

    public M07Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
