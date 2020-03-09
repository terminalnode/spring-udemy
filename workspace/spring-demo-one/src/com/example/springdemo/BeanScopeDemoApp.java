package com.example.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		// Same if using scope="prototype" for "myCoach",
		// different if scope="singleton" or if scope is undefined
		// (which defaults to singleton)
		boolean sameCoach = (theCoach == alphaCoach);
		System.out.println("Are they the same?\n" + sameCoach + "\n");
		System.out.println("Memory location theCoach:   " + theCoach);
		System.out.println("Memory location alphaCoach: " + alphaCoach);

		// We can actually close this right after instantiation.
		context.close();
	}
}
