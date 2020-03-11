package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

  public static void main(String[] args) {
    SessionFactory factory = new Configuration().configure("hibernate.cfg.xml") // optional when using this default name
        .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

    Session session = factory.getCurrentSession();

    try {
      int id = 2; // Change to some id you have in the database.

      System.out.println("Beginning transaction...");
      session.beginTransaction();

      System.out.println("Getting instructor...");
      Instructor instructor = session.get(Instructor.class, id);
      System.out.println("Found instructor: " + instructor);

      if (instructor != null) {
        System.out.println("Deleting instructor...");
        // Will also delete instructor detail because of cascadetype
        session.delete(instructor);
      }

      System.out.println("Commiting transaction...");
      session.getTransaction().commit();

      System.out.println("All done!");
    } finally {
      factory.close();
    }
  }
}