package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.example.hibernate.demo.entity.Course;
import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
	    Query<Instructor> query = session.createQuery(
	        "select i from Instructor i " +
	        "JOIN FETCH i.courses " +
	        "where i.id=:instructorId",
	        Instructor.class);
	    
	    System.out.println("Setting instructor id in the query...");
	    query.setParameter("instructorId", id);

	    System.out.println("Execute query to get instructor...");
	    Instructor instructor = query.getSingleResult();
	    System.out.println("Got: " + instructor);
	    
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