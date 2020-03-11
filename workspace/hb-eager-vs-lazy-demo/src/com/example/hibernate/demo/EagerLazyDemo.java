package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Course;
import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

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

	    // Committing the transaction before getting the courses,
	    // or more accurately getting the courses after committing
	    // our transaction, will cause a LazyInitializationException.
	    // The course tells us the session needs to be closed, but
	    // this doesn't seem to be true for the current version of spring.
	    //System.out.println("Commiting transaction...");
	    //session.getTransaction().commit();
	    
	    System.out.println("Print out all the instructor courses...");
	    // If using lazy loading, the courses won't be fetched until
	    // this line below is hit (instructor.getCourses())
	    for (Course course : instructor.getCourses()) {
	      System.out.println(course);
	    }
	    
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