package com.example.springboot.database.dao;

import com.example.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Long> {

    //magic. spring data JPA makes a query based on the name
    Product findById(Integer id);

    // this is a JPA query just like we did in the hibernate module
    @Query("select p from Product p where p.productName like concat('%', :name, '%') or p.productCode like concat('%', :name, '%')")
    List<Product> findByNameOrCode(String name);

}