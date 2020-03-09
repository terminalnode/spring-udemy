package com.example.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // default bean id is "tennisCoach"
public class TennisCoach implements Coach {
	private FortuneService fortuneService;
	
	// with a single constructor, autowire annotation on a
	// constructor like this is actually not necessary
	// starting with Spring Framework 4.3. if there are
	// several constructors available however, you do need it.
	@Autowired
	public TennisCoach(FortuneService fortuneService) {
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
