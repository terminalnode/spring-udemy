package com.example.springbootcruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springbootcruddemo.dao.EmployeeRepository;
import com.example.springbootcruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
  private EmployeeRepository employeeRepository;
  
  @Autowired
  public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }
  
  @Override
  public List<Employee> findAll() {
    return employeeRepository.findAll();
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