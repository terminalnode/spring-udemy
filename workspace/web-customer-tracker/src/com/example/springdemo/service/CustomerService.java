package com.example.springdemo.service;

import java.util.List;

import com.example.springdemo.entity.Customer;

public interface CustomerService {
  public List<Customer> getCustomers();
  public void saveCustomer(Customer customer);
  public Customer getCustomer(long id);
  public void deleteCustomer(long id);
}