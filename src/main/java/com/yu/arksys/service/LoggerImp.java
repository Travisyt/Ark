package com.yu.arksys.service;

import com.yu.arksys.service.api.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class LoggerImp implements Logger {

    private org.slf4j.Logger logger;

    LoggerImp() {
        this.logger = LoggerFactory.getLogger(Logger.class);
        logger.info("======================= get logger from logger factory =========================");
    }

    @Override
    public void info(String message) {
        this.logger.info(message);
    }

    @Override
    public void error(String message) {
        this.logger.error(message);
    }


}
