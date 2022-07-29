package com.yuansong.dailyHelper.features.common.c0001.repository;

import java.math.BigDecimal;

public class C0001Do {

    private String clrOptins;
    private String fixmedinsCode;
    private String fixmedinsName;
    private String insuType;
    private String clrYm;
    private BigDecimal dpstSumamt;
    private BigDecimal actDfrAmt;

    public String getClrOptins() {
        return clrOptins;
    }

    public void setClrOptins(String clrOptins) {
        this.clrOptins = clrOptins;
    }

    public String getFixmedinsCode() {
        return fixmedinsCode;
    }

    public void setFixmedinsCode(String fixmedinsCode) {
        this.fixmedinsCode = fixmedinsCode;
    }

    public String getInsuType() {
        return insuType;
    }

    public void setInsuType(String insuType) {
        this.insuType = insuType;
    }

    public String getClrYm() {
        return clrYm;
    }

    public void setClrYm(String clrYm) {
        this.clrYm = clrYm;
    }

    public BigDecimal getDpstSumamt() {
        return dpstSumamt;
    }

    public void setDpstSumamt(BigDecimal dpstSumamt) {
        this.dpstSumamt = dpstSumamt;
    }

    public BigDecimal getActDfrAmt() {
        return actDfrAmt;
    }

    public void setActDfrAmt(BigDecimal actDfrAmt) {
        this.actDfrAmt = actDfrAmt;
    }

    public String getFixmedinsName() {
        return fixmedinsName;
    }

    public void setFixmedinsName(String fixmedinsName) {
        this.fixmedinsName = fixmedinsName;
    }
}
