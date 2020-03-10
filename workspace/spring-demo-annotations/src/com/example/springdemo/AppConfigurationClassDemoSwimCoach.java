package com.example.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppConfigurationClassDemoSwimCoach {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(ConfigurationClass.class);

		Coach coach = context.getBean("swimCoach", Coach.class);
		Coach alsoCoach = context.getBean("swimCoach", Coach.class);
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getFortune());
		System.out.println("Is the bean singleton? " + (coach == alsoCoach));
		
		jesusFuckingChristJustDieAlready(context);
	}
	
	public static void jesusFuckingChristJustDieAlready(AnnotationConfigApplicationContext context) {
		context.close();
	}
}
