package com.yuansong.dailyHelper.features.evss;

import org.springframework.stereotype.Service;

@Service
public class EvssService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(EvssService.class);

    private final EvssRepService evssRepService;

    public EvssService(EvssRepService evssRepService) {
        this.evssRepService = evssRepService;
    }


//    public EvssService(EvssRep evssRep) {
//        this.evssRep = evssRep;
//    }

    public void subTest() {
        logger.debug("EvssService sub test");
        logger.debug(String.valueOf(evssRepService.getT1List().size()));
        logger.debug(String.valueOf(evssRepService.getZgList().size()));
        logger.debug(String.valueOf(evssRepService.getJmList().size()));
    }




}
