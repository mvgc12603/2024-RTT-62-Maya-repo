package org.example.database.entity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")


public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "contact_lastname")
    private String contactLastName;

    @Column(name = "contact_firstname")
    private String contactFirstName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address_line1")
    private String address1;

    @Column(name = "address_line2")
    private String address2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "postal_code")
    private String zipCode;

    @Column(name = "country")
    private String country;

    @Column(name = "sales_rep_employee_id", columnDefinition = "INT")
    private Double salesRepEmployeeID;

    @Column(name = "credit_limit", columnDefinition = "DECIMAL")
    private Double creditLimit;


}