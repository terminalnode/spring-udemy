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
  public List<Employee> findAll() {
    Session session = entityManager.unwrap(Session.class);
    Query<Employee> query = session.createQuery("from Employee", Employee.class);
    return query.getResultList();
  }

  @Override
  public Employee findById(int id) {
    Session session = entityManager.unwrap(Session.class);
    Employee employee = session.get(Employee.class, id);

    return employee;
  }

  @Override
  public void save(Employee employee) {
    Session session = entityManager.unwrap(Session.class);
    session.saveOrUpdate(employee);
  }

  @Override
  public void deleteById(int id) {
    Session session = entityManager.unwrap(Session.class);

    // By not using the query we can easily add a check at a
    // later date to see that the employee does indeed exist
    Employee employee = session.get(Employee.class, id);
    session.delete(employee);
  }
}