package com.yuansong.dailyHelper.features.mqreport.q18.repository;

import java.math.BigDecimal;

public class Q18Do implements Comparable<Q18Do> {

//    INSU_ADMDVS,PSN_TYPE,MDTRT_ID,SETL_ID,药品目录内,药品目录外,项目目录内,项目目录外,服务设施目录内,服务设施目录外

    private String insuAdmdvs;
    private BigDecimal a01;
    private BigDecimal a02;
    private BigDecimal b01;
    private BigDecimal b02;
    private BigDecimal c01;
    private BigDecimal c02;

    public String getInsuAdmdvs() {
        return insuAdmdvs;
    }

    public void setInsuAdmdvs(String insuAdmdvs) {
        this.insuAdmdvs = insuAdmdvs;
    }

    public BigDecimal getA01() {
        return a01;
    }

    public void setA01(BigDecimal a01) {
        this.a01 = a01;
    }

    public BigDecimal getA02() {
        return a02;
    }

    public void setA02(BigDecimal a02) {
        this.a02 = a02;
    }

    public BigDecimal getB01() {
        return b01;
    }

    public void setB01(BigDecimal b01) {
        this.b01 = b01;
    }

    public BigDecimal getB02() {
        return b02;
    }

    public void setB02(BigDecimal b02) {
        this.b02 = b02;
    }

    public BigDecimal getC01() {
        return c01;
    }

    public void setC01(BigDecimal c01) {
        this.c01 = c01;
    }

    public BigDecimal getC02() {
        return c02;
    }

    public void setC02(BigDecimal c02) {
        this.c02 = c02;
    }

    public Q18Do add(Q18Do d) {

        this.a01 = this.a01.add(d.a01);
        this.a02 = this.a02.add(d.a02);
        this.b01 = this.b01.add(d.b01);
        this.b02 = this.b02.add(d.b02);
        this.c01 = this.c01.add(d.c01);
        this.c02 = this.c02.add(d.c02);
        return this;
    }
    
    @Override
    public int compareTo(Q18Do o) {
        return this.getInsuAdmdvs().compareTo(o.getInsuAdmdvs());
    }
}
