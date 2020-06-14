package com.example.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.aopdemo.service.FortuneService;

public class AroundHandleExceptionDemoApp {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(DemoConfig.class);
    
    FortuneService fs = context.getBean("fortuneService", FortuneService.class);
    String fortune = fs.getFortune(true);

    System.out.println();
    System.out.println("#------------------------------------#");
    System.out.println("| Main Program: AfterThrowingDemoApp |");
    System.out.println("#------------------------------------#");
    System.out.println("My fortune: " + fortune);
    
    context.close();
  }
}