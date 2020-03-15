package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Course;
import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;
import com.example.hibernate.demo.entity.Review;

public class CreateCoursesAndReviewsDemo {

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
	    System.out.println("Beginning transaction...");
	    session.beginTransaction();

	    System.out.println("Creating course...");
	    Course course = new Course("Save yourself from COVID-19 through Udemy courses");
	    
	    System.out.println("Create some reviews for the course...");
	    Review review1 = new Review("The pizza was cold.");
	    Review review2 = new Review("The teacher was cold.");
	    Review review3 = new Review("The course was too haaaard!!");
	    Review review4 = new Review("Course was fun :-)");
	    Review review5 = new Review("I liked the course :-)");

	    System.out.println("Add the reviews to the course...");
	    course.addReview(review1);
	    course.addReview(review2);
	    course.addReview(review3);
	    course.addReview(review4);
	    course.addReview(review5);
	    
	    System.out.println("Save the course. Cascade will save the reviews as well.");
	    session.save(course);

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