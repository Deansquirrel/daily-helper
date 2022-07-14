package com.yuansong.dailyHelper.features.sjsc.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.List;

@Repository
public class SJSCRep {

    private static final Logger logger = LoggerFactory.getLogger(SJSCRep.class);

    //单位参保登记
    private static final String SQL_QUERY_01 = "" +
            "SELECT CONCAT('131100','001',date_format(now(),'%Y%m%d'),'0',lpad((@i:=@i+1),6,0)) `A01`, " +
            "   '11131100MB193224813130736010001'  `A02`, '单位参保登记' `A03`, '001' `A04`, " +
            "   b.EMP_ENTT_CODG  `A05`, b.EMP_NAME `A06`, b.LEGREP_TEL `A07`, EMP_INSU_DATE `A08`, " +
            "   null `A09`, null `A10`, '5' `A11`, EMP_INSU_DATE `A12` " +
            "FROM emp_insu_d a,insu_emp_info_b b,(select @i:=0) t " +
            "WHERE ( EMP_INSU_DATE >= ? AND EMP_INSU_DATE <= ? ) " +
            "   AND insutype = '310' AND left(a.insu_admdvs,4) ='1311' and a.EMP_NO=b.EMP_NO;";
    //职工参保登记
    private static final String SQL_QUERY_02 = "" +
            "SELECT CONCAT('131100','001',date_format(now(),'%Y%m%d'),'0',lpad((@i:=@i+1),6,0)) `A01`, " +
            "   '11131100MB193224813130736010002'  `A02`, '职工参保登记' `A03`, '111' `A04`, " +
            "   b.CERTNO  `A05`, b.PSN_NAME `A06`, b.tel `A07`, PSN_INSU_DATE `A08`, " +
            "   null `A09`, null `A10`, '5' `A11`, PSN_INSU_DATE `A12` " +
            "FROM PSN_INSU_D a,psn_info_b b,(select @i:=0) t " +
            "WHERE ( PSN_INSU_DATE >= ? AND PSN_INSU_DATE <= ? ) " +
            "   AND insutype = '310' AND left(insu_admdvs,4) ='1311' and a.psn_no=b.psn_no;";
    //职工参保信息变更登记（需从4000库提取）
    private static final String SQL_QUERY_03 = "" +
            "SELECT CONCAT('131100','001',date_format(now(),'%Y%m%d'),'0',lpad((@i:=@i+1),6,0)) `A01`, " +
            "   '11131100MB193224813130736010006'  `A02`, '职工参保信息变更登记' `A03`, '111' `A04`, " +
            "   c.CERTNO  `A05`, c.PSN_NAME `A06`, c.tel `A07`, a.CRTE_TIME `A08`, " +
            "   null `A09`, null `A10`, '5' `A11`, a.CRTE_TIME `A12` " +
            "FROM PSN_INSU_CHG_C a, PSN_INSU_D b, psn_info_b c, (select @i:=0) t " +
            "WHERE a.psn_no = b.psn_no and a.PSN_NO=c.PSN_NO AND a.insutype = b.insutype AND a.insutype = '310' " +
            "   AND left(b.insu_admdvs,4) ='1311' " +
            "   AND ( a.CRTE_TIME >= ? AND a.CRTE_TIME <= ? ); ";
    //计划生育
    private static final String SQL_QUERY_04 = "" +
            "SELECT CONCAT('131100','001',date_format(now(),'%Y%m%d'),'0',lpad((@i:=@i+1),6,0)) `A01`, " +
            "   '11131100MB193224813130536004003'  `A02`, '计划生育医疗费支付' `A03`, '111' `A04`, " +
            "   c.CERTNO  `A05`, c.PSN_NAME `A06`, c.tel `A07`, a.CRTE_TIME `A08`, " +
            "   null `A09`, null `A10`, '5' `A11`, a.CRTE_TIME `A12` " +
            "FROM setl_d a force index (IDX_SETL_D_3),  psn_info_b c, (select @i:=0) t  " +
            "WHERE INSU_ADMDVS LIKE '1311%' AND INSUTYPE IN ( '310', '510' ) AND MED_TYPE IN ( '51', '52', '53' ) " +
            "   AND a.VALI_FLAG = '1' AND REFD_SETL_FLAG = '0' " +
            "   AND SETL_TIME >= ? AND SETL_TIME < ? and a.psn_no=c.psn_no " +
            "   AND EXISTS ( " +
            "       SELECT 1 " +
            "       FROM mdtrt_d " +
            "       WHERE MDTRT_ID = a.MDTRT_ID " +
            "           AND BIRCTRL_TYPE IN ( '1', '2', '3', '4', '5', '6', '9' ) " +
            "   ) ;";
    //生育医疗费用报销
    private static final String SQL_QUERY_05 = "" +
            "SELECT CONCAT('131100','001',date_format(now(),'%Y%m%d'),'0',lpad((@i:=@i+1),6,0)) `A01`, " +
            "   '11131100MB193224813130536004002'  `A02`, '生育医疗费支付' `A03`, '111' `A04`, " +
            "   c.CERTNO  `A05`, c.PSN_NAME `A06`, c.tel `A07`, a.CRTE_TIME `A08`, " +
            "   null `A09`, null `A10`, '5' `A11`, a.CRTE_TIME `A12` " +
            "FROM setl_d a force index (IDX_SETL_D_3),  psn_info_b c, (select @i:=0) t  " +
            "WHERE INSU_ADMDVS LIKE '1311%' AND INSUTYPE IN ( '310', '510' ) " +
            "   AND MED_TYPE IN ( '51', '52', '53' ) AND a.VALI_FLAG = '1' AND REFD_SETL_FLAG = '0' " +
            "   AND SETL_TIME >= ? AND SETL_TIME < ? " +
            "   and a.psn_no=c.psn_no " +
            "   AND NOT EXISTS ( " +
            "       SELECT 1 " +
            "       FROM mdtrt_d " +
            "       WHERE MDTRT_ID = a.MDTRT_ID AND MATN_TYPE IN ( '7' ) " +
            "   ) " +
            "   AND NOT EXISTS ( " +
            "       SELECT 1 " +
            "       FROM mdtrt_d " +
            "       WHERE MDTRT_ID = a.MDTRT_ID AND BIRCTRL_TYPE IN ( '1', '2', '3', '4', '5', '6', '9' ) " +
            "   ) ; ";
    //零售药店费用结算
    private static final String SQL_QUERY_06 = "" +
            "SELECT CONCAT('131100','001',date_format(now(),'%Y%m%d'),'0',lpad((@i:=@i+1),6,0)) `A01`, " +
            "   '11131100MB193224813132036022002'  `A02`, '基本医疗保险定点零售药店费用结算' `A03`, '111' `A04`, " +
            "   c.CERTNO  `A05`, c.PSN_NAME `A06`, c.TEL `A07`, a.CRTE_TIME `A08`, " +
            "   null `A09`, null `A10`, '5' `A11`, a.CRTE_TIME `A12` " +
            "FROM setl_d a force index (IDX_SETL_D_3), psn_info_b c, (select @i:=0) t  " +
            "WHERE INSU_ADMDVS LIKE '1311%' AND a.VALI_FLAG = '1' AND REFD_SETL_FLAG = '0' " +
            "   AND PAY_LOC IN ( '2', '3', '4' ) AND LEFT (FIX_BLNG_ADMDVS, 4) = '1311' " +
            "   and MED_TYPE in ('41', '93', '9301')   " +
            "   AND SETL_TIME >= ? AND SETL_TIME < ? " +
            "   and a.psn_no=c.psn_no ;";
    //定点医疗机构
    private static final String SQL_QUERY_07 = "" +
            "SELECT CONCAT('131100','001',date_format(now(),'%Y%m%d'),'0',lpad((@i:=@i+1),6,0)) `A01`, " +
            "   '11131100MB193224813132036022001'  `A02`, '基本医疗保险定点医疗机构费用结算' `A03`, '111' `A04`, " +
            "   c.CERTNO  `A05`, c.PSN_NAME `A06`, c.TEL `A07`, a.CRTE_TIME `A08`, " +
            "   null `A09`, null `A10`, '5' `A11`, a.CRTE_TIME `A12` " +
            "FROM setl_d a force index (IDX_SETL_D_3), psn_info_b c, (select @i:=0) t  " +
            "WHERE INSU_ADMDVS LIKE '1311%' AND a.VALI_FLAG = '1' " +
            "   AND REFD_SETL_FLAG = '0' AND PAY_LOC IN ( '2', '3', '4' ) AND LEFT (FIX_BLNG_ADMDVS, 4) = '1311' " +
            "   and MED_TYPE not in ('41', '93', '9301')   " +
            "   AND SETL_TIME >= ? AND SETL_TIME < ? " +
            "   and a.psn_no=c.psn_no ;";
    //门诊费用报销
    private static final String SQL_QUERY_08 = "" +
            "SELECT CONCAT('131100','001',date_format(now(),'%Y%m%d'),'0',lpad((@i:=@i+1),6,0)) `A01`, " +
            "   '11131100MB193224813132036023001'  `A02`, '门诊费用报销' `A03`, '111' `A04`, " +
            "   c.CERTNO  `A05`, c.PSN_NAME `A06`, c.TEL `A07`, a.CRTE_TIME `A08`, " +
            "   null `A09`, null `A10`, '5' `A11`, a.CRTE_TIME `A12` " +
            "FROM setl_d a force index (IDX_SETL_D_3), psn_info_b c, (select @i:=0) t  " +
            "WHERE INSU_ADMDVS LIKE '1311%' AND a.VALI_FLAG = '1' AND REFD_SETL_FLAG = '0' AND PAY_LOC IN ( '1' ) " +
            "   and MED_TYPE in ( '11', '12', '14', '51', '9104', '9101', '1201' )   " +
            "   AND SETL_TIME >= ? AND SETL_TIME < ? " +
            "   and a.psn_no=c.psn_no ;";
    //住院费用报销
    private static final String SQL_QUERY_09 = "" +
            "SELECT CONCAT('131100','001',date_format(now(),'%Y%m%d'),'0',lpad((@i:=@i+1),6,0)) `A01`, " +
            "   '11131100MB193224813132036023002'  `A02`, '住院费用报销' `A03`, '111' `A04`, " +
            "   c.CERTNO  `A05`, c.PSN_NAME `A06`, c.TEL `A07`, a.CRTE_TIME `A08`, " +
            "   null `A09`, null `A10`, '5' `A11`, a.CRTE_TIME `A12` " +
            "FROM setl_d a force index (IDX_SETL_D_3), psn_info_b c, (select @i:=0) t  " +
            "WHERE INSU_ADMDVS LIKE '1311%' AND a.VALI_FLAG = '1' AND REFD_SETL_FLAG = '0' AND PAY_LOC IN ( '1' ) " +
            "   and MED_TYPE not in ( '11', '12', '14', '51', '9104', '9101', '1201' )   " +
            "   AND SETL_TIME >= ? AND SETL_TIME < ? " +
            "   and a.psn_no=c.psn_no ;";
    //单位参保信息变更登记
    private static final String SQL_QUERY_10 = "" +
            "SELECT CONCAT('131100','001',date_format(now(),'%Y%m%d'),'0',lpad((@i:=@i+1),6,0)) `A01`, " +
            "   '11131100MB193224813130736010004'  `A02`, '单位参保信息变更登记' `A03`, '001' `A04`, " +
            "   a.EMP_ENTT_CODG  `A05`, a.CONER_NAME `A06`, a.tel `A07`, a.UPDT_TIME `A08`, " +
            "   null `A09`, null `A10`, '5' `A11`, a.CRTE_TIME `A12` " +
            "FROM insu_emp_info_b a, (select @i:=0) t " +
            "WHERE   left(a.insu_admdvs,4) ='1311' " +
            "   AND ( a.UPDT_TIME >= ? AND a.CRTE_TIME <= ? ) ";
    //异地安置退休人员备案
    private static final String SQL_QUERY_11 = "" +
            "SELECT CONCAT('131100','001',date_format(now(),'%Y%m%d'),'0',lpad((@i:=@i+1),6,0)) `A01`, " +
            "   '11131100MB193224813132036024001'  `A02`, '异地安置退休人员备案' `A03`, '111' `A04`, " +
            "   b.CERTNO  `A05`, b.PSN_NAME `A06`, b.tel `A07`, a.CRTE_TIME `A08`, " +
            "   null `A09`, null `A10`, '5' `A11`, a.CRTE_TIME `A12` " +
            "FROM out_appy_d a, psn_info_b b, (select @i:=0) t " +
            "WHERE   a.psn_no=b.psn_no   and left(a.INSU_ADMDVS,4) ='1311' " +
            "   AND ( a.UPDT_TIME >= ? AND a.CRTE_TIME <= ? ) " +
            "   and RLOC_REA='02'";
    //异地转诊专员人员备案
    private static final String SQL_QUERY_12 = "" +
            " SELECT CONCAT('131100','001',date_format(now(),'%Y%m%d'),'0',lpad((@i:=@i+1),6,0)) `A01`, " +
            "   '11131100MB193224813132036024003'  `A02`, '异地转诊人员备案' `A03`, '111' `A04`, " +
            "   b.CERTNO  `A05`, b.PSN_NAME `A06`, b.tel `A07`, a.CRTE_TIME `A08`, " +
            "   null `A09`, null `A10`, '5' `A11`, a.CRTE_TIME `A12` " +
            "FROM out_appy_d a, psn_info_b b, (select @i:=0) t " +
            "WHERE   a.psn_no=b.psn_no   and left(a.INSU_ADMDVS,4) ='1311' " +
            "   AND ( a.UPDT_TIME >= ? AND a.CRTE_TIME <= ? ) " +
            "   and RLOC_REA='06'";
    //常驻异地工作人员备案
    private static final String SQL_QUERY_13 = "" +
            " SELECT CONCAT('131100','001',date_format(now(),'%Y%m%d'),'0',lpad((@i:=@i+1),6,0)) `A01`, " +
            "   '11131100MB193224813132036024002'  `A02`, '常驻异地工作人员备案' `A03`, '111' `A04`, " +
            "   b.CERTNO  `A05`, b.PSN_NAME `A06`, b.tel `A07`, a.CRTE_TIME `A08`, " +
            "   null `A09`, null `A10`, '5' `A11`, a.CRTE_TIME `A12` " +
            "FROM out_appy_d a, psn_info_b b, (select @i:=0) t " +
            "WHERE   a.psn_no=b.psn_no   and left(a.INSU_ADMDVS,4) ='1311' " +
            "   AND ( a.UPDT_TIME >= ? AND a.CRTE_TIME <= ? ) " +
            "   and RLOC_REA='07' and left(a.MEMO,2)<>'12' ;";
    //异地长期居住人员备案
    private static final String SQL_QUERY_14 = "" +
            "SELECT CONCAT('131100','001',date_format(now(),'%Y%m%d'),'0',lpad((@i:=@i+1),6,0)) `A01`, " +
            "   '11131100MB193224813132036024004'  `A02`, '异地长期居住人员备案' `A03`, '111' `A04`, " +
            "   b.CERTNO  `A05`, b.PSN_NAME `A06`, b.tel `A07`, a.CRTE_TIME `A08`, " +
            "   null `A09`, null `A10`, '5' `A11`, a.CRTE_TIME `A12` " +
            "FROM out_appy_d a, psn_info_b b, (select @i:=0) t " +
            "WHERE   a.psn_no=b.psn_no   and left(a.INSU_ADMDVS,4) ='1311' " +
            "   AND ( a.UPDT_TIME >= ? AND a.CRTE_TIME <= ? ) " +
            "   and RLOC_REA='07' and left(a.MEMO,2)='12' ;";
    //慢特病备案
    private static final String SQL_QUERY_15 = "" +
            "SELECT CONCAT('131100','001',date_format(now(),'%Y%m%d'),'0',lpad((@i:=@i+1),6,0)) `A01`, " +
            "   '11131100MB193224813132036025000'  `A02`, '基本医疗保险参保人员享受门诊慢特病病种待遇认定' `A03`, '111' `A04`, " +
            "   a.CERTNO  `A05`, a.PSN_NAME `A06`, a.TEL `A07`, a.UPDT_TIME `A08`, " +
            "   null `A09`, null `A10`, '5' `A11`, a.UPDT_TIME `A12` " +
            "FROM opsp_reg_d a, (select @i:=0) t  " +
            "WHERE a.INSU_ADMDVS LIKE '1311%' AND a.VALI_FLAG = '1'   " +
            "   AND a.UPDT_TIME >= ? AND a.UPDT_TIME < ? " +
            "   and a.DISE_TYPE_CODE <> '9901' ;";
    //零售药店申请定点协议管理（需要在4000库提取后导入）
    private static final String SQL_QUERY_16 = "" +
            "SELECT CONCAT('131100','001',date_format(now(),'%Y%m%d'),'0',lpad((@i:=@i+1),6,0)) `A01`, " +
            "   '11131100MB193224813132036021002'  `A02`, '零售药店申请定点协议管理' `A03`, '111' `A04`, " +
            "   '1'  `A05`, '1' `A06`, '1' `A07`, a.UPDT_TIME `A08`, " +
            "   null `A09`, null `A10`, '5' `A11`, a.UPDT_TIME `A12` " +
            "FROM fixmedins_cntr_reg_d a, (select @i:=0) t  " +
            "WHERE a.FIX_BLNG_ADMDVS LIKE '1311%' and FIXMEDINS_CODE like 'P1311%' AND a.VALI_FLAG = '1'   " +
            "   AND a.UPDT_TIME >= ? AND a.UPDT_TIME < ? ; ";
    //医疗机构申请定点协议管理（需从4000库查询并导入）
    private static final String SQL_QUERY_17 = "" +
            "SELECT CONCAT('131100','001',date_format(now(),'%Y%m%d'),'0',lpad((@i:=@i+1),6,0)) `A01`, " +
            "   '11131100MB193224813132036021001'  `A02`, '医疗机构申请定点协议管理' `A03`, '111' `A04`, " +
            "   '1'  `A05`, '1' `A06`, '1' `A07`, a.UPDT_TIME `A08`, " +
            "   null `A09`, null `A10`, '5' `A11`, a.UPDT_TIME `A12` " +
            "FROM fixmedins_cntr_reg_d a, (select @i:=0) t  " +
            "WHERE a.FIX_BLNG_ADMDVS LIKE '1311%' and FIXMEDINS_CODE like 'H1311%' AND a.VALI_FLAG = '1'   " +
            "   AND a.UPDT_TIME >= ? AND a.UPDT_TIME < ? ; ";
    //转移接续手续办理(需要从4000库查询)
    private static final String SQL_QUERY_18 = "" +
            "SELECT CONCAT('131100','001',date_format(now(),'%Y%m%d'),'0',lpad((@i:=@i+1),6,0)) `A01`, " +
            "   '11131100MB193224813132036019002'  `A02`, '转移接续手续办理' `A03`, '111' `A04`, " +
            "   c.CERTNO  `A05`, c.PSN_NAME `A06`, c.TEL `A07`, a.UPDT_TIME `A08`, " +
            "   null `A09`, null `A10`, '5' `A11`, a.UPDT_TIME `A12` " +
            "FROM RLTS_TRAF_INFO_D a, rlts_traf_clct_years_d b, psn_info_b c, (select @i:=0) t  " +
            "WHERE a.psn_no = b.psn_no and a.psn_no = c.psn_no and b.trafin_admdvs like '1311%' " +
            "   and a.UPDT_TIME >= ? and a.UPDT_TIME < ? " +
            "   AND a.rlts_traf_id = b.rlts_traf_id AND a.TRAF_DIRC = '1' AND a.rlts_traf_eid = b.rlts_traf_eid ; ";
    //出具参保凭证(需要从4000库查询)
    private static final String SQL_QUERY_19 = "" +
            "SELECT CONCAT('131100','001',date_format(now(),'%Y%m%d'),'0',lpad((@i:=@i+1),6,0)) `A01`, " +
            "   '11131100MB193224813132036019001'  `A02`, '出具《参保凭证》' `A03`, '111' `A04`, " +
            "   c.CERTNO  `A05`, c.PSN_NAME `A06`, c.TEL `A07`, a.UPDT_TIME `A08`, " +
            "   null `A09`, null `A10`, '5' `A11`, a.UPDT_TIME `A12` " +
            "FROM RLTS_TRAF_INFO_D a, rlts_traf_clct_years_d b, psn_info_b c, (select @i:=0) t  " +
            "WHERE a.psn_no = b.psn_no and a.psn_no = c.psn_no and b.trafin_admdvs like '1311%' " +
            "   and a.UPDT_TIME >= ? and a.UPDT_TIME < ? " +
            "   AND a.rlts_traf_id = b.rlts_traf_id AND a.TRAF_DIRC = '2' AND a.rlts_traf_eid = b.rlts_traf_eid ;";

