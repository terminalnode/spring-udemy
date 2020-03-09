package com.example.springdemo;

import org.springframework.stereotype.Component;

@Component // default bean id is "tennisCoach"
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Smash those balls!";
	}
}
