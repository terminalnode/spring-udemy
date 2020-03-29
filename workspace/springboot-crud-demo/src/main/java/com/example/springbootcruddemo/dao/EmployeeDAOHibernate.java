package com.example.springbootcruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.springbootcruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernate implements EmployeeDAO {
  private EntityManager entityManager;
  
  @Autowired
  public EmployeeDAOHibernate(EntityManager entityManager) {
    this.entityManager = entityManager;
  }
  
  @Override
  @Transactional
  public List<Employee> findAll() {
    Session session = entityManager.unwrap(Session.class);
    Query<Employee> query = session.createQuery("from Employee", Employee.class);
    return query.getResultList();
  }
}
