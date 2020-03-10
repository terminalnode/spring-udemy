package com.example.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationScopeDemoApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach coach1 = context.getBean("tennisCoach", Coach.class);
		Coach coach2 = context.getBean("tennisCoach", Coach.class);
		
		System.out.println("Are they the same? " + (coach1 == coach2));
		System.out.println("ID for coach1: " + coach1);
		System.out.println("ID for coach2: " + coach2);
	}
}
