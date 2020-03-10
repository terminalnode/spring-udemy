package com.example.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {
	private FortuneService fortuneService;

	@Value("${bruh.email}")
	private String email;

	@Value("${bruh.team}")
	private String team;

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
	
	public String getEmail() {
		return email;
	}
	
	public String getTeam() {
		return team;
	}
}
