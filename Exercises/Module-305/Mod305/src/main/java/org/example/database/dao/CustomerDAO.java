package org.example.database.dao;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.example.database.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CustomerDAO {
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();


    public void insert(Customer customer){
        Session session = factory.openSession();

        session.getTransaction().begin();
        session.save(customer);
        session.getTransaction().commit();
        session.close();
    }

    public void update(Customer customer){
        Session session = factory.openSession();

        session.getTransaction().begin();
        session.merge(customer);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Customer customer){
        Session session = factory.openSession();

        session.getTransaction().begin();
        session.delete(customer);
        session.getTransaction().commit();
        session.close();
    }

    public List<Customer> findByCustomerName(String customerName) {
        // Mandatory to prepare Hibernate session for use.
        Session session = factory.openSession();

        String hql = "SELECT c FROM Customer c WHERE c.customerName = :customerName"; // SQL: SELECT * FROM customers c WHERE c.customer_name = "[INPUT]"
        TypedQuery<Customer> query = session.createQuery(hql, Customer.class);  // region Code Line Breakdown
        // Sets up the query. TypedQuery<InsertClassHere> will define the query type.
        // Session.createQuery() sets up the query but doesn't run it.
        // We insert the HQL into the first param, and the return type in the second param
        // endregion

        query.setParameter("customerName", customerName);
        // Similar to prepared statement. Setting query :customerName (line 16)
        // To value passed into the method.

        List<Customer> result = query.getResultList();

        session.close();
        return result;
    }

    public List<Customer> findByContactFirstName(String contactFirstName) {
        Session session = factory.openSession();

        String hql = "SELECT c FROM Customer c WHERE c.contactFirstname = :contactFirstName"; // SQL: SELECT * FROM customers c WHERE c.contact_firstname = "[INPUT]"
        TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
        // Sets up the query. TypedQuery<InsertClassHere> will define the query type.
        // Session.createQuery() sets up the query but doesn't run it.
        // We insert the HQL into the first param, and the return type in the second param

        query.setParameter("contactFirstName", contactFirstName);
        // Similar to prepared statement. Setting query :contactFirstName (line 16)
        // To value passed into the method.

        List<Customer> result = query.getResultList();

        session.close();
        return result;
    }

    public Customer findByID(Integer id) {
        Session session = factory.openSession();

        String hql = "SELECT c FROM Customer c WHERE c.id = :id";

        TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
        query.setParameter("id", id);

        try {
            Customer result = query.getSingleResult();
            return result;
        } catch (NoResultException e) {
            return null;
        } finally {
            session.close();
        }
    }
}