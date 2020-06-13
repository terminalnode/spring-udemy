package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutHelper {
  @Pointcut("execution(* com.example.aopdemo.dao.*.*(..))")
  public void forDaoMethod() {};

  @Pointcut("execution(* com.example.aopdemo.dao.*.get*(..))")
  public void getters() {};

  @Pointcut("execution(* com.example.aopdemo.dao.*.set*(..))")
  public void setters() {};

  @Pointcut("forDaoMethod() && !(getters() || setters())")
  public void forDaoPackageNoGetterSetter() {};
}