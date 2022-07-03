package com.yuansong.dailyHelper.features.mqreport.q31.repository;

import java.math.BigDecimal;

public class Q31Do {

    private String insuAdmdvs;
    private String setlType;
    private Long renShu;
    private Long renCi;
    private BigDecimal medfeeSumamt;
    private BigDecimal hifpPay;
    private BigDecimal otherPay;
    private BigDecimal ziFu;
    private BigDecimal ziFei;

    public String getInsuAdmdvs() {
        return insuAdmdvs;
    }

    public void setInsuAdmdvs(String insuAdmdvs) {
        this.insuAdmdvs = insuAdmdvs;
    }

    public String getSetlType() {
        return setlType;
    }

    public void setSetlType(String setlType) {
        this.setlType = setlType;
    }

    public Long getRenShu() {
        return renShu;
    }

    public void setRenShu(Long renShu) {
        this.renShu = renShu;
    }

    public Long getRenCi() {
        return renCi;
    }

    public void setRenCi(Long renCi) {
        this.renCi = renCi;
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
}
