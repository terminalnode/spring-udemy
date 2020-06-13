package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
  @Pointcut("execution(* com.example.aopdemo.dao.*.*(..))")
  private void forDaoMethod() {};

  @Before("forDaoMethod()")
  public void beforeAddAccountAdvice() {
    System.out.println("beforeAddAccountAdvice() deeeeewdzzzz");
  }

  @After("forDaoMethod()")
  public void performApiAnalytics() {
    System.out.println("performApiAnalytics() deeeeewdeewwtzzzz");
  }
}