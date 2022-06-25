package com.yuansong.dailyHelper.features.mqreport.q02.repository;

import java.math.BigDecimal;

public class Q02Do {

    private String insuAdmdvs;
    private String empType;
    private BigDecimal empClctStd;
    private BigDecimal psnClctStd;
    private BigDecimal empClctAmt;
    private BigDecimal psnClctAmt;
    private BigDecimal empClctIntoAcctAmt;
    private BigDecimal empClctIntoRetrAcctAmt;


    public String getInsuAdmdvs() {
        return insuAdmdvs;
    }

    public void setInsuAdmdvs(String insuAdmdvs) {
        this.insuAdmdvs = insuAdmdvs;
    }

    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }

    public BigDecimal getEmpClctStd() {
        return empClctStd;
    }

    public void setEmpClctStd(BigDecimal empClctStd) {
        this.empClctStd = empClctStd;
    }

    public BigDecimal getPsnClctStd() {
        return psnClctStd;
    }

    public void setPsnClctStd(BigDecimal psnClctStd) {
        this.psnClctStd = psnClctStd;
    }

    public BigDecimal getEmpClctAmt() {
        return empClctAmt;
    }

    public void setEmpClctAmt(BigDecimal empClctAmt) {
        this.empClctAmt = empClctAmt;
    }

    public BigDecimal getPsnClctAmt() {
        return psnClctAmt;
    }

    public void setPsnClctAmt(BigDecimal psnClctAmt) {
        this.psnClctAmt = psnClctAmt;
    }

    public BigDecimal getEmpClctIntoAcctAmt() {
        return empClctIntoAcctAmt;
    }

    public void setEmpClctIntoAcctAmt(BigDecimal empClctIntoAcctAmt) {
        this.empClctIntoAcctAmt = empClctIntoAcctAmt;
    }

    public BigDecimal getEmpClctIntoRetrAcctAmt() {
        return empClctIntoRetrAcctAmt;
    }

    public void setEmpClctIntoRetrAcctAmt(BigDecimal empClctIntoRetrAcctAmt) {
        this.empClctIntoRetrAcctAmt = empClctIntoRetrAcctAmt;
    }
}
