package com.yuansong.dailyHelper.features.mqreport.q20.repository;

import java.math.BigDecimal;

public class Q20Do {

    private String insuAdmdvs;
    private String psnType;
    private BigDecimal medfeeSumamt;
    private BigDecimal hifpPay;
    private BigDecimal hifmiPay;
    private BigDecimal otherPay;
    private BigDecimal ziFu;
    private BigDecimal ziFei;
    private BigDecimal acctPay;
    private BigDecimal muLuWai;
    private Long tCount;

    public String getInsuAdmdvs() {
        return insuAdmdvs;
    }

    public void setInsuAdmdvs(String insuAdmdvs) {
        this.insuAdmdvs = insuAdmdvs;
    }

    public String getPsnType() {
        return psnType;
    }

    public void setPsnType(String psnType) {
        this.psnType = psnType;
    }

    public BigDecimal getMedfeeSumamt() {
        return medfeeSumamt;
    }

    public void setMedfeeSumamt(BigDecimal medfeeSumamt) {
        this.medfeeSumamt = medfeeSumamt;
    }

    public BigDecimal getHifpPay() {
        return hifpPay;
    }

    public void setHifpPay(BigDecimal hifpPay) {
        this.hifpPay = hifpPay;
    }

    public BigDecimal getHifmiPay() {
        return hifmiPay;
    }

    public void setHifmiPay(BigDecimal hifmiPay) {
        this.hifmiPay = hifmiPay;
    }

    public BigDecimal getOtherPay() {
        return otherPay;
    }

    public void setOtherPay(BigDecimal otherPay) {
        this.otherPay = otherPay;
    }

    public BigDecimal getZiFu() {
        return ziFu;
    }

    public void setZiFu(BigDecimal ziFu) {
        this.ziFu = ziFu;
    }

    public BigDecimal getZiFei() {
        return ziFei;
    }

    public void setZiFei(BigDecimal ziFei) {
        this.ziFei = ziFei;
    }

    public BigDecimal getAcctPay() {
        return acctPay;
    }

    public void setAcctPay(BigDecimal acctPay) {
        this.acctPay = acctPay;
    }

    public BigDecimal getMuLuWai() {
        return muLuWai;
    }

    public void setMuLuWai(BigDecimal muLuWai) {
        this.muLuWai = muLuWai;
    }

    public Long gettCount() {
        return tCount;
    }

    public void settCount(Long tCount) {
        this.tCount = tCount;
    }
}
