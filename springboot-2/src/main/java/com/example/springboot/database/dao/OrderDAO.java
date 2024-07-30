package com.example.springboot.database.dao;

import com.example.springboot.database.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface OrderDAO extends JpaRepository<Order, Long> {
    Order findById(Integer id);

    @Query("select o from Order o where o.customerId = :customerId")
    List<Order> findByCustomerId(Integer customerId);


        // each Map is the list represents a row in the result set from the database
        // in this result, the String is the column name and the object is the value in the column
        // we are using native SQL so we need to give the flag in the Query annotation to be nativeQuery = true
        @Query(value="select o.id as order_id, o.order_date, od.quantity_ordered, p.product_name, p.id as product_id,  \n" +
                "                od.price_each, (od.quantity_ordered * od.price_each) as line_item_total \n" +
                "                from orderdetails od, products p, orders o \n" +
                "                where od.product_id = p.id and o.id = od.order_id and o.id = order_id \n" +
                "                order by order_id;", nativeQuery = true)
        List<Map<String,Object>> getOrderDetails(Integer orderId);

}
