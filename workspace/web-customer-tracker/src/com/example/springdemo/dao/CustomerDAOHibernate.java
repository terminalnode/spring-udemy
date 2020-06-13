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
    Query<Customer> query = session.createQuery(
        "from Customer order by lastName", Customer.class);
    return query.getResultList();
  }

  @Override
  public void saveCustomer(Customer customer) {
    Session session = sessionFactory.getCurrentSession();
    session.saveOrUpdate(customer);
  }

  @Override
  public Customer getCustomer(long id) {
    Session session = sessionFactory.getCurrentSession();
    return session.get(Customer.class, id);
  }

  @Override
  public void deleteCustomer(long id) {
    Session session = sessionFactory.getCurrentSession();
    Query query = session.createQuery("delete from Customer where id=:customerId");
    query.setParameter("customerId", id);
    query.executeUpdate();
  }
}