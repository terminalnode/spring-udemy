package com.example.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppConfigurationClassDemoSwimCoach {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(ConfigurationClass.class);

		SwimCoach coach = context.getBean("swimCoach", SwimCoach.class);
		Coach alsoCoach = context.getBean("swimCoach", Coach.class);

		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getFortune());
		System.out.println("Is the bean singleton? " + (coach == alsoCoach));
		System.out.println(coach.getEmail());
		System.out.println(coach.getTeam());
		
		jesusFuckingChristJustDieAlready(context);
	}
	
	public static void jesusFuckingChristJustDieAlready(AnnotationConfigApplicationContext context) {
		context.close();
	}
}
