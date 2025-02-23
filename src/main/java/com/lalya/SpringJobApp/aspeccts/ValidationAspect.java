package com.lalya.SpringJobApp.aspeccts;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.lalya.SpringJobApp.service.JobService.*(..)) && args(postId)")
    public Object validateAndUpdate(ProceedingJoinPoint pjp, int postId) throws Throwable {
        if (postId < 0) {
            LOGGER.info("Negative postId, Updating it");
            postId = -postId;
        }
        Object obj = pjp.proceed(new Object[]{postId});
        return obj;
    }
}
