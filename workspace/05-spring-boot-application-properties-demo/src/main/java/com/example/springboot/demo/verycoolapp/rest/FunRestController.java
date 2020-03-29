package com.example.springboot.demo.verycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
  @Value("${coach.name}")
  String coachName;
  
  @Value("${team.name}")
  String teamName;
  
  @GetMapping("/teaminfo")
  public String teamInfo() {
    return "<b>Coach:</b> " + coachName + ", <b>team:</b>" + teamName;
  }

  @GetMapping("/")
  public String sayHello() {
    return "Hello world! Time on server is " + LocalDateTime.now();
  }
  
  @GetMapping("/workout")
  public String getDailyWorkout() {
    return "No workout, self-quarantine.";
  }
  
  @GetMapping("/fortune")
  public String getDailyFortune() {
    return "The number of corona cases will increase, economy will crash and burn.";
  }
}