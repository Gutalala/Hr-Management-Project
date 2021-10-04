package com.group6project.hr.AOP;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
//@Slf4j

public class LoggingAspect {

    private Logger log = LoggerFactory.getLogger(LoggingAspect.class);


//    @Around("com.group6project.hr.AOP.PointCuts.inDaoLayerType()")
//    public Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
//        log.info("From LoggingAspect.logExecutionTime: " + proceedingJoinPoint.getSignature());
//        long start = System.currentTimeMillis();
//        Object entity = proceedingJoinPoint.proceed();
//        long executionTime = System.currentTimeMillis() - start;
//        log.info("Execution Time: " + executionTime + " milliseconds");
//
//        return entity;
//    }

    @Around("com.group6project.hr.AOP.PointCuts.inHireController()")
    public Object logHireControllerExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
//        log.info("From LoggingAspect.logExecutionTime: " + proceedingJoinPoint.getSignature());
        long start = System.currentTimeMillis();
        Object entity = proceedingJoinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        log.info("Execution Time: " + executionTime + " milliseconds");

        return entity;
    }

    @Around("com.group6project.hr.AOP.PointCuts.inAsyncHireController()")
    public Object logAsyncHireControllerExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        Object entity = proceedingJoinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        log.info("Execution Time: " + executionTime + " milliseconds");

        return entity;
    }
}
