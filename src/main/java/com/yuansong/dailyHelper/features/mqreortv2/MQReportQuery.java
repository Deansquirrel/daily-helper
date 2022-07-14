package com.yuansong.dailyHelper.features.mqreortv2;

import java.util.Calendar;
import java.util.Date;

public class MQReportQuery {

    private Date month;
    public MQReportQuery() {};

    public static MQReportQuery builder(){
        return new MQReportQuery();
    }

    public Date getMonth() {
        return month;
    }

    public MQReportQuery setMonth(Date month) {
        this.month = month;
        return this;
    }

    public static Date getDefaultQueryMonth() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                1,0,0,0);
        cal.add(Calendar.MONTH, -1);
        return cal.getTime();
    }

}
