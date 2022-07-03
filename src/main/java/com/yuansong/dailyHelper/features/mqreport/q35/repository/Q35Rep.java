package com.yuansong.dailyHelper.features.mqreport.q35.repository;

import com.github.deansquirrel.tools.common.DateTool;
import com.github.deansquirrel.tools.db.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.List;

@Repository
public class Q35Rep {

    private static final Logger logger = LoggerFactory.getLogger(Q35Rep.class);

    private static final String SQL_QUERY_ALL = "" +
            "select '全部' PSN_RANGE,INSU_ADMDVS, " +
            "   sum(hifp_pay) hifp_pay, sum(HIFMI_PAY) HIFMI_PAY, sum(MAF_PAY) MAF_PAY, " +
            "   sum(ziFu) zifu, sum(ziFei) zifei, " +
            "   count(DISTINCT PSN_NO) REN_SHU, count(*) REN_CI " +
            "from ( " +
            "   select INSU_ADMDVS, PSN_NO, hifp_pay, HIFMI_PAY, MAF_PAY," +
            "       (MEDFEE_SUMAMT - hifp_pay - (HIFMI_PAY+MAF_PAY) - FULAMT_OWNPAY_AMT) zifu, " +
            "       FULAMT_OWNPAY_AMT zifei " +
            "   from setl_d a " +
            "   where INSU_ADMDVS like '1311%' " +
            "       and setl_time >= ? " +
            "       and SETL_TIME < ? " +
            "       and VALI_FLAG='1' " +
            "       and INSUTYPE='390' " +
            "       and HIFMI_PAY <> 0 " +
            "       and REFD_SETL_FLAG='0' " +
            ") a " +
            "group by INSU_ADMDVS " +
            "order by INSU_ADMDVS;";

    private static final String SQL_QUERY_MAF = "" +
            "select '贫困' PSN_RANGE,INSU_ADMDVS, " +
            "   sum(hifp_pay) hifp_pay, sum(HIFMI_PAY) HIFMI_PAY, sum(MAF_PAY) MAF_PAY, " +
            "   sum(ziFu) zifu, sum(ziFei) zifei, " +
            "   count(DISTINCT PSN_NO) REN_SHU, count(*) REN_CI " +
            "from ( " +
            "   select INSU_ADMDVS, PSN_NO, hifp_pay, HIFMI_PAY, MAF_PAY," +
            "       (MEDFEE_SUMAMT - hifp_pay - (HIFMI_PAY+MAF_PAY) - FULAMT_OWNPAY_AMT) zifu, " +
            "       FULAMT_OWNPAY_AMT zifei " +
            "   from setl_d a " +
            "   where INSU_ADMDVS like '1311%' " +
            "       and setl_time >= ? " +
            "       and SETL_TIME < ? " +
            "       and VALI_FLAG='1' " +
            "       and INSUTYPE='390' " +
            "       and HIFMI_PAY <> 0 " +
            "       and REFD_SETL_FLAG='0' " +
            "       and MAF_PAY <> 0 " +
            ") a " +
            "group by INSU_ADMDVS " +
            "order by INSU_ADMDVS;";

    private final JdbcTemplate jdbcTemplate;

    public Q35Rep(@Qualifier(Constant.BEAN_JDBC_TEMPLATE) JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Q35Do> getList(Q35Query query) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(query.getMonth().getTime());
        cal.set(
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),
                0,0,0);
        cal.add(Calendar.MONTH, 1);
        String maxSetlTime = DateTool.GetDateTimeStr(cal.getTime());
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        String minSetlTime = DateTool.GetDateTimeStr(cal.getTime());
        List<Q35Do> listAll = getListAll(minSetlTime, maxSetlTime);
        List<Q35Do> listMaf = getListMAF(minSetlTime, maxSetlTime);
        listAll.addAll(listMaf);
        return listAll;
    }

    private List<Q35Do> getListAll(String minSetlTime, String maxSetlTime) {
        logger.debug(MessageFormat.format("Q35 SQL ALL {0} {1} {2}",SQL_QUERY_ALL, minSetlTime,maxSetlTime));
        return jdbcTemplate.query(SQL_QUERY_ALL,
                new Q35RowMapper(),
                minSetlTime,maxSetlTime);
    }

    private List<Q35Do> getListMAF(String minSetlTime, String maxSetlTime) {
        logger.debug(MessageFormat.format("Q35 SQL MAF {0} {1} {2}",SQL_QUERY_MAF, minSetlTime,maxSetlTime));
        return jdbcTemplate.query(SQL_QUERY_MAF,
                new Q35RowMapper(),
                minSetlTime,maxSetlTime);
    }

}
