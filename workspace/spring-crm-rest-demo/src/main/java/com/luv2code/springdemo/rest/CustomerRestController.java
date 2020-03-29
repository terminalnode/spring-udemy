package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
  @Autowired
  private CustomerService customerService;
  
  @GetMapping("/customers")
  public List<Customer> getCustomers() {
    return customerService.getCustomers();
  }
  
  @GetMapping("/customers/{customerId}")
  public Customer getCustomer(@PathVariable int customerId) {
    Customer customer = customerService.getCustomer(customerId);

    if (customer == null) {
      throw new CustomerNotFoundException("Customer id not found - " + customerId);
    }

    return customer;
  }
  
  @PostMapping("/customers")
  public Customer createCustomer(@RequestBody Customer customer) {
    customer.setId(0);
    customerService.saveCustomer(customer);
    
    if (customer.getFirstName() == null || customer.getLastName() == null || customer.getEmail() == null) {
      throw new CustomerMissingFieldsException("One or more required fields missing!");
    }
    return customer;
  }
  
  @PutMapping("/customers")
  public Customer updateCustomer(@RequestBody Customer customer) {
    // This method has several errors that we could solve if we felt like it.
    // If an ID isn't supplied, a new user is created. This is probably not desirable.
    // If a field isn't included, such as lastName, this will be replaced with null.
    // Probably also not desired.
    customerService.saveCustomer(customer);
    return customer;
  }
}