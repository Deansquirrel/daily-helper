package com.yuansong.dailyHelper.features.evss;

public class EvssDO implements Comparable<EvssDO> {

    private String fixBlngAdmdvs; // 行政区划编码
    private String fixmedinsCode; // 定点医药机构编码
    private String fixmedinsName; // 定点医药机构名称
    private Integer totalRc;        //结算总人次
    private Integer sbkRc;          //社保卡人次
    private Integer dzpzRc;         //电子凭证人次
    private Integer dzpzRs;         //电子凭证人数
    private Integer currTotalRc;
    private Integer currSbkRc;
    private Integer currDzpzRc;
    private Integer currDzpzRs;


    public String getFixBlngAdmdvs() {
        return fixBlngAdmdvs;
    }

    public void setFixBlngAdmdvs(String fixBlngAdmdvs) {
        this.fixBlngAdmdvs = fixBlngAdmdvs;
    }

    public String getFixmedinsCode() {
        return fixmedinsCode;
    }

    public void setFixmedinsCode(String fixmedinsCode) {
        this.fixmedinsCode = fixmedinsCode;
    }

    public String getFixmedinsName() {
        return fixmedinsName;
    }

    public void setFixmedinsName(String fixmedinsName) {
        this.fixmedinsName = fixmedinsName;
    }

    public Integer getTotalRc() {
        return totalRc;
    }

    public void setTotalRc(Integer totalRc) {
        this.totalRc = totalRc;
    }

    public Integer getSbkRc() {
        return sbkRc;
    }

    public void setSbkRc(Integer sbkRc) {
        this.sbkRc = sbkRc;
    }

    public Integer getDzpzRc() {
        return dzpzRc;
    }

    public void setDzpzRc(Integer dzpzRc) {
        this.dzpzRc = dzpzRc;
    }

    public Integer getDzpzRs() {
        return dzpzRs;
    }

    public void setDzpzRs(Integer dzpzRs) {
        this.dzpzRs = dzpzRs;
    }

    public Integer getCurrTotalRc() {
        return currTotalRc;
    }

    public void setCurrTotalRc(Integer currTotalRc) {
        this.currTotalRc = currTotalRc;
    }

    public Integer getCurrSbkRc() {
        return currSbkRc;
    }

    public void setCurrSbkRc(Integer currSbkRc) {
        this.currSbkRc = currSbkRc;
    }

    public Integer getCurrDzpzRc() {
        return currDzpzRc;
    }

    public void setCurrDzpzRc(Integer currDzpzRc) {
        this.currDzpzRc = currDzpzRc;
    }

    public Integer getCurrDzpzRs() {
        return currDzpzRs;
    }

    public void setCurrDzpzRs(Integer currDzpzRs) {
        this.currDzpzRs = currDzpzRs;
    }

    public EvssDO add(EvssDO d) {
        this.totalRc = getNewData(this.totalRc, d.getTotalRc());
        this.sbkRc = getNewData(this.sbkRc, d.getSbkRc());
        this.dzpzRc = getNewData(this.dzpzRc, d.getDzpzRc());
        this.dzpzRs = getNewData(this.dzpzRs, d.getDzpzRs());
        this.currTotalRc = getNewData(this.currTotalRc, d.getCurrTotalRc());
        this.currSbkRc = getNewData(this.currSbkRc, d.getCurrSbkRc());
        this.currDzpzRc = getNewData(this.currDzpzRc, d.getCurrDzpzRc());
        this.currDzpzRs = getNewData(this.currDzpzRs, d.getCurrDzpzRs());
        return this;
    }

    private Integer getNewData(Integer a, Integer b) {
        if(a == null) return b;
        if(b == null) return a;
        return a + b;
    }

    @Override
    public int compareTo(EvssDO o) {
        return this.fixmedinsCode.compareTo(o.getFixmedinsCode());
    }
}
