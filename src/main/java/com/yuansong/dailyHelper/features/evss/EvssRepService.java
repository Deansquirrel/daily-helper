package com.yuansong.dailyHelper.features.evss;

import com.github.deansquirrel.tools.common.DateTool;
import com.github.deansquirrel.tools.db.TargetSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
public class EvssRepService {

    private static final Logger logger = LoggerFactory.getLogger(EvssRepService.class);

    private final EvssRep evssRep;

    public EvssRepService(EvssRep evssRep) {
        this.evssRep = evssRep;
    }

    @TargetSource(EvssConstant.DB_CONN_ZG)
    public List<EvssDO> getZgList() {
        return evssRep.getList(getEndDate());
    }

    @TargetSource(EvssConstant.DB_CONN_JM)
    public List<EvssDO> getJmList() {
        return evssRep.getList(getEndDate());
    }

    private Date getEndDate() {
        TimeZone currTimeZone = TimeZone.getTimeZone("GMT+8");
        Calendar cal = Calendar.getInstance(currTimeZone);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
}
