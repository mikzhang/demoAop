package com.ran.demo.aop.controller;

import com.ran.demo.aop.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/test")
    @ResponseBody
    public String test() {
        return "OK";
    }

    @RequestMapping(value = "/testArg")
    @ResponseBody
    public String testArg() {
        testService.doSth("IamArg");
//        doSth("IamArg");
        return "OK";
    }

    @RequestMapping(value = "/testExcetion")
    @ResponseBody
    public String testExcetion() throws Exception {
        // 测试 @AfterThrowing
        if (1==1) {
            throw new Exception("this is a exception for test aop @AfterThrowing");
        }
        return "OK";
    }

    //该方法移到 service 中, 才能使用 ArgLogAspect, why?
//    public void doSth(String arg) {
//        logger.info("doSth, arg={}", arg);
//    }

}
