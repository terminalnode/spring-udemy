package com.example.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.aopdemo.dao.AccountDAO;

public class MainDemoApp {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(DemoConfig.class);
    
    AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
    accountDAO.addAccount();
    
    context.close();
  }
}