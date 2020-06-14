package com.example.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
  @Around("execution(* com.example.aopdemo.service.*.getFortune(..))")
  public Object aroundGetFortune(ProceedingJoinPoint preJoinPoint) throws Throwable {
    System.out.println("Get fortune is triggered!");
    long start = System.currentTimeMillis();
    System.out.println("Time is: " + start);
    
    Object result;
    long stop;

    try {
      result = preJoinPoint.proceed();
      System.out.println("Get fortune is done!");
      stop = System.currentTimeMillis();
      System.out.println("Time is: " + stop);
    } catch (Exception e) {
      result = "Fortune service is down, sorry about that...";
      System.out.println("Get fortune failed!");
      stop = System.currentTimeMillis();
      System.out.println("Time is: " + stop);
    }
    
    long duration = stop - start;
    System.out.println("Duration is: " + duration + "ms");

    return result;
  }

  @AfterThrowing(
      pointcut="execution(* com.example.aopdemo.dao.AccountDAO.findAccounts(..))",
      throwing="exc"
      )
  public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exc) {
    String method = joinPoint.getSignature().toShortString();
    System.out.println("AfterThrowing " + method);
    System.out.println("Throwable is " + exc);
  }

  @AfterReturning(
      pointcut="execution(* com.example.aopdemo.dao.AccountDAO.findAccounts(..))",
      returning="result"
      )
  public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
    String method = joinPoint.getSignature().toShortString();
    System.out.println("AfterReturning " + method);
    System.out.println("Result is " + result);
    
    // Look, we can be naughty.
    // result.add(new Account());
  }

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