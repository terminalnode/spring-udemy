package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Course;
import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;
import com.example.hibernate.demo.entity.Review;
import com.example.hibernate.demo.entity.Student;

public class CreateCoursesAndStudentsDemo {

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

	    System.out.println("Creating course...");
	    Course course = new Course("Save Yourself from Corona with Toilet Paper");
	    
	    System.out.println("Save the course...");
	    session.save(course);
	    System.out.println("Course saved!");
	    
	    System.out.println("Create some students for the course...");
	    Student student1 = new Student("Donald", "Trump", "donald@trump.com");
	    Student student2 = new Student("Vladimir", "Putin", "president@putin.ru");
	    Student student3 = new Student("Johan Sebastian", "Bach", "music4life@philharmoniker.de");

	    System.out.println("Add the students to the course...");
	    course.addStudent(student1);
	    course.addStudent(student2);
	    course.addStudent(student3);
	    
	    System.out.println("Save the students");
	    session.save(student1);
	    session.save(student2);
	    session.save(student3);
	    
	    //System.out.println("Save the course. Cascade will save the students as well.");
	    //session.save(course);

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