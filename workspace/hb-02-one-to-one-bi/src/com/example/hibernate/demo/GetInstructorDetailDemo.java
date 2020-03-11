package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {
  public static void main(String[] args) {
    SessionFactory factory = new Configuration()
        .configure("hibernate.cfg.xml") // optional when using this default name
        .addAnnotatedClass(Instructor.class)
        .addAnnotatedClass(InstructorDetail.class)
        .buildSessionFactory();
		
    Session session = factory.getCurrentSession();
		
    try {
      int id = 2; // add some id that's in your database, run CreateDemo to generate new ones

      System.out.println("Beginning transaction...");
      session.beginTransaction();
			
      System.out.println("Fetching our instructorDetail...");
      InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
			
      System.out.println("Print the associated instructor...");
      System.out.println(instructorDetail.getInstructor());

      System.out.println("Commiting transaction...");
      session.getTransaction().commit();
			
      System.out.println("All done!");
    } catch (Exception exc) {
      exc.printStackTrace();
    }finally {
      session.close();
      factory.close();
    }
  }
}