package com.zubarev.dataloader.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataLoaderLoggingAspect {
    private Logger logger = LoggerFactory.getLogger(DataLoaderLoggingAspect.class);


    @Pointcut("execution(* com.zubarev.dataloader.service.*.*(..))")
    private void forServicePackage() {
    }

    @Pointcut("execution(* com.zubarev.dataloader.DataLoaderApplication.run(..))")
    private void forDataLoaderApp() {
    }

    @Pointcut("forServicePackage() || forDataLoaderApp()")
    private void forAppFlow() {
    }

    @AfterReturning(pointcut = "forServicePackage()")
    public void afterSaveData() {
        logger.info("Data save successfully");
    }

    @AfterThrowing(pointcut = "forAppFlow()", throwing = "exc")
    public void afterThrowing(JoinPoint joinPoint, Throwable exc) {
        String method = joinPoint.getSignature().toShortString();
        logger.error(exc.toString() + " in method: " + method);
    }
}
