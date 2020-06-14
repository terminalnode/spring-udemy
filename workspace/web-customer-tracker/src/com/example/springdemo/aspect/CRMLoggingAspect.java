package com.example.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
  private Logger logger = Logger.getLogger(getClass().getName());
  
  @Pointcut("execution(* com.example.springdemo.controller.*.*(..))")
  private void forControllerPackage() {};

  @Pointcut("execution(* com.example.springdemo.service.*.*(..))")
  private void forServicePackage() {};

  @Pointcut("execution(* com.example.springdemo.dao.*.*(..))")
  private void forDaoPackage() {};
  
  @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
  private void forAppFlow() {};
  
  @Before("forAppFlow()")
  private void beforeAppFlow(JoinPoint joinPoint) {
    String methodName = joinPoint.getSignature().toShortString();
    Object[] args = joinPoint.getArgs();

    logger.info("<BEFORE APP FLOW> Method name: " + methodName);
    
    for (Object arg : args) {
      logger.info("<BEFORE APP FLOW> Called with arg: " + arg);
    }
  }
  
  @AfterReturning(
      pointcut="forAppFlow()",
      returning="result"
      )
  private void afterReturningAppFlow(JoinPoint joinPoint, Object result) {
    String methodName = joinPoint.getSignature().toShortString();
    logger.info("<AFTER RETURNING APP FLOW> Method name: " + methodName);
    logger.info("<AFTER RETURNING APP FLOW> Returned result: " + result);
  }
}