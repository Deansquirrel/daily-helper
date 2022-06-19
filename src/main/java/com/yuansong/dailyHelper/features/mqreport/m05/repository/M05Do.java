package com.yuansong.dailyHelper.features.mqreport.m05.repository;

public class M05Do {

    private String insuAdmdvs;
    private Long A01;       //生育-女性参保人数
    private Long B01;       //生育-本期享受待遇人次（结算+生育津贴）
    private Long C01;       //生育-本期享受待遇-女性-人次（结算）
    private Long C02;       //生育-本期享受待遇-女性-人数（结算）
    private Long D01;       //生育-计划生育人次

    public String getInsuAdmdvs() {
        return insuAdmdvs;
    }

    public void setInsuAdmdvs(String insuAdmdvs) {
        this.insuAdmdvs = insuAdmdvs;
    }

    public Long getA01() {
        return A01;
    }

    public void setA01(Long a01) {
        A01 = a01;
    }

    public Long getB01() {
        return B01;
    }

    public void setB01(Long b01) {
        B01 = b01;
    }

    public Long getC01() {
        return C01;
    }

    public void setC01(Long c01) {
        C01 = c01;
    }

    public Long getC02() {
        return C02;
    }

    public void setC02(Long c02) {
        C02 = c02;
    }

    public Long getD01() {
        return D01;
    }

    public void setD01(Long d01) {
        D01 = d01;
    }
}
