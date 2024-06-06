package org.example.database.dao;

import jakarta.persistence.TypedQuery;
import org.example.database.entity.Customers;
import org.example.database.entity.Employees;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CustomersDAO {

    public List<Customers> findByCustomerName(String customerName) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();


        String hql = "SELECT c FROM Customers c where c.customerName = :customerName";

        TypedQuery<Customers> query = session.createQuery(hql,Customers.class);
// SQL: SELECT * FROM customers c WHERE c.customer_name = "[INPUT]"
// region Code Line Breakdown
// Sets up the query. TypedQuery<InsertClassHere> will define the query type.
// Session.createQuery() sets up the query but doesn't run it.
// We insert the HQL into the first param, and the return type in the second param
// endregion

        query.setParameter("customerName", customerName);
// region Code Line Breakdown
// Similar to prepared statement. Setting query :customerName (line 16)
// To value passed into the method.
// endregion

        List<Customers> result = query.getResultList();

        session.close();

        return result;

    }

    public List<Customers> findByContactFirstName(String contactFirstName) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();


        String hql = "SELECT c FROM Customers c WHERE c.contactFirstName = :contactFirstName";
        // SQL: SELECT * FROM customers c WHERE c.contact_firstname = "[INPUT]"

        TypedQuery<Customers> query = session.createQuery(hql, Customers.class);
// region Code Line Breakdown
// Sets up the query. TypedQuery<InsertClassHere> will define the query type.
// Session.createQuery() sets up the query but doesn't run it.
// We insert the HQL into the first param, and the return type in the second param
// endregion

        query.setParameter("contactFirstName", contactFirstName);
// region Code Line Breakdown
// Similar to prepared statement. Setting query :contactFirstName (line 16)
// To value passed into the method.
// endregion

        List<Customers> result = query.getResultList();

        session.close();

        return result;

    }

    public void insert( Customers customer) {

        //first two lines of code begin the hibernate session
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // begin the transaction
        session.getTransaction().begin();

        // insert the employee to the database
        session.save(customer);

        /// commit our transaction
        session.getTransaction().commit();

        // cleanup the session
        session.close();


    }

    public void update(Customers customers) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.merge(customers);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Customers customers) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.delete(customers);
        session.getTransaction().commit();
        session.close();
    }

    public Customers findById(Integer id) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();


        String hql = "SELECT c FROM Customers c where c.id = :id";

        TypedQuery<Customers> query = session.createQuery(hql,Customers.class);


        query.setParameter("id", id);


        try {
            Customers result = query.getSingleResult();
            return result;
        } catch ( Exception e ) {
            return null;
        } finally {
            session.close();

        }

    }



}