package com.example.springbootcruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootcruddemo.entity.Employee;
import com.example.springbootcruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
  private EmployeeService employeeService;
  
  @Autowired
  public EmployeeRestController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }
  
  @GetMapping("/employees")
  public List<Employee> findAll() {
    return employeeService.findAll();
  }
}