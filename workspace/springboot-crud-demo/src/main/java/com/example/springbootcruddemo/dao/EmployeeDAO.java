package com.example.springbootcruddemo.dao;

import java.util.List;

import com.example.springbootcruddemo.entity.Employee;

public interface EmployeeDAO {
  public List<Employee> findAll();
}