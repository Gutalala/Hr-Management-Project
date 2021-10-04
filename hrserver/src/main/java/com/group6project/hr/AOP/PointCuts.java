package com.group6project.hr.AOP;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointCuts {

    @Pointcut("execution(* com.group6project.hr.dao.impl.*.*(..))")
    public void inDaoLayerExecution(){}

    @Pointcut("bean(*Repository)")
    public void inDaoLayerBean(){}

    @Pointcut("within(com.group6project.hr.dao..*)")
    public void inDaoLayerType(){}

    @Pointcut("execution(* com.group6project.hr.controllers.HireController.getEmployeeInfo(..))")
    public void inHireController(){}

    @Pointcut("execution(* com.group6project.hr.controllers.AsyncHireController.getAsyncEmployeeInfo(..))")
    public void inAsyncHireController(){}

}
