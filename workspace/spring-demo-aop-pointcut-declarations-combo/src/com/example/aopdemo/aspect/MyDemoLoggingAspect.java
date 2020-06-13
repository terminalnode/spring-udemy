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

  @Pointcut("execution(* com.example.aopdemo.dao.*.get*(..))")
  private void getters() {};

  @Pointcut("execution(* com.example.aopdemo.dao.*.set*(..))")
  private void setters() {};

  @Pointcut("forDaoMethod() && !(getters() || setters())")
  private void forDaoPackageNoGetterSetter() {};

  @Before("forDaoMethod()")
  public void beforeAddAccountAdvice() {
    System.out.println(">>>> BEFORE <<<<");
  }

  @After("forDaoPackageNoGetterSetter()")
  public void performApiAnalytics() {
    System.out.println(">>>> AFTER <<<<\n");
  }
  
  @After("getters() || setters()")
  public void afterGetterSetter() {
    System.out.println(">>>> AFTER GETTER/SETTER <<<<\n");
  }
}