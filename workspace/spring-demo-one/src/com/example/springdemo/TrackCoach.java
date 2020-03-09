package com.example.springdemo;

public class TrackCoach implements Coach {
	private FortuneService fortuneService;

	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run for your life, the baseball coach is coming for you!";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}
}
