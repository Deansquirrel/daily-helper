package com.yuansong.dailyHelper.features.mqreport.q37.repository;

import com.yuansong.dailyHelper.util.tool.CommonUtil;

import java.math.BigDecimal;

public class Q37Do implements Comparable<Q37Do> {

    private String insuAdmdvs;  //区划
    private String empType;     //单位分类
    private BigDecimal a01;     //计划生育金额
    private Long a02;           //计划生育人次
    private BigDecimal b01;     //流产金额
    private Long b02;           //流产人次
    private BigDecimal c01;     //生育金额
    private Long c02;           //生育人次
    private BigDecimal d01;     //顺产金额
    private Long d02;           //顺产人次
    private BigDecimal e01;     //生育津贴金额
    private Long e02;           //生育津贴人次
    private Long f01;           //本期享受待遇女性-人次
    private Long f02;           //本期享受待遇女性-人数

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

    public BigDecimal getA01() {
        return a01;
    }

    public void setA01(BigDecimal a01) {
        this.a01 = a01;
    }

    public Long getA02() {
        return a02;
    }

    public void setA02(Long a02) {
        this.a02 = a02;
    }

    public BigDecimal getB01() {
        return b01;
    }

    public void setB01(BigDecimal b01) {
        this.b01 = b01;
    }

    public Long getB02() {
        return b02;
    }

    public void setB02(Long b02) {
        this.b02 = b02;
    }

    public BigDecimal getC01() {
        return c01;
    }

    public void setC01(BigDecimal c01) {
        this.c01 = c01;
    }

    public Long getC02() {
        return c02;
    }

    public void setC02(Long c02) {
        this.c02 = c02;
    }

    public BigDecimal getD01() {
        return d01;
    }

    public void setD01(BigDecimal d01) {
        this.d01 = d01;
    }

    public Long getD02() {
        return d02;
    }

    public void setD02(Long d02) {
        this.d02 = d02;
    }

    public BigDecimal getE01() {
        return e01;
    }

    public void setE01(BigDecimal e01) {
        this.e01 = e01;
    }

    public Long getE02() {
        return e02;
    }

    public void setE02(Long e02) {
        this.e02 = e02;
    }

    public Long getF01() {
        return f01;
    }

    public void setF01(Long f01) {
        this.f01 = f01;
    }

    public Long getF02() {
        return f02;
    }

    public void setF02(Long f02) {
        this.f02 = f02;
    }

    public Q37Do add(Q37Do d) {
        if(d != null) {
            this.a01 = CommonUtil.addBigDecimal(this.a01, d.a01);
            this.a02 = CommonUtil.addLong(this.a02, d.a02);
            this.b01 = CommonUtil.addBigDecimal(this.b01, d.b01);
            this.b02 = CommonUtil.addLong(this.b02, d.b02);
            this.c01 = CommonUtil.addBigDecimal(this.c01, d.c01);
            this.c02 = CommonUtil.addLong(this.c02, d.c02);
            this.d01 = CommonUtil.addBigDecimal(this.d01, d.d01);
            this.d02 = CommonUtil.addLong(this.d02, d.d02);
            this.e01 = CommonUtil.addBigDecimal(this.e01, d.e01);
            this.e02 = CommonUtil.addLong(this.e02, d.e02);
            this.f01 = CommonUtil.addLong(this.f01, d.f01);
            this.f02 = CommonUtil.addLong(this.f02, d.f02);
        }
        return this;
    }

    @Override
    public int compareTo(Q37Do o) {
        return (this.insuAdmdvs + "-" + this.empType).compareTo(o.insuAdmdvs + "-" + o.empType);
    }
}
