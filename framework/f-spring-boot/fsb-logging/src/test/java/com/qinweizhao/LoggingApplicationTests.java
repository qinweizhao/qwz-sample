package com.qinweizhao;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoggingApplicationTests {

    Logger logger = LoggerFactory.getLogger(LoggingApplicationTests.class);

    @Test
    void contextLoads() {
    }

    @Test
    void test1() {

        logger.trace("this is {} 1", "trace");

        logger.debug("this is {} 2", "debug");

        logger.info("this is {} 3", "info");

        logger.warn("this is {} 4", "warn");

        logger.error("this is {} 5", "error");

    }

}
