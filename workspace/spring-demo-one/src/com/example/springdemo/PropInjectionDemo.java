package com.example.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropInjectionDemo {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getFortune());

		System.out.println("\nLiteral values injected through applicationContext.xml");
		System.out.println(theCoach.getEmailAddress());
		System.out.println(theCoach.getTeamName());
		
		context.close();
	}
}
