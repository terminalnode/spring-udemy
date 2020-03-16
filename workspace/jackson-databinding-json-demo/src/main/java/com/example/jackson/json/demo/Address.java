package com.example.jackson.json.demo;

public class Address {
  private String street;
  private String city;
  private String zip;
  private String state;
  private String country;
  
  public Address() {
    // no arg constructor
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  @Override
  public String toString() {
    return "Address [street=" + street + ", city=" + city + ", zip=" + zip + ", state=" + state + ", country=" + country
        + "]";
  }
}
