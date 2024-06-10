package org.example.database.dao;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.example.database.entity.Employee;
import org.example.database.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ProductDAO {

    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void insert( Product product) {
        // these 2 lines of code prepare the hibernate session for use
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        session.getTransaction().begin();   // begin the transaction
        session.save(product);             // insert the employee to the database
        session.getTransaction().commit();  // commit our transaction
        session.close();                    // cleanup the session
    }
    public void update( Product product) {
        // these 2 lines of code prepare the hibernate session for use
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        session.getTransaction().begin();   // begin the transaction
        session.merge(product);             // insert the employee to the database
        session.getTransaction().commit();  // commit our transaction
        session.close();                    // cleanup the session
    }
    public void delete( Product product) {
        // these 2 lines of code prepare the hibernate session for use
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        session.getTransaction().begin();   // begin the transaction
        session.delete(product);             // insert the employee to the database
        session.getTransaction().commit();  // commit our transaction
        session.close();                    // cleanup the session
    }
    public Product findByID(Integer id) {
        Session session = factory.openSession();

        String hql = "SELECT p from Product p WHERE p.id = :id";

        TypedQuery<Product> query = session.createQuery(hql, Product.class);
        query.setParameter("id", id);

        try {
            Product result = query.getSingleResult();
            return result;
        } catch (NoResultException e){
            return null;
        } finally {
            session.close();
        }
    }

    public List<Product> findByName(String productName) {
        Session session = factory.openSession();

        String hql = "SELECT p from Product p WHERE p.productName  = :productName";

        TypedQuery<Product> query = session.createQuery(hql, Product.class);
        query.setParameter("productName", productName);

        List<Product> products = query.getResultList();

        session.close();

        return products;
    }

    public List<Product> findLikeName(String productName) {
        Session session = factory.openSession();

        String hql = "SELECT p from Product p WHERE p.productName LIKE CONCAT('%', :productName, '%')";

        TypedQuery<Product> query = session.createQuery(hql, Product.class);
        query.setParameter("productName", productName);

        List<Product> products = query.getResultList();

        session.close();

        return products;
    }

}