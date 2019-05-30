package com.ran.demo.aop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void doSth(String arg) {
        logger.info("doSth, arg={}", arg);
    }
}
