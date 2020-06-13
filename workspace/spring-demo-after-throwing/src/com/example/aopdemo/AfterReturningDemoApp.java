package com.example.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(DemoConfig.class);
    
    AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
    List<Account> accounts = accountDAO.findAccounts();
    System.out.println();
    System.out.println("#-------------------------------------#");
    System.out.println("| Main Program: AfterReturningDemoApp |");
    System.out.println("#-------------------------------------#");
    System.out.println(accounts);
    
    context.close();
  }
}