package com.yuansong.dailyHelper.features.mqreport.q01.repository;

public class Q01Do {

    private String insuAdmdvs;
    private String empType;
    private Long empCount;
    private Long psnCount;
    private Long retrCount;
    private Long retrFemaleCount;
    private Long femaleCount;

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

    public Long getEmpCount() {
        return empCount;
    }

    public void setEmpCount(Long empCount) {
        this.empCount = empCount;
    }

    public Long getPsnCount() {
        return psnCount;
    }

    public void setPsnCount(Long psnCount) {
        this.psnCount = psnCount;
    }

    public Long getRetrCount() {
        return retrCount;
    }

    public void setRetrCount(Long retrCount) {
        this.retrCount = retrCount;
    }

    public Long getRetrFemaleCount() {
        return retrFemaleCount;
    }

    public void setRetrFemaleCount(Long retrFemaleCount) {
        this.retrFemaleCount = retrFemaleCount;
    }

    public Long getFemaleCount() {
        return femaleCount;
    }

    public void setFemaleCount(Long femaleCount) {
        this.femaleCount = femaleCount;
    }
}
