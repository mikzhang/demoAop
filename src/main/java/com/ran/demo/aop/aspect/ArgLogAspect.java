package com.ran.demo.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ArgLogAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* do*(..)) && args(arg)")
    public void argLog(String arg) {// 形参名必须和 args()一致
    }

    @Before(value = "argLog(arg)")
    public void beforeWithArg4Method(String arg) {
        logger.info("beforeWithArg4Method, arg={}", arg);
    }
}
