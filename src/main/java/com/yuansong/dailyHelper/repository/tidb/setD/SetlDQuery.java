package com.yuansong.dailyHelper.repository.tidb.setD;

public class SetlDQuery {
    private String setlId;
    private String mdtrtId;

    private SetlDQuery(){}

    public static SetlDQuery builder(){return new SetlDQuery();}

    public String getSetlId() {
        return setlId;
    }

    public SetlDQuery setSetlId(String setlId) {
        this.setlId = setlId;
        return this;
    }

    public String getMdtrtId() {
        return mdtrtId;
    }

    public SetlDQuery setMdtrtId(String mdtrtId) {
        this.mdtrtId = mdtrtId;
        return this;
    }
}
