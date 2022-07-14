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

    private static final String SQL_QUERY = "" +
            "SELECT CONCAT('131100','001',date_format(now(),'%Y%m%d'),'0',lpad((@i:=@i+1),6,0)) `A01`, " +
            "   '11131100MB193224813130736010001'  `A02`, '单位参保登记' `A03`, '001' `A04`, " +
            "   b.EMP_ENTT_CODG  `A05`, b.EMP_NAME `A06`, b.LEGREP_TEL `A07`, EMP_INSU_DATE `A08`, " +
            "   null `A09`, null `A10`, '5' `A11`, EMP_INSU_DATE `A12` " +
            "FROM emp_insu_d a,insu_emp_info_b b,(select @i:=0) t " +
            "WHERE ( EMP_INSU_DATE >= ? AND EMP_INSU_DATE <= ? ) " +
            "   AND insutype = '310' AND left(a.insu_admdvs,4) ='1311' and a.EMP_NO=b.EMP_NO;";

    private final JdbcTemplate jdbcTemplate;

    public SJSCRep(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<SJSCDo> getList(SJSCQuery query) {
        logger.debug(MessageFormat.format("SJSC {0} {1} {2}",SQL_QUERY, query.getBegDate(), query.getEndDate()));
        return jdbcTemplate.query(SQL_QUERY, new SJSCRowMapper(), query.getBegDate(), query.getEndDate());
    }
}
