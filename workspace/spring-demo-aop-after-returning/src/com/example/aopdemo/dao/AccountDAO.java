package com.example.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.aopdemo.Account;

@Component
public class AccountDAO {
  private String name;
  private String serviceCode;
  
  public List<Account> findAccounts() {
    List<Account> accounts = new ArrayList<>();
    
    // Add some sample accounts and add to the list
    accounts.add(new Account("Account 1", "Poop"));
    accounts.add(new Account("Account 2", "Trash"));
    accounts.add(new Account("Account 3", "Silver ore"));
    accounts.add(new Account("Account 4", "Silver"));
    accounts.add(new Account("Account 5", "Gold ore"));
    accounts.add(new Account("Account 6", "Gold"));
    return accounts;
  }

  public void addAccount(Account account, boolean isVIP) {
    System.out.println(getClass() + " doing my db work: adding an account");
  }
  
  public boolean doWork() {
    System.out.println(getClass() + " doing my db work: doing work");
    return true;
  }

  public String getName() {
    System.out.println(getClass() + " in getName");
    return name;
  }

  public void setName(String name) {
    System.out.println(getClass() + " in setName");
    this.name = name;
  }

  public String getServiceCode() {
    System.out.println(getClass() + " in getServiceCode");
    return serviceCode;
  }

  public void setServiceCode(String serviceCode) {
    System.out.println(getClass() + " in setServiceCode");
    this.serviceCode = serviceCode;
 }
}