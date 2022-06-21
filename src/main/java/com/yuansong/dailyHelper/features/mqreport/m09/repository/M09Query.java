package com.yuansong.dailyHelper.features.mqreport.m09.repository;

import java.util.Date;

public class M09Query {

    private Date month;

    private M09Query() {}

    public static M09Query builder() {
        return new M09Query();
    }

    public Date getMonth() {
        return month;
    }

    public M09Query setMonth(Date month) {
        this.month = month;
        return this;
    }
}
