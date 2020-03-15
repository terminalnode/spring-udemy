package com.example.jdbc;

import java.sql.DriverManager;

public class TestJdbc {
  public static void main(String[] args) {
    try {
      String jdbcUrl = "jdbc:postgresql://localhost:5432/hb_01_one_to_one_uni";
      String user = "hbstudent";
      String password = "hbstudent";
      DriverManager.getConnection(jdbcUrl, user, password);

      System.out.println("Connection successful!");
    } catch (Exception exc) {
      exc.printStackTrace();
    }

  }
}
