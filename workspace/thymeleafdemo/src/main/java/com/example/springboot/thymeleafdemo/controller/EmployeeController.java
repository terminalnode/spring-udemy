package com.example.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springboot.thymeleafdemo.entity.Employee;
import com.example.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
  @Autowired
  EmployeeService employeeService;
  
  @GetMapping("/list")
  public String listEmployees(Model model) {
    List<Employee> employees = employeeService.findAll();
    model.addAttribute("employees", employees);
    return "list-employees";
  }
}