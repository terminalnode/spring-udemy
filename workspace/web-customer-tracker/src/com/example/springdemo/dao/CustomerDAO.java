package com.example.springdemo.dao;

import java.util.List;

import com.example.springdemo.entity.Customer;

public interface CustomerDAO {
  public List<Customer> getCustomers();
  public void saveCustomer(Customer customer);
  public Customer getCustomer(long id);
  public void deleteCustomer(long id);
}