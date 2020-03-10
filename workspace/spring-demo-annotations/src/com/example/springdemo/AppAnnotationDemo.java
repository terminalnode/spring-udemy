package com.example.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppAnnotationDemo {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach theNewCoach = context.getBean("newTennisCoach", Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theNewCoach.getDailyWorkout());
		System.out.println(theCoach.getFortune()); // constructor injection
		System.out.println(theNewCoach.getFortune()); // setter injection
		
		context.close();
	}
}