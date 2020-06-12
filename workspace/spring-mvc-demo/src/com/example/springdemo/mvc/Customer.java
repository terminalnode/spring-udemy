package com.example.springdemo.mvc;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {
  private String firstName;
  
  @NotNull(message="* required")
  @Size(min=1, message="* required")
  private String lastName;
  
  public Customer() {
  }
  
  @Override
  public String toString() {
    return String.format(
        "Customer(firstName='%s', lastName='%s')",
        firstName, lastName
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