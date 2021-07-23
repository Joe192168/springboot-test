package com.logs;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Test1 {

    public static void main(String[] args) {
        Logger logger = Logger.getGlobal();
        logger.info("start...");
        logger.log(Level.WARNING,"warning...");
        logger.warning("start...");

    }

}
