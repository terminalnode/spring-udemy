package com.example.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springdemo.entity.Customer;

@Repository
public class CustomerDAOHibernate implements CustomerDAO {
  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public List<Customer> getCustomers() {
    Session session = sessionFactory.getCurrentSession();
    Query<Customer> query = session.createQuery("from Customer", Customer.class);
    return query.getResultList();
  }
}