package com.yuansong.dailyHelper.util.tool;

import java.math.BigDecimal;

public class CommonUtil {

    public static BigDecimal addBigDecimal(BigDecimal a, BigDecimal b) {
        if(a == null && b == null) {
            return null;
        }
        if(a == null) {
            return b;
        }
        if(b == null) {
            return a;
        }
        return a.add(b);
    }
}
