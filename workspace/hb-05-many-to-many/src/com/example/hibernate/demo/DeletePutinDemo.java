package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Course;
import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;
import com.example.hibernate.demo.entity.Review;
import com.example.hibernate.demo.entity.Student;

public class DeletePutinDemo {

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
	    int id = 2; // change to whatever ID Putin has in your db

	    System.out.println("Beginning transaction...");
	    session.beginTransaction();

	    System.out.println("Fetch Putin from Students...");
	    Student putin = session.get(Student.class, id);
	    System.out.println("Fetched: " + putin);
	    System.out.println("Current courses: " + putin.getCourses());
	    
	    System.out.println("Deleting student...");
	    session.delete(putin);
	    
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