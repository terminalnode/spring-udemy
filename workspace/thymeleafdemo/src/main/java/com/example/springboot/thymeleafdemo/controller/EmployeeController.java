package com.example.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springboot.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
  private List<Employee> employees;
  
  @PostConstruct
  private void loadEmployees() {
    employees = new ArrayList<>();
    employees.add(new Employee(1, "John", "Wayne", "john@amail.com"));
    employees.add(new Employee(2, "Mary", "Louise", "mary@bmail.com"));
    employees.add(new Employee(3, "Louise", "Martin", "louise@cmail.com"));
    employees.add(new Employee(4, "Alfred", "Gorbachev", "alfred@dmail.com"));
    employees.add(new Employee(5, "Kraken", "Smith", "alfred@email.com"));
  }

  @GetMapping("/list")
  public String listEmployees(Model model) {
    System.out.println(employees);
    model.addAttribute("employees", employees);
    return "list-employees";
  }
}