package com.example.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
  public void addAccount() {
    System.out.println(getClass() + " doing my db work: adding an account");
  }

  public String goToSleep() {
    System.out.println(getClass() + " doing my db work: zzzZZzZZzzZzzz");
    return "zzzzzz";
  }
}