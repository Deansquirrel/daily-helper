package com.yuansong.dailyHelper.features.mqreport.m03.repository;

import java.util.Date;

public class M03Query {

    private Date month;

    private M03Query() {}

    public static M03Query builder() {
        return new M03Query();
    }

    public Date getMonth() {
        return month;
    }

    public M03Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
