package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

  public static void main(String[] args) {
    SessionFactory factory = new Configuration().configure("hibernate.cfg.xml") // optional when using this default name
        .addAnnotatedClass(Student.class).buildSessionFactory();

    Session session = factory.getCurrentSession();

    try {
      int studentId = 6; // adjust to whatever ids you have in the database
      session = factory.getCurrentSession();
      session.beginTransaction();

      // retrieve student based on the id (primary key)
      System.out.println("Retrieving student...");
      Student student = session.get(Student.class, studentId);
      System.out.println("=> Got the sunnuva gun:\n" + student);

      // delete the student
      System.out.println("Deleting student...");
      session.delete(student);

      // delete another student
      session.createQuery("delete Student where id = 7").executeUpdate();

      // commit transaction
      session.getTransaction().commit();

      System.out.println("All done!");
    } finally {
      factory.close();
    }
  }

}
