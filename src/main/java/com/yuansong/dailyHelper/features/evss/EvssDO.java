package com.yuansong.dailyHelper.features.evss;

public class EvssDO {

    private String fixBlngAdmdvs; // 行政区划编码
    private String fixmedinsCode; // 定点医药机构编码
    private String fixmedinsName; // 定点医药机构名称
    private Integer totalRc;        //结算总人次

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
}
