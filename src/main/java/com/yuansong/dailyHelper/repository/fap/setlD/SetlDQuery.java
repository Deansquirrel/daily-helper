package com.yuansong.dailyHelper.repository.fap.setlD;

import java.util.Date;

public class SetlDQuery {
    private String setlId;
    private Date setlTimeBeg;
    private Date setlTimeEnd;
    private String fixmedinsCode;
    private String fixmedinsCodeLike;

    private SetlDQuery() {}

    public static SetlDQuery builder() {
        return new SetlDQuery();
    }

    public SetlDQuery setSetlId(String setlId) {
        this.setlId = setlId;
        return this;
    }

    public SetlDQuery setSetlTimeBeg(Date setlTimeBeg) {
        this.setlTimeBeg = setlTimeBeg;
        return this;
    }

    public SetlDQuery setSetlTimeEnd(Date setlTimeEnd) {
        this.setlTimeEnd = setlTimeEnd;
        return this;
    }

    public SetlDQuery setFixmedinsCode(String fixmedinsCode) {
        this.fixmedinsCode = fixmedinsCode;
        return this;
    }

    public SetlDQuery setFixmedinsCodeLike(String fixmedinsCodeLike) {
        this.fixmedinsCodeLike = fixmedinsCodeLike;
        return this;
    }

    public String getSetlId() {
        return setlId;
    }

    public Date getSetlTimeBeg() {
        return setlTimeBeg;
    }

    public Date getSetlTimeEnd() {
        return setlTimeEnd;
    }

    public String getFixmedinsCode() {
        return fixmedinsCode;
    }

    public String getFixmedinsCodeLike() {
        return fixmedinsCodeLike;
    }
}
