package com.example.springbootcruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springbootcruddemo.entity.Employee;

@Repository
public class EmployeeDAOJPA implements EmployeeDAO {
  private EntityManager entityManager;
  
  @Autowired
  public EmployeeDAOJPA(EntityManager entityManager) {
    this.entityManager = entityManager;
  }
  
  @Override
  public List<Employee> findAll() {
    Query query = entityManager.createQuery("from Employee");
    List<Employee> employees = query.getResultList();
    return employees;
  }

  @Override
  public Employee findById(int id) {
    return entityManager.find(Employee.class, id);
  }

  @Override
  public void save(Employee employee) {
    Employee dbEmployee = entityManager.merge(employee);
    employee.setId(dbEmployee.getId());
  }

  @Override
  public void deleteById(int id) {
    Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
    query.setParameter("employeeId", id);
    query.executeUpdate();
  }

}
