package org.example.database.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")

public class Orders {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "customer_id")
    private Integer customerID;

    @Column(name = "order_date", columnDefinition = "DATE")
    private Date orderDate;

    @Column(name = "required_date", columnDefinition = "DATE")
    private Date requiredDate;

    @Column(name = "shipped_date", columnDefinition = "DATE")
    private Date shippedDate;

    @Column(name = "status")
    private String status;

    @Column(name = "comments")
    private String comments;
}