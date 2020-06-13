package com.example.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(DemoConfig.class);
    
    AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
    List<Account> accounts = null;

    try {
      accounts = accountDAO.findAccounts(true);

    } catch (Exception exc) {
      System.out.println("AfterThrowingDemoApp caught: " + exc);
    }

    System.out.println();
    System.out.println("#------------------------------------#");
    System.out.println("| Main Program: AfterThrowingDemoApp |");
    System.out.println("#------------------------------------#");
    System.out.println(accounts);
    
    context.close();
  }
}