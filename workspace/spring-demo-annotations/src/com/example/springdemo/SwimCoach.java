package com.example.springdemo;

public class SwimCoach implements Coach {
	private FortuneService fortuneService;

	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "This is going swimmingly!";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}
}
