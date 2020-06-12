package com.example.springdemo.mvc;

public class Student {
  private String firstName;
  private String lastName;
  
  public Student() {
  }
  
  @Override
  public String toString() {
    return String.format(
        "Student(firstName='%s', lastName='%s')",
        firstName,
        lastName
        );
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}