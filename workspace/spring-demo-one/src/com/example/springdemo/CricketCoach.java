package com.example.springdemo;

public class CricketCoach implements Coach {
	private FortuneService fortuneService;
	
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Get them crickets dancing!";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}
}