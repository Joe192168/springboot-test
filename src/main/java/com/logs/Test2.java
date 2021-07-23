package com.logs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Test2 {

    public static void main(String[] args) {
        Log log = LogFactory.getLog(Test2.class);
        log.info("start...");
        log.warn("end....");
        log.error("error...");
    }

}
