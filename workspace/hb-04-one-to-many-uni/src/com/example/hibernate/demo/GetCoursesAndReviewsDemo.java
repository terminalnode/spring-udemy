package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Course;
import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;
import com.example.hibernate.demo.entity.Review;

public class GetCoursesAndReviewsDemo {

  public static void main(String[] args) {
	  SessionFactory factory = new Configuration()
	      .configure("hibernate.cfg.xml") // optional when using this default name
	      .addAnnotatedClass(Instructor.class)
	      .addAnnotatedClass(InstructorDetail.class)
	      .addAnnotatedClass(Course.class)
	      .addAnnotatedClass(Review.class)
	      .buildSessionFactory();
		
	  Session session = factory.getCurrentSession();
		
	  try {
	    int id = 2; // change to some id present in your db
	    
	    System.out.println("Beginning transaction...");
	    session.beginTransaction();

	    System.out.println("Getting the course...");
	    Course course = session.get(Course.class, id);
	    
	    System.out.println("\nGot this course:");
	    System.out.println(course);
	    
	    System.out.println("\nThe reviews:");
	    System.out.println(course.getReviews());
	    System.out.println();

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