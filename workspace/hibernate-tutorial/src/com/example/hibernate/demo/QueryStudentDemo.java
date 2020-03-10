package com.example.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml") // optional when using this default name
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Beginning transaction...");
			session.beginTransaction();
			
			System.out.println("Querying students...");
			List<Student> students = session
					.createQuery("from Student")
					.getResultList();

			System.out.println("Display students...");
			for (Student student : students) {
				System.out.println(student);
			}

			System.out.println("\nQuerying students whose lastName is Brute");
			students = session
					.createQuery("from Student s where s.lastName = 'Brute'")
					.getResultList();

			System.out.println("Display students whose lastName is Brute...");
			for (Student student : students) {
				System.out.println(student);
			}

			System.out.println("\nQuerying students whose lastName is Brute or Geek");
			students = session
					.createQuery("from Student s where s.lastName = 'Brute' OR s.lastName = 'Geek'")
					.getResultList();

			System.out.println("Display students whose lastName is Brute or Geek...");
			for (Student student : students) {
				System.out.println(student);
			}

			System.out.println("\nQuerying students whose email contains g1rl");
			students = session
					.createQuery("from Student s where s.email like '%g1rl%'")
					.getResultList();

			System.out.println("Display students whose email contains g1rl...");
			for (Student student : students) {
				System.out.println(student);
			}

			System.out.println("Commiting transaction...");
			session.getTransaction().commit();
			
			System.out.println("All done!");
		} finally {
			factory.close();
		}
	}
}