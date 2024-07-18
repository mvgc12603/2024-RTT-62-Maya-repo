package org.example.database.dao;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.example.database.entity.Order;
import org.example.database.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class OrderDAO {

    // Outside of related methods, making it necessary to make private - this makes sure it's contained within the OrderDAO class
    // Keeping it as a class variable means we don't have to declare it within each method.

    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void insert(Order order) {
        Session session = factory.openSession(); // Creates individual session

        session.getTransaction().begin();   // begin the transaction
        session.save(order);             // insert the employee to the database
        session.getTransaction().commit();  // commit our transaction
        session.close();                    // cleanup the session
    }

    public void update(Order order) {
        Session session = factory.openSession(); // Creates individual session

        session.getTransaction().begin();   // begin the transaction
        session.merge(order);             // insert the employee to the database
        session.getTransaction().commit();  // commit our transaction
        session.close();                    // cleanup the session
    }

    public void delete(Order order) {
        Session session = factory.openSession(); // Creates individual session

        session.getTransaction().begin();   // begin the transaction
        session.delete(order);             // insert the employee to the database
        session.getTransaction().commit();  // commit our transaction
        session.close();                    // cleanup the session
    }

    public List<Order> findByCustomerID(Integer customerID) {
        Session session = factory.openSession();

        String hql = "SELECT o from Order o WHERE o.customerID = :customerID";
        TypedQuery<Order> query = session.createQuery(hql, Order.class);

        query.setParameter("customerID", customerID);

        List<Order> result = query.getResultList();

        session.close();
        return result;
    }

    public Order findByOrderID(Integer orderID) {
        Session session = factory.openSession();

        String hql = "SELECT o FROM Order o WHERE o.id = :orderID";         // Set up HQL [SQL Equivalent: SELECT * FROM order WHERE order.id = ?]
        TypedQuery<Order> query = session.createQuery(hql, Order.class);    // Format a query using the HQL string and a pointer to the order class
        query.setParameter("orderID", orderID);                           // Set parameters using query

        // get single result - remember to do try catch to catch potential null values
        try {
            Order result = query.getSingleResult();
            return result;
        } catch (NoResultException e) {
            System.out.println("No order with order id " + orderID + " found.");
            return null;
        } finally {
            session.close();    // Important to close sessions once you're done or you will explode. :(
        }
    }
}
