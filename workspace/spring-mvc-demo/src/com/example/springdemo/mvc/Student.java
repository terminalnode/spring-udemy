package com.example.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
  private String firstName;
  private String lastName;
  private String country;
  private String favouriteLanguage;
  private LinkedHashMap<String, String> countryOptions;
  
  public Student() {
    // populate country options using ISO country code
    countryOptions = new LinkedHashMap<>();
    countryOptions.put("SE", "Sweden");
    countryOptions.put("PL", "Poland");
    countryOptions.put("FR", "France");
    countryOptions.put("JP", "Japan");
  }
  
  @Override
  public String toString() {
    return String.format(
        "Student(firstName='%s', lastName='%s', country='%s', favouriteLanguage='%s')",
        firstName,
        lastName,
        country,
        favouriteLanguage
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

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public LinkedHashMap<String, String> getCountryOptions() {
    return countryOptions;
  }

  public String getFavouriteLanguage() {
    return favouriteLanguage;
  }

  public void setFavouriteLanguage(String favouriteLanguage) {
    this.favouriteLanguage = favouriteLanguage;
  }
  
}