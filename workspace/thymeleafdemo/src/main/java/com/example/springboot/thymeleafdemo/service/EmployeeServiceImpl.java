package com.example.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.example.springboot.thymeleafdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
  private EmployeeRepository employeeRepository;
  
  @Autowired
  public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }
  
  @Override
  public List<Employee> findAll() {
    return employeeRepository.findAllByOrderByLastNameAsc();
  }

  @Override
  public Employee findById(int id) {
    Optional<Employee> result = employeeRepository.findById(id);
    
    if (result.isPresent()) {
      return result.get();
    }
    
    // No result found
    throw new RuntimeException("Could not find employee with ID " + id);
  }

  @Override
  public void save(Employee employee) {
    employeeRepository.save(employee);
  }

  @Override
  public void deleteById(int id) {
    employeeRepository.deleteById(id);
  }
}