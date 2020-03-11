package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Course;
import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

  public static void main(String[] args) {
	  SessionFactory factory = new Configuration()
	      .configure("hibernate.cfg.xml") // optional when using this default name
	      .addAnnotatedClass(Instructor.class)
	      .addAnnotatedClass(InstructorDetail.class)
	      .addAnnotatedClass(Course.class)
	      .buildSessionFactory();
		
	  Session session = factory.getCurrentSession();
		
	  try {
	    System.out.println("Creating a new instructor object...");
	    Instructor instructor = new Instructor(
	        "Alexander",
	        "Rundberg",
	        "alexander.rundberg@email.com");
			
	    System.out.println("Creating a new instructor detail object...");
	    InstructorDetail instructorDetail = new InstructorDetail(
	        "https://www.youtube.com/screw_youtube",
	        "Programming");
			
	    System.out.println("Associating instructor and instructor detail...");
	    instructor.setInstructorDetail(instructorDetail);
			
	    System.out.println("Beginning transaction...");
	    session.beginTransaction();

	    System.out.println("Saving the new instructor to database...");
	    // Note that this will also save the instructor detail
	    // object because of CascadeType.ALL
	    session.save(instructor);

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