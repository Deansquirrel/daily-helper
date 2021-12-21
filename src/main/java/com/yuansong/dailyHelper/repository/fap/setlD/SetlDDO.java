package com.yuansong.dailyHelper.repository.fap.setlD;

import java.util.Date;

public class SetlDDO {

    private String setlId;      // SETL_ID 结算ID
//            `CLR_OPTINS` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
//  `MEDINS_SETL_ID` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '医药机构结算ID',

    private String mdtrtId;    //MDTRT_ID 就诊ID
//            `INIT_SETL_ID` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '原结算ID',
//            `PSN_NO` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '人员编号',
    private String psnNo;
//            `PSN_INSU_RLTS_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '人员参保关系ID',
//            `PSN_NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '人员姓名',
    private String psnName;
//            `PSN_CERT_TYPE` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '人员证件类型',
//            `CERTNO` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '证件号码',
    private String certNo;
//            `GEND` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别',
//            `NATY` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '民族',
//            `BRDY` date NULL DEFAULT NULL COMMENT '出生日期',
//            `AGE` decimal(4, 1) NULL DEFAULT NULL COMMENT '年龄',
//            `INSUTYPE` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '险种类型',
//            `PSN_TYPE` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '人员类别',
//            `CVLSERV_FLAG` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公务员标志',
//            `CVLSERV_LV` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公务员等级',
//            `SP_PSN_TYPE` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '特殊人员类型',
//            `SP_PSN_TYPE_LV` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '特殊人员类型等级',
//            `CLCT_GRDE` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '缴费档次',
//            `FLXEMPE_FLAG` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '灵活就业标志',
//            `NWB_FLAG` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '新生儿标志',
//            `INSU_ADMDVS` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '参保所属医保区划',
//            `EMP_NO` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '单位编号',
//            `EMP_NAME` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '单位名称',
//            `EMP_TYPE` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '单位类型',
//            `ECON_TYPE` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '经济类型',
//            `AFIL_INDU` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '所属行业',
//            `AFIL_RLTS` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '隶属关系',
//            `EMP_MGT_TYPE` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '单位管理类型',
//            `PAY_LOC` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付地点类别',
//            `FIXMEDINS_CODE` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '定点医药机构编号',
    private String fixmedinsCode;
//            `FIXMEDINS_NAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    private String fixmedinsName;
//  `HOSP_LV` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '医院等级',
//            `FIX_BLNG_ADMDVS` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '定点归属医保区划',
//            `LMTPRIC_HOSP_LV` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '限价医院等级',
//            `DEDC_HOSP_LV` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '起付线医院等级',
//            `BEGNDATE` date NOT NULL COMMENT '开始日期',
//            `ENDDATE` date NOT NULL COMMENT '结束日期',
//            `SETL_TIME` datetime NOT NULL COMMENT '结算时间',
    private Date setlTime;
//            `MDTRT_CERT_TYPE` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '就诊凭证类型',
    private String mdtrtCertType;
//            `MDTRT_CERT_NO` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '就诊凭证编号',
//            `MED_TYPE` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '医疗类别',
//            `SETL_TYPE` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '结算类别',
//            `CLR_TYPE` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '清算类别',
//            `CLR_WAY` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '清算方式',
//            `PSN_SETLWAY` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '个人结算方式',
//            `MEDFEE_SUMAMT` decimal(16, 2) NOT NULL DEFAULT 0.00 COMMENT '医疗费总额',
//            `FULAMT_OWNPAY_AMT` decimal(16, 2) NOT NULL DEFAULT 0.00 COMMENT '全自费金额',
//            `OVERLMT_SELFPAY` decimal(16, 2) NOT NULL DEFAULT 0.00 COMMENT '超限价自费费用',
//            `PRESELFPAY_AMT` decimal(16, 2) NOT NULL DEFAULT 0.00 COMMENT '先行自付金额',
//            `INSCP_AMT` decimal(16, 2) NOT NULL DEFAULT 0.00 COMMENT '符合范围金额',
//            `DEDC_STD` decimal(16, 2) NOT NULL DEFAULT 0.00 COMMENT '起付标准',
//            `CRT_DEDC` decimal(16, 2) NOT NULL DEFAULT 0.00 COMMENT '本次起付线',
//            `ACT_PAY_DEDC` decimal(16, 2) NOT NULL DEFAULT 0.00 COMMENT '实际支付起付线',
//            `HIFP_PAY` decimal(16, 2) NOT NULL DEFAULT 0.00 COMMENT '统筹基金支出',
//            `POOL_PROP_SELFPAY` decimal(5, 4) NULL DEFAULT 0.0000 COMMENT '基本医疗统筹支付比例',
//            `HI_AGRE_SUMFEE` decimal(16, 2) NOT NULL DEFAULT 0.00 COMMENT '医保认可费用总额',
//            `CVLSERV_PAY` decimal(16, 2) NOT NULL DEFAULT 0.00 COMMENT '公务员医疗补助资金支出',
//            `HIFES_PAY` decimal(16, 2) NOT NULL DEFAULT 0.00 COMMENT '补充医疗保险基金支出',
//            `HIFMI_PAY` decimal(16, 2) NOT NULL DEFAULT 0.00 COMMENT '大病补充医疗保险基金支出',
//            `HIFOB_PAY` decimal(16, 2) NOT NULL DEFAULT 0.00 COMMENT '大额医疗补助基金支出',
//            `HIFDM_PAY` decimal(16, 2) NOT NULL DEFAULT 0.00 COMMENT '伤残人员医疗保障基金支出',
//            `MAF_PAY` decimal(16, 2) NOT NULL DEFAULT 0.00 COMMENT '医疗救助基金支出',
//            `OTHFUND_PAY` decimal(16, 2) NOT NULL DEFAULT 0.00 COMMENT '其它基金支付',
//            `FUND_PAY_SUMAMT` decimal(16, 2) NOT NULL DEFAULT 0.00 COMMENT '基金支付总额',
//            `PSN_PAY` decimal(16, 2) NOT NULL DEFAULT 0.00 COMMENT '个人支付金额',
//            `ACCT_PAY` decimal(16, 2) NOT NULL DEFAULT 0.00 COMMENT '个人账户支出',
//            `CASH_PAYAMT` decimal(16, 2) NOT NULL DEFAULT 0.00 COMMENT '现金支付金额',
//            `OWNPAY_HOSP_PART` decimal(16, 2) NULL DEFAULT 0.00 COMMENT '自费中医院负担部分',
//            `BALC` decimal(16, 2) NULL DEFAULT 0.00 COMMENT '余额',
//            `ACCT_MULAID_PAY` decimal(16, 2) NULL DEFAULT 0.00 COMMENT '账户共济支付金额',
//            `REFD_SETL_FLAG` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '退费结算标志',
//            `CAL_IPT_CNT` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '计算住院次数标志',
//            `SETL_CASHPAY_WAY` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '结算现金支付方式',
//            `YEAR` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '年度',
//            `DISE_NO` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '病种编号',
//            `DISE_NAME` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '病种名称',
//            `INVONO` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '发票号',
//            `MANL_REIM_REA` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '零星报销原因',
//            `VALI_FLAG` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '有效标志',
//            `MEMO` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
//            `RID` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '数据唯一记录号',
//            `UPDT_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据更新时间',
//            `CRTER_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人ID',
//            `CRTER_NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人姓名',
//            `CRTE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建时间',
//            `CRTE_OPTINS_NO` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建机构编号',
//            `OPTER_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '经办人ID',
//            `OPTER_NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '经办人姓名',
//            `OPT_TIME` datetime NULL DEFAULT NULL COMMENT '经办时间',
//            `OPTINS_NO` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '经办机构编号',
//            `POOLAREA_NO` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '统筹区编号',
//            `MID_SETL_FLAG` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '中途结算标志',
//            `ACCT_USED_FLAG` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '账户使用标志',
//            `MSGID` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '发送方报文ID',
//            `INF_REFMSGID` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '接收方报文ID',
//            `UNDO_SENDER_MSG_ID` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '被撤销发送方报文ID',
//            `UNDO_RECER_MSG_ID` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '被撤销接收方报文ID',
//            `CROV_OLD_BALC` decimal(16, 2) NULL DEFAULT 0.00 COMMENT '结算前账户余额',
//            `CROV_NEW_BALC` decimal(16, 2) NULL DEFAULT 0.00 COMMENT '结算后账户余额',
//            `IPT_OTP_NO` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '住院/门诊号',
//            `PLAF_STMT_FLAG` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '平台对账标志',
//            `PLAF_STMT_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '平台对账时间',
//            `PLAF_STMT_OPTER` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '平台对账经办人',
//            `CENT_STMT_FLAG` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '中心对账标志',
//            `CENT_STMT_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '中心对账时间',
//            `CENT_STMT_OPTER` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '中心对账经办人',
//            `OUT_FLAG` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '异地标志（0本地，1参保地，2就医地）',
//            `REVS_SENDER_MSG_ID` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '被冲正发送方报文ID',
//            `REVS_RECER_MSG_ID` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '被冲正接收方报文ID',
//            `SSC_CARDNO` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '社保卡卡号',
//            `PROV_PLAF_STMT_STAS` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '省平台对账状态',
//            `PROV_PLAF_STMT_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '省平台对账时间',
//            `PROV_PLAF_STMT_PRMMSG` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '省平台对账提示信息',
//            `EC_CHNL` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电子凭证渠道',
//            `FIX_PLAF_STMT_DSCR` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '定点与平台对账说明',
//            `PLAF_CENT_STMT_DSCR` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '平台与中心对账说明',
//            `SETL_WAY` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '诊间金融结算方式',
//            `SUBS_PAY` decimal(16, 2) NULL DEFAULT 0.00 COMMENT '补贴提高值',


    public String getSetlId() {
        return setlId;
    }

    public void setSetlId(String setlId) {
        this.setlId = setlId;
    }

    public String getMdtrtId() {
        return mdtrtId;
    }

    public void setMdtrtId(String mdtrtId) {
        this.mdtrtId = mdtrtId;
    }

    public String getPsnNo() {
        return psnNo;
    }

    public void setPsnNo(String psnNo) {
        this.psnNo = psnNo;
    }

    public String getPsnName() {
        return psnName;
    }

    public void setPsnName(String psnName) {
        this.psnName = psnName;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
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

    public String getMdtrtCertType() {
        return mdtrtCertType;
    }

    public void setMdtrtCertType(String mdtrtCertType) {
        this.mdtrtCertType = mdtrtCertType;
    }
}
