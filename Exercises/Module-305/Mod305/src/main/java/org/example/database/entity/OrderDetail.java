package org.example.database.entity;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "orderdetails")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "product_id", nullable = true)
    private Product product;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "order_id", nullable = true)
    private Order order;

    @Column(name = "product_id", insertable = false, updatable = false)
    private Integer productID;

    @Column(name = "order_id", insertable = false, updatable = false)
    private Integer orderID;

    @Column(name = "quantity_ordered")
    private Integer quantityOrdered;

    @Column(name = "price_each", columnDefinition = "DECIMAL")
    private Double priceEach;

    @Column(name = "order_line_number", columnDefinition = "SMALLINT") // Future note in case of issues. This is a smallint
    private Integer orderLineNumber;


}