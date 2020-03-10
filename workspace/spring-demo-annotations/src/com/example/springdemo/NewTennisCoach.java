package com.example.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class NewTennisCoach implements Coach {
	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;
	
	// Using field injection above, this method will not be called automatically.
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Setter injection yeah baby!");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Smash those balls!";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}
}
