package com.example.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleDemoApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("beanLifecycle-applicationContext.xml");
		
		// Prints init-method on initialization
		Coach coachSingleton = context.getBean("myCoachSingleton", Coach.class);
		Coach coachPrototype = context.getBean("myCoachPrototype", Coach.class);
		// Then print the method output
		System.out.println(coachSingleton.getDailyWorkout());
		System.out.println(coachPrototype.getDailyWorkout());

		// When program exits, calls destroy method,
		// but ONLY for the singleton! Prototypes are
		// not managed by spring after initialization.
		// The init-method will be called, but the destroy-method will not.

		context.close();
	}
}
