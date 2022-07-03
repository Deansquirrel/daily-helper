package com.yuansong.dailyHelper.util.tool;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommonUtil {

    public static boolean isExistColumn(ResultSet rs, String columnName) {
        try {
            if(rs.findColumn(columnName) > 0) {
                return true;
            }
        } catch (SQLException e) {
            return false;
        }
        return false;
    }

    public static Long addLong(Long a, Long b) {
        if(a == null && b == null) {
            return null;
        }
        if(a == null) {
            return b;
        }
        if(b == null) {
            return a;
        }
        return a + b;
    }

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
