package com.example.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

  public static void main(String[] args) {
    try {
      ObjectMapper mapper = new ObjectMapper();
      Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);
      System.out.println(student.getFirstName());
      System.out.println(student.getLastName());
      System.out.println(student.getAddress());
      
      System.out.print("Languages: [");
      for (String language : student.getLanguages()) {
        System.out.print(language + ", ");
      }
      System.out.println("]");
      
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}