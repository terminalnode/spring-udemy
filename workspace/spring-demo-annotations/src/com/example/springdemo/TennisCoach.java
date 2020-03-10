package com.example.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // default bean id is "tennisCoach"
@Scope("prototype")
public class TennisCoach implements Coach {
	private FortuneService fortuneService;
	
	// with a single constructor, autowire annotation on a
	// constructor like this is actually not necessary
	// starting with Spring Framework 4.3. if there are
	// several constructors available however, you do need it.
	@Autowired
	public TennisCoach(@Qualifier("randomFortuneService") FortuneService fortuneService) {
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
