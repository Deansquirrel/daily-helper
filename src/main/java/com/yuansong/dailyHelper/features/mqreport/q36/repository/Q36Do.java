package com.yuansong.dailyHelper.features.mqreport.q36.repository;

import com.yuansong.dailyHelper.util.tool.CommonUtil;

import java.math.BigDecimal;

public class Q36Do implements Comparable<Q36Do> {

    private String insuAdmdvs;      //区划
    private Long a01;               //转入农民工合计
    private Long a02;               //转入农民工合计省外
    private Long a03;               //职工医保转入职工医保合计
    private Long a04;               //职工医保转入职工医保省外
    private Long a05;               //职工医保转入居民医保合计
    private Long a06;               //居民医保转入职工医保合计
    private BigDecimal a07;         //转入金额合计
    private Long b01;               //转出合计
    private Long b02;               //转出到省外合计
    private Long b03;               //转出农民工合计
    private Long b04;               //转出农民工省外
    private BigDecimal b05;               //转出地清算给个人合计
    private BigDecimal b06;               //转出地清算给个人省外

    public String getInsuAdmdvs() {
        return insuAdmdvs;
    }

    public void setInsuAdmdvs(String insuAdmdvs) {
        this.insuAdmdvs = insuAdmdvs;
    }

    public Long getA01() {
        return a01;
    }

    public void setA01(Long a01) {
        this.a01 = a01;
    }

    public Long getA02() {
        return a02;
    }

    public void setA02(Long a02) {
        this.a02 = a02;
    }

    public Long getA03() {
        return a03;
    }

    public void setA03(Long a03) {
        this.a03 = a03;
    }

    public Long getA04() {
        return a04;
    }

    public void setA04(Long a04) {
        this.a04 = a04;
    }

    public Long getA05() {
        return a05;
    }

    public void setA05(Long a05) {
        this.a05 = a05;
    }

    public Long getA06() {
        return a06;
    }

    public void setA06(Long a06) {
        this.a06 = a06;
    }

    public BigDecimal getA07() {
        return a07;
    }

    public void setA07(BigDecimal a07) {
        this.a07 = a07;
    }

    public Long getB01() {
        return b01;
    }

    public void setB01(Long b01) {
        this.b01 = b01;
    }

    public Long getB02() {
        return b02;
    }

    public void setB02(Long b02) {
        this.b02 = b02;
    }

    public Long getB03() {
        return b03;
    }

    public void setB03(Long b03) {
        this.b03 = b03;
    }

    public Long getB04() {
        return b04;
    }

    public void setB04(Long b04) {
        this.b04 = b04;
    }

    public BigDecimal getB05() {
        return b05;
    }

    public void setB05(BigDecimal b05) {
        this.b05 = b05;
    }

    public BigDecimal getB06() {
        return b06;
    }

    public void setB06(BigDecimal b06) {
        this.b06 = b06;
    }

    public Q36Do add(Q36Do d) {
        this.a01 = CommonUtil.addLong(this.a01, d.a01);
        this.a02 = CommonUtil.addLong(this.a02, d.a02);
        this.a03 = CommonUtil.addLong(this.a03, d.a03);
        this.a04 = CommonUtil.addLong(this.a04, d.a04);
        this.a05 = CommonUtil.addLong(this.a05, d.a05);
        this.a06 = CommonUtil.addLong(this.a06, d.a06);
        this.a07 = CommonUtil.addBigDecimal(this.a07, d.a07);
        this.b01 = CommonUtil.addLong(this.b01, d.b01);
        this.b02 = CommonUtil.addLong(this.b02, d.b02);
        this.b03 = CommonUtil.addLong(this.b03, d.b03);
        this.b04 = CommonUtil.addLong(this.b04, d.b04);
        this.b05 = CommonUtil.addBigDecimal(this.b05, d.b05);
        this.b06 = CommonUtil.addBigDecimal(this.b06, d.b06);
        return this;
    }

    @Override
    public int compareTo(Q36Do o) {
        return this.insuAdmdvs.compareTo(o.getInsuAdmdvs());
    }
}
