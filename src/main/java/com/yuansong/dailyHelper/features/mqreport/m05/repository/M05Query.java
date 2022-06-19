package com.yuansong.dailyHelper.features.mqreport.m05.repository;

import java.util.Date;

public class M05Query {

    private Date month;

    private M05Query() {}

    public static M05Query builder() {
        return new M05Query();
    }

    public Date getMonth() {
        return month;
    }

    public M05Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
