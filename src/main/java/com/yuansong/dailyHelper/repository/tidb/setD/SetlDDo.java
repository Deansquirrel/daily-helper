package com.yuansong.dailyHelper.repository.tidb.setD;

import java.math.BigDecimal;
import java.util.Date;

public class SetlDDo {
    private String setlId;
    private String clrOptions;
    private String mdtrtId;
    private String initSetlId;
    private String fixmedinsCode;
    private String fixmedinsName;
    private Date setlTime;
    private BigDecimal medfeeSumamt;

    //    FIXMEDINS_CODE	varchar	30		True	False		定点医药机构编号
//    FIXMEDINS_NAME	varchar	200		True	False		定点医药机构名称
//    SETL_TIME	datetime			True	False		结算时间
//    MEDFEE_SUMAMT	decimal	16	2	True	False		医疗费总额

    public String getSetlId() {
        return setlId;
    }

    public void setSetlId(String setlId) {
        this.setlId = setlId;
    }

    public String getClrOptions() {
        return clrOptions;
    }

    public void setClrOptions(String clrOptions) {
        this.clrOptions = clrOptions;
    }

    public String getMdtrtId() {
        return mdtrtId;
    }

    public void setMdtrtId(String mdtrtId) {
        this.mdtrtId = mdtrtId;
    }

    public String getInitSetlId() {
        return initSetlId;
    }

    public void setInitSetlId(String initSetlId) {
        this.initSetlId = initSetlId;
    }

    public String getFixmedinsCode() {
        return fixmedinsCode;
    }

    public void setFixmedinsCode(String fixmedinsCode) {
        this.fixmedinsCode = fixmedinsCode;
    }

    public String getFixmedinsName() {
        return fixmedinsName;
    }

    public void setFixmedinsName(String fixmedinsName) {
        this.fixmedinsName = fixmedinsName;
    }

    public Date getSetlTime() {
        return setlTime;
    }

    public void setSetlTime(Date setlTime) {
        this.setlTime = setlTime;
    }

    public BigDecimal getMedfeeSumamt() {
        return medfeeSumamt;
    }

    public void setMedfeeSumamt(BigDecimal medfeeSumamt) {
        this.medfeeSumamt = medfeeSumamt;
    }

    //    SETL_ID	varchar	30		True	False	结算ID
//    CLR_OPTINS	varchar	6		True	False		清算经办机构
//    MDTRT_ID	varchar	30		True	False		就诊ID
//    INIT_SETL_ID	varchar	30		False	False		原结算ID
//    PSN_NO	varchar	30		True	False	人员编号
//    PSN_INSU_RLTS_ID	varchar	20		False	False		人员参保关系ID
//    PSN_NAME	varchar	50		True	False		人员姓名
//    PSN_CERT_TYPE	varchar	6		True	False		人员证件类型
//    CERTNO	varchar	50		True	False		证件号码
//    INSUTYPE	varchar	6		False	False		险种类型
//    FIXMEDINS_CODE	varchar	30		True	False		定点医药机构编号
//    FIXMEDINS_NAME	varchar	200		True	False		定点医药机构名称
//    SETL_TIME	datetime			True	False		结算时间
//    MEDFEE_SUMAMT	decimal	16	2	True	False		医疗费总额

}
