package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml") // optional when using this default name
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 10; // adjust to whatever ids you have in the database
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			
			// retrieve student based on the id (primary key)
			Student student = session.get(Student.class, studentId);
			System.out.println("Got the sunnuva gun:\n" + student);
			
			// edit the student object
			System.out.println("Updating student...");
			student.setFirstName("Lilla My");
			session.getTransaction().commit();
			
			// start new transaction thing updating the emails of all students
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Update the email addresses for all students!");
			session.createQuery("update Student set email = 'ir@baboon.com'")
				.executeUpdate();
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("All done!");
		} finally {
			factory.close();
		}
	}

}
