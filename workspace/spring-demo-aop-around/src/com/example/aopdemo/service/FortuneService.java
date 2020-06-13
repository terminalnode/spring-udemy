package com.example.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class FortuneService {
  public String getFortune() {
    // Simulate delay
    try {
      TimeUnit.SECONDS.sleep(3);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Return value
    return "From my point of view the Jedi are evil!!";
  }
}