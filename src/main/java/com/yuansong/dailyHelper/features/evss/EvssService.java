package com.yuansong.dailyHelper.features.evss;

import com.github.deansquirrel.tools.common.DateTool;
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
        return getData(new Date());
    }

    public List<EvssDO> getData(Date endData) {
        List<EvssDO> zgList = evssRepService.getZgList();
        List<EvssDO> jmList = evssRepService.getJmList();
        Map<String, EvssDO> r = new HashMap<>();
        for(EvssDO d : zgList) {
            r.put(d.getFixmedinsCode(), d);
        }
        for(EvssDO d : jmList) {
            if(r.containsKey(d.getFixmedinsCode())) {
                r.put(d.getFixmedinsCode(), r.get(d.getFixmedinsCode()).add(d));
            } else {
                r.put(d.getFixmedinsCode(), d);
            }
        }
        List<EvssDO> list = new ArrayList<>(r.values());
        Collections.sort(list);
        return list;
    }

    public XSSFWorkbook getWorkBook(List<EvssDO> list) {
        return getWorkBook(list, new Date());
    }

    public XSSFWorkbook getWorkBook(List<EvssDO> list, Date endDate) {
        XSSFWorkTable table = XSSFWorkBookTool.getXSSFWorkTable(DateTool.GetDateStr(),list, new EvssDODataMapper());
        List<XSSFWorkTable> tableList = new ArrayList<>();
        tableList.add(table);
        return XSSFWorkBookTool.getXSSFWorkBook(tableList);
    }

}
