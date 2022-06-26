package com.yuansong.dailyHelper.features.mqreport.q06.repository;

import java.math.BigDecimal;

public class Q06Do {

    private String insuAdmdvs;
    private String psnType;
    private BigDecimal medfeeSumamt;
    private BigDecimal hifpPay;
    private BigDecimal otherPay;
    private BigDecimal ziFu;
    private BigDecimal selfPay;
    private BigDecimal acctPay;
    private BigDecimal fulamtOwnpayAmt;
    private Long tCount;

    public Q06Do() {
    }

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

    public BigDecimal getOtherPay() {
        return otherPay;
    }

    public void setOtherPay(BigDecimal otherPay) {
        this.otherPay = otherPay;
    }

    public BigDecimal getSelfPay() {
        return selfPay;
    }

    public void setSelfPay(BigDecimal selfPay) {
        this.selfPay = selfPay;
    }

    public BigDecimal getZiFu() {
        return ziFu;
    }

    public void setZiFu(BigDecimal ziFu) {
        this.ziFu = ziFu;
    }

    public BigDecimal getFulamtOwnpayAmt() {
        return fulamtOwnpayAmt;
    }

    public void setFulamtOwnpayAmt(BigDecimal fulamtOwnpayAmt) {
        this.fulamtOwnpayAmt = fulamtOwnpayAmt;
    }

    public Long gettCount() {
        return tCount;
    }

    public void settCount(Long tCount) {
        this.tCount = tCount;
    }

    public BigDecimal getAcctPay() {
        return acctPay;
    }

    public void setAcctPay(BigDecimal acctPay) {
        this.acctPay = acctPay;
    }
}
