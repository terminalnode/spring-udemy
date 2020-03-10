package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
	public static void main(String[] args) {
		try {
			String jdbcUrl = "jdbc:postgresql://localhost:5432/hb_student_tracker";
			String user = "hbstudent";
			String password = "hbstudent";
			DriverManager.getConnection(jdbcUrl, user, password);

			System.out.println("Connection successful!");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
