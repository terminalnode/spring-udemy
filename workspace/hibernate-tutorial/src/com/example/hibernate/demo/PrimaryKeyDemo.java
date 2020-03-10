package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml") // optional when using this default name
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating three student objects...");
			Student tempStudent1 = new Student("Some", "Nerd", "nerdyb0i@gmail.com");
			Student tempStudent2 = new Student("Some", "Geek", "geekyg1rl@gmail.com");
			Student tempStudent3 = new Student("Some", "Brute", "brutyb0i@gmail.com");
			
			System.out.println("Beginning transaction...");
			session.beginTransaction();

			System.out.println("Saving the new student object to database...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			System.out.println("Commiting transaction...");
			session.getTransaction().commit();
			
			System.out.println("All done!");
		} finally {
			factory.close();
		}
	}
}