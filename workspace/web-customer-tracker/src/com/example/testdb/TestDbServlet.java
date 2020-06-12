package com.example.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String user = "springstudent";
	  String pass = "springstudent";
    String jdbcUrl = "jdbc:postgresql://localhost:5432/web_customer_tracker";
    String driver = "org.postgresql.Driver";

    try {
      PrintWriter out = response.getWriter();
      Class.forName(driver);
      Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
      out.println("Success!");
      myConn.close();
      
    } catch (Exception exc) {
      exc.printStackTrace();
    }
	}
}
