package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Course;
import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;
import com.example.hibernate.demo.entity.Review;
import com.example.hibernate.demo.entity.Student;

public class AddCoursesForPutinDemo {

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

	    System.out.println("Fetch Putin from Students...");
	    Student putin = session.get(Student.class, 2);
	    System.out.println("Fetched: " + putin);
	    System.out.println("Current courses: " + putin.getCourses());
	    
	    System.out.println("Create some courses...");
	    Course course1 = new Course("Command & Conquer: Tiberian Sun - How to Clear the Nod Campaign.");
	    Course course2 = new Course("Kaizo Mario 2 - Deathless run");
	    Course course3 = new Course("Donkey Kong Country 2 - Ultimate Speedrun Course");
	    Course course4 = new Course("Red Alert 2 - Defeat the Russians With a Single Chrono Legionnaire");
	    
	    System.out.println("Add Putin to courses");
	    course1.addStudent(putin);
	    course2.addStudent(putin);
	    course3.addStudent(putin);
	    course4.addStudent(putin);
	    
	    System.out.println("Save the courses...");
	    session.save(course1);
	    session.save(course2);
	    session.save(course3);
	    session.save(course4);

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