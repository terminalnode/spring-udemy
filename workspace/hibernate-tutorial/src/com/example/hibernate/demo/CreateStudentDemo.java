package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml") // optional when using this default name
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating a new student object...");
			Student tempStudent = new Student("Some", "Nerd", "nerdyb0i@gmail.com");
			
			System.out.println("Beginning transaction...");
			session.beginTransaction();

			System.out.println("Saving the new student object to database...");
			session.save(tempStudent);

			System.out.println("Commiting transaction...");
			session.getTransaction().commit();
			
			System.out.println("All done!");
		} finally {
			factory.close();
		}
	}
}