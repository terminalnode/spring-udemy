package com.example.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.aopdemo.dao.AccountDAO;
import com.example.aopdemo.dao.MembershipDAO;

public class MainDemoApp {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(DemoConfig.class);
    
    AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
    Account account = new Account();
    account.setName("account name");
    account.setLevel("top level bruh");
    accountDAO.addAccount(account, false);
    accountDAO.doWork();
    accountDAO.setName("stupid name lol");
    accountDAO.setServiceCode("stupid service code lol");
    System.out.println(accountDAO.getName());
    System.out.println(accountDAO.getServiceCode());
    
    MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
    membershipDAO.addAccount();
    membershipDAO.goToSleep();
    
    context.close();
  }
}