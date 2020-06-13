package com.example.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.aopdemo.dao.AccountDAO;
import com.example.aopdemo.dao.MembershipDAO;

public class MainDemoApp {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(DemoConfig.class);
    
    AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
    accountDAO.addAccount(null, false);
    accountDAO.doWork();
    
    MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
    membershipDAO.addAccount();
    membershipDAO.goToSleep();
    
    context.close();
  }
}