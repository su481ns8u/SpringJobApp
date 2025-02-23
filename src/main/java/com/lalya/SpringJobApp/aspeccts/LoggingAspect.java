package com.lalya.SpringJobApp.aspeccts;

import jakarta.persistence.AssociationOverride;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    //return type, class name.method name(args)
    @Before("execution(* com.lalya.SpringJobApp.service.JobService.*(..))")
    public void logMethodCalls(JoinPoint jp) {
        LOGGER.info("Method called " + jp.getSignature().getName());
    }

    @After("execution(* com.lalya.SpringJobApp.service.JobService.*(..))")
    public void logMethodExecuted(JoinPoint jp) {
        LOGGER.info("Method Executed " + jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.lalya.SpringJobApp.service.JobService.*(..))")
    public void logMethodCrash(JoinPoint jp) {
        LOGGER.info("Method Executed with exception " + jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.lalya.SpringJobApp.service.JobService.*(..))")
    public void logMethodSuccess(JoinPoint jp) {
        LOGGER.info("Method Executed successfully " + jp.getSignature().getName());
    }
}
