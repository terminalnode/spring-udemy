package com.example.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.example.aopdemo.Account;

@Component
public class AccountDAO {
  public void addAccount(Account account, boolean isVIP) {
    System.out.println(getClass() + " doing my db work: adding an account");
  }
  
  public boolean doWork() {
    System.out.println(getClass() + " doing my db work: doing work");
    return true;
  }
}