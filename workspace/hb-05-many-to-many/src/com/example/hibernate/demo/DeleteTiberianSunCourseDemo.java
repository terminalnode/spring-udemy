package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Course;
import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;
import com.example.hibernate.demo.entity.Review;
import com.example.hibernate.demo.entity.Student;

public class DeleteTiberianSunCourseDemo {

  public static void main(String[] args) {
	  SessionFactory factory = new Configuration()
	      .configure("hibernate.cfg.xml") // optional when using this default name
	      .addAnnotatedClass(Instructor.class)
	      .addAnnotatedClass(InstructorDetail.class)
	      .addAnnotatedClass(Course.class)
	      .addAnnotatedClass(Student.class)
	      .addAnnotatedClass(Review.class)
	      .buildSessionFactory();
		
	  Session session = factory.getCurrentSession();
		
	  try {
	    System.out.println("Beginning transaction...");
	    session.beginTransaction();

	    System.out.println("Get Tiberian Sun course from course ID...");
	    Course course = session.get(Course.class, 3);
	    System.out.println("Fetched: " + course);
	    
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