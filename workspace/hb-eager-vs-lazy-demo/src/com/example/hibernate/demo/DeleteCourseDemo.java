package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Course;
import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;

public class DeleteCourseDemo {

  public static void main(String[] args) {
	  SessionFactory factory = new Configuration()
	      .configure("hibernate.cfg.xml") // optional when using this default name
	      .addAnnotatedClass(Instructor.class)
	      .addAnnotatedClass(InstructorDetail.class)
	      .addAnnotatedClass(Course.class)
	      .buildSessionFactory();
		
	  Session session = factory.getCurrentSession();
		
	  try {
	    int id = 2; // replace with a course in your database

	    System.out.println("Beginning transaction...");
	    session.beginTransaction();
	    
	    System.out.println("Fetching course...");
	    Course course = session.get(Course.class, id);
	    
	    System.out.println("Deleting course...");
	    session.delete(course);
	    
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