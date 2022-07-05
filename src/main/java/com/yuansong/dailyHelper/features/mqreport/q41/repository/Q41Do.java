package com.yuansong.dailyHelper.features.mqreport.q41.repository;

public class Q41Do implements Comparable<Q41Do> {

    private String medType;
    private String insuAdmdvs;
    private Long psnCount;

    public String getMedType() {
        return medType;
    }

    public void setMedType(String medType) {
        this.medType = medType;
    }

    public String getInsuAdmdvs() {
        return insuAdmdvs;
    }

    public void setInsuAdmdvs(String insuAdmdvs) {
        this.insuAdmdvs = insuAdmdvs;
    }

    public Long getPsnCount() {
        return psnCount;
    }

    public void setPsnCount(Long psnCount) {
        this.psnCount = psnCount;
    }

    @Override
    public int compareTo(Q41Do o) {
        return (this.medType + "-" + this.insuAdmdvs).compareTo(o.medType + "-" + o.insuAdmdvs);
    }
}
