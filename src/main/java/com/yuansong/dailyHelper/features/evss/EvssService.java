package com.yuansong.dailyHelper.features.evss;

import com.github.deansquirrel.tools.poi.XSSFWorkBookTool;
import com.github.deansquirrel.tools.poi.XSSFWorkTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EvssService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(EvssService.class);

    private final EvssRepService evssRepService;

    public EvssService(EvssRepService evssRepService) {
        this.evssRepService = evssRepService;
    }

    public List<EvssDO> getData() {
        List<EvssDO> zgList = evssRepService.getZgList();
        logger.debug("zg size {}", zgList.size());
        List<EvssDO> jmList = evssRepService.getJmList();
        logger.debug("jm size {}", jmList.size());
        Map<String, EvssDO> r = new HashMap<>();
        for(EvssDO d : zgList) {
            r.put(d.getFixmedinsCode(), d);
        }
        for(EvssDO d : jmList) {
            if(r.containsKey(d.getFixmedinsCode())) {
                EvssDO rd = r.get(d.getFixmedinsCode());
                r.put(d.getFixmedinsCode(), getEvssDOAdd(rd, d));
            } else {
                r.put(d.getFixmedinsCode(), d);
            }
        }
        logger.debug("all {}", r.size());
        return new ArrayList<>(r.values());
    }

    public XSSFWorkbook getWorkBook(List<EvssDO> list) {
        XSSFWorkTable table = XSSFWorkBookTool.getXSSFWorkTable("szpz",list, new EvssDODataMapper());
        List<XSSFWorkTable> tableList = new ArrayList<>();
        tableList.add(table);
        return XSSFWorkBookTool.getXSSFWorkBook(tableList);
    }

    private EvssDO getEvssDOAdd(EvssDO a, EvssDO b) {
        Integer totalRc = null;
        if(a.getTotalRc() != null && b.getTotalRc() != null) {
            totalRc = a.getTotalRc() + b.getTotalRc();
        }
        if(a.getTotalRc() == null) {
            totalRc = b.getTotalRc();
        }
        if(b.getTotalRc() == null) {
            totalRc = a.getTotalRc();
        }
        a.setTotalRc(totalRc);
        return a;
    }

}