    private final JdbcTemplate jdbcTemplate;

    public SJSCRep(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<SJSCDo> getList01(SJSCQuery query) {
        logger.debug(MessageFormat.format("SJSC 单位参保登记 {0} {1} {2}",SQL_QUERY_01, query.getBegDate(), query.getEndDate()));
        return jdbcTemplate.query(SQL_QUERY_01, new SJSCRowMapper(), query.getBegDate(), query.getEndDate());
    }

    public List<SJSCDo> getList02(SJSCQuery query) {
        logger.debug(MessageFormat.format("SJSC 职工参保登记 {0} {1} {2}",SQL_QUERY_01, query.getBegDate(), query.getEndDate()));
        return jdbcTemplate.query(SQL_QUERY_02, new SJSCRowMapper(), query.getBegDate(), query.getEndDate());
    }

    public List<SJSCDo> getList03(SJSCQuery query) {
        logger.debug(MessageFormat.format("SJSC 职工参保信息变更登记(4000) {0} {1} {2}",SQL_QUERY_01, query.getBegDate(), query.getEndDate()));
        return jdbcTemplate.query(SQL_QUERY_03, new SJSCRowMapper(), query.getBegDate(), query.getEndDate());
    }

    public List<SJSCDo> getList04(SJSCQuery query) {
        logger.debug(MessageFormat.format("SJSC 计划生育 {0} {1} {2}",SQL_QUERY_01, query.getBegDate(), query.getEndDate()));
        return jdbcTemplate.query(SQL_QUERY_04, new SJSCRowMapper(), query.getBegDate(), query.getEndDate());
    }

    public List<SJSCDo> getList05(SJSCQuery query) {
        logger.debug(MessageFormat.format("SJSC 生育医疗费用报销 {0} {1} {2}",SQL_QUERY_01, query.getBegDate(), query.getEndDate()));
        return jdbcTemplate.query(SQL_QUERY_05, new SJSCRowMapper(), query.getBegDate(), query.getEndDate());
    }

    public List<SJSCDo> getList06(SJSCQuery query) {
        logger.debug(MessageFormat.format("SJSC 零售药店费用结算 {0} {1} {2}",SQL_QUERY_01, query.getBegDate(), query.getEndDate()));
        return jdbcTemplate.query(SQL_QUERY_06, new SJSCRowMapper(), query.getBegDate(), query.getEndDate());
    }

    public List<SJSCDo> getList07(SJSCQuery query) {
        logger.debug(MessageFormat.format("SJSC 定点医疗机构 {0} {1} {2}",SQL_QUERY_01, query.getBegDate(), query.getEndDate()));
        return jdbcTemplate.query(SQL_QUERY_07, new SJSCRowMapper(), query.getBegDate(), query.getEndDate());
    }

    public List<SJSCDo> getList08(SJSCQuery query) {
        logger.debug(MessageFormat.format("SJSC 门诊费用报销 {0} {1} {2}",SQL_QUERY_01, query.getBegDate(), query.getEndDate()));
        return jdbcTemplate.query(SQL_QUERY_08, new SJSCRowMapper(), query.getBegDate(), query.getEndDate());
    }

    public List<SJSCDo> getList09(SJSCQuery query) {
        logger.debug(MessageFormat.format("SJSC 住院费用报销 {0} {1} {2}",SQL_QUERY_01, query.getBegDate(), query.getEndDate()));
        return jdbcTemplate.query(SQL_QUERY_09, new SJSCRowMapper(), query.getBegDate(), query.getEndDate());
    }

    public List<SJSCDo> getList10(SJSCQuery query) {
        logger.debug(MessageFormat.format("SJSC 单位参保信息变更登记 {0} {1} {2}",SQL_QUERY_01, query.getBegDate(), query.getEndDate()));
        return jdbcTemplate.query(SQL_QUERY_10, new SJSCRowMapper(), query.getBegDate(), query.getEndDate());
    }

    public List<SJSCDo> getList11(SJSCQuery query) {
        logger.debug(MessageFormat.format("SJSC 异地安置退休人员备案 {0} {1} {2}",SQL_QUERY_01, query.getBegDate(), query.getEndDate()));
        return jdbcTemplate.query(SQL_QUERY_11, new SJSCRowMapper(), query.getBegDate(), query.getEndDate());
    }

    public List<SJSCDo> getList12(SJSCQuery query) {
        logger.debug(MessageFormat.format("SJSC 异地转诊专员人员备案 {0} {1} {2}",SQL_QUERY_01, query.getBegDate(), query.getEndDate()));
        return jdbcTemplate.query(SQL_QUERY_12, new SJSCRowMapper(), query.getBegDate(), query.getEndDate());
    }

    public List<SJSCDo> getList13(SJSCQuery query) {
        logger.debug(MessageFormat.format("SJSC 常驻异地工作人员备案 {0} {1} {2}",SQL_QUERY_01, query.getBegDate(), query.getEndDate()));
        return jdbcTemplate.query(SQL_QUERY_13, new SJSCRowMapper(), query.getBegDate(), query.getEndDate());
    }

    public List<SJSCDo> getList14(SJSCQuery query) {
        logger.debug(MessageFormat.format("SJSC 异地长期居住人员备案 {0} {1} {2}",SQL_QUERY_01, query.getBegDate(), query.getEndDate()));
        return jdbcTemplate.query(SQL_QUERY_14, new SJSCRowMapper(), query.getBegDate(), query.getEndDate());
    }

    public List<SJSCDo> getList15(SJSCQuery query) {
        logger.debug(MessageFormat.format("SJSC 慢特病备案 {0} {1} {2}",SQL_QUERY_01, query.getBegDate(), query.getEndDate()));
        return jdbcTemplate.query(SQL_QUERY_15, new SJSCRowMapper(), query.getBegDate(), query.getEndDate());
    }

    public List<SJSCDo> getList16(SJSCQuery query) {
        logger.debug(MessageFormat.format("SJSC 零售药店申请定点协议管理(4000) {0} {1} {2}",SQL_QUERY_01, query.getBegDate(), query.getEndDate()));
        return jdbcTemplate.query(SQL_QUERY_16, new SJSCRowMapper(), query.getBegDate(), query.getEndDate());
    }

    public List<SJSCDo> getList17(SJSCQuery query) {
        logger.debug(MessageFormat.format("SJSC 医疗机构申请定点协议管理(4000) {0} {1} {2}",SQL_QUERY_01, query.getBegDate(), query.getEndDate()));
        return jdbcTemplate.query(SQL_QUERY_17, new SJSCRowMapper(), query.getBegDate(), query.getEndDate());
    }

    public List<SJSCDo> getList18(SJSCQuery query) {
        logger.debug(MessageFormat.format("SJSC 转移接续手续办理(4000) {0} {1} {2}",SQL_QUERY_01, query.getBegDate(), query.getEndDate()));
        return jdbcTemplate.query(SQL_QUERY_18, new SJSCRowMapper(), query.getBegDate(), query.getEndDate());
    }

    public List<SJSCDo> getList19(SJSCQuery query) {
        logger.debug(MessageFormat.format("SJSC 出具参保凭证(4000) {0} {1} {2}",SQL_QUERY_01, query.getBegDate(), query.getEndDate()));
        return jdbcTemplate.query(SQL_QUERY_19, new SJSCRowMapper(), query.getBegDate(), query.getEndDate());
    }

}
