package com.example.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
    return "employees/list-employees";
  }
  
  @GetMapping("/add")
  public String showAddEmployeeForm(Model model) {
    model.addAttribute("employee", new Employee());
    return "employees/employee-form";
  }
  
  @PostMapping("/save")
  public String saveEmployee(@ModelAttribute("employee") Employee employee) {
    employeeService.save(employee);
    return "redirect:/employees/list";
  }
}