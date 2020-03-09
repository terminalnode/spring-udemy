package com.example.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleDemoApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("beanLifecycle-applicationContext.xml");
		
		// Prints init-method on initialization
		Coach theCoach = context.getBean("myCoach", Coach.class);
		// Then print the method output
		System.out.println(theCoach.getDailyWorkout());
		// When program exits, calls destroy method

		context.close();
	}
}
