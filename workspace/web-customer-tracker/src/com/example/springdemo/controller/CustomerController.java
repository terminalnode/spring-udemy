package com.example.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springdemo.dao.CustomerDAO;
import com.example.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
  @Autowired
  private CustomerDAO customerDAO;

  @RequestMapping("/list")
  public String listCustomers(Model model) {
    List<Customer> customers = customerDAO.getCustomers();
    model.addAttribute("customers", customers);

    return "list-customers";
  }
}