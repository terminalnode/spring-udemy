package com.example.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
  // No need for any additional code. By extending JpaRepository<Employee, Integer>
  // we get all basic CRUD methods for this type for free. Cool beans.
  
  // Springs JpaRepository thing will automatically guess what we mean
  // by parsing the name of the method. Cool beans.
  public List<Employee> findAllByOrderByLastNameAsc();
}