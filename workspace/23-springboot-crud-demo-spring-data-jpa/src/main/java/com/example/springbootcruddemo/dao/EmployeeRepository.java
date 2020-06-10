package com.example.springbootcruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootcruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
  // No need for any additional code. By extending JpaRepository<Employee, Integer>
  // we get all basic CRUD methods for this type for free. Cool beans.
}