package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Course;
import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

  public static void main(String[] args) {
	  SessionFactory factory = new Configuration()
	      .configure("hibernate.cfg.xml") // optional when using this default name
	      .addAnnotatedClass(Instructor.class)
	      .addAnnotatedClass(InstructorDetail.class)
	      .addAnnotatedClass(Course.class)
	      .buildSessionFactory();
		
	  Session session = factory.getCurrentSession();
		
	  try {
	    int id = 1; // change to something in your database

	    System.out.println("Beginning transaction...");
	    session.beginTransaction();

	    System.out.println("Fetching instructor...");
	    Instructor instructor = session.get(Instructor.class, id);
	    System.out.println("Got: " + instructor);
	    
	    System.out.println("Creating some courses...");
	    Course course1 = new Course("Haskell from First Principles");
	    Course course2 = new Course("Automating the Boring Stuff with Python");
	    Course course3 = new Course("Clean Code");
	    
	    System.out.println("Associate courses with the constructor...");
	    instructor.add(course1);
	    instructor.add(course2);
	    instructor.add(course3);
	    
	    System.out.println("Saving the courses...");
	    session.save(course1);
	    session.save(course2);
	    session.save(course3);

	    System.out.println("Commiting transaction...");
	    session.getTransaction().commit();
	    System.out.println("All done!");

	  } catch (Exception exc) {
	   exc.printStackTrace(); 

	  } finally {
	    session.close();
	    factory.close();
	  }
  }
}