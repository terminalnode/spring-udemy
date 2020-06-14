package com.example.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class FortuneService {
  public String getFortune() {
    return getFortune(false);
  }
  
  public String getFortune(boolean throwException) {
    // Simulate delay
    try {
      TimeUnit.SECONDS.sleep(3);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    if (throwException) {
      throw new RuntimeException("OH NO, IT'S A SUPER EXCEPTION!");
    }

    // Return value
    return "From my point of view the Jedi are evil!!";
  }
}