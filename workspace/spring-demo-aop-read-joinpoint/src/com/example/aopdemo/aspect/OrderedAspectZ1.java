package com.example.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.aopdemo.Account;

/**
 * While the order is undefined for aspects with the same order value,
 * in practice spring AOP executes them in alphabetical order. To avoid
 * getting these in the right order we'll add X/Y/Z to the class names
 * arbitrarily.
 */

@Aspect
@Order(1)
@Component
public class OrderedAspectZ1 {
  @Before("com.example.aopdemo.aspect.PointcutHelper.forDaoPackageNoGetterSetter()")
  public void beforeOrderedAspect1(JoinPoint joinPoint) {
    System.out.println(">>>> BEFORE Ordered Aspect 1 <<<<");
    
    MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
    System.out.println("Method signature: " + methodSignature);
    
    Object[] args = joinPoint.getArgs();
    for (Object arg : args) {
      System.out.println(arg);
      
      if (arg instanceof Account) {
        Account account = (Account) arg;
      System.out.println("Account name: " + account.getName());
      System.out.println("Account level: " + account.getLevel());
      }
    }
  }
}