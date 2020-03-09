package com.example.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewTennisCoach implements Coach {
	private FortuneService fortuneService;
	
	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
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
