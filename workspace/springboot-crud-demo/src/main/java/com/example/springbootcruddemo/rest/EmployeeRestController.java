package com.example.springbootcruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
  
  @GetMapping("/employees/{employeeId}")
  public Employee findById(@PathVariable int employeeId) {
    Employee employee = employeeService.findById(employeeId);
    
    if(employee == null) {
      // Very dirty runtime exception, in production we would've
      // added our own error handler
      throw new RuntimeException("Employee not found - id " + employeeId);
    }
    return employee;
  }
  
  @PostMapping("/employees")
  public Employee addEmployee(@RequestBody Employee employee) {
    employee.setId(0);
    employeeService.save(employee);
    return employee;
  }
}