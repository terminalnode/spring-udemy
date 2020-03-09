package com.example.springdemo;

public class BaseballCoach implements Coach {
	private FortuneService fortuneService;

	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Time to swing a bat around or something.";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}
}
