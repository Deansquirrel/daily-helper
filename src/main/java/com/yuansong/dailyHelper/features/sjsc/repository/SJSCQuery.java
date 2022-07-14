package com.yuansong.dailyHelper.features.sjsc.repository;

public class SJSCQuery {

    private String begDate;
    private String endDate;

    private SJSCQuery(){}

    public static SJSCQuery builder() {
        return new SJSCQuery();
    }

    public String getBegDate() {
        return begDate;
    }

    public SJSCQuery setBegDate(String begDate) {
        this.begDate = begDate;
        return this;
    }

    public String getEndDate() {
        return endDate;
    }

    public SJSCQuery setEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }
}
