package com.example.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Customer {
  private String firstName;
  
  @NotNull(message="* required")
  @Size(min=1, message="* required")
  private String lastName;
  
  @NotNull(message="* required")
  @Min(value=0, message="free passes can't be negative!")
  @Max(value=10, message="too many free passes, max is 10!")
  private Integer freePasses;
  
  @Pattern(regexp="^\\d{3}\\s\\d{2}", message="* Swedish postal codes has format xxx xx")
  private String postalCode;
  
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

  public Integer getFreePasses() {
    return freePasses;
  }

  public void setFreePasses(Integer freePasses) {
    this.freePasses = freePasses;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }
}