package org.example.database.dao;

import org.example.database.entity.OrderDetail;
import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OrderDetailDAO {

    private SessionFactory factory = new Configuration().configure().buildSessionFactory();


    public void insert(OrderDetail orderDetails){
        Session session = factory.openSession();

        session.getTransaction().begin();
        session.save(orderDetails);
        session.getTransaction().commit();
        session.close();
    }

    public void update(OrderDetail orderDetails){
        Session session = factory.openSession();

        session.getTransaction().begin();
        session.merge(orderDetails);
        session.getTransaction().commit();
        session.close();
    }

    public OrderDetail findByOrderIdAndProductId(Integer orderId, Integer productId) {
        Session session = factory.openSession();

        String hql = "SELECT od FROM OrderDetails od where od.product.id = :productId and od.order.id = :orderId";

        TypedQuery<OrderDetail> query = session.createQuery(hql,OrderDetail.class);
        query.setParameter("orderId", orderId);
        query.setParameter("productId", productId);

        try {
            OrderDetail result = query.getSingleResult();
            return result;
        } catch ( Exception e ) {
            return null;
        } finally {
            session.close();
        }
    }
}