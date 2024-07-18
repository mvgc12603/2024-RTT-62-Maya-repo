package com.example.springboot.database.dao;

import com.example.springboot.database.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDAO extends JpaRepository<Order, Long> {
    Order findById(Integer id);

    @Query("select o from Order o where o.customerId = :customerId")
    List<Order> findByCustomerId(Integer customerId);
}
