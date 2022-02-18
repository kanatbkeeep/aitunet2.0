package com.aituNet.aituNet.rolling;

import java.util.logging.Logger;

public class Log4jRolling {
    private static Logger logger = Logger.getLogger(String.valueOf(Log4jRolling.class));

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 2000; i++) {
            logger.info("This is the " + i + " time I say 'Hello World'.");
            Thread.sleep(100);
        }
    }
}
