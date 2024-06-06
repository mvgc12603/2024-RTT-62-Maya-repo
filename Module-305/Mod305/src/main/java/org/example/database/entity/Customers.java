package org.example.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor


@Table(name = "customers")
public class Customers {

    @Id // this is telling hibernate this column is the PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // this telling hibernate that the PK is auto increment
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
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "country")
    private String country;

    @Column(name = "sales_rep_employee_id")
    private Integer salesRepEmployeeID;

    @Column(name = "credit_limit", columnDefinition = "DECIMAL")
    private Double creditLimit;

    // Minimal constructor for adding to DB
    public Customers(String customerName, String contactFirstName, String contactLastName,
                    String phone, String addressLine1, String city, String country) {
        this.customerName = customerName;
        this.contactFirstName = contactFirstName;
        this.contactLastName = contactLastName;
        this.phone = phone;
        this.addressLine1 = addressLine1;
        this.city = city;
        this.country = country;
    }

    //All Args minus ID
    public Customers(String customerName, String contactFirstName, String contactLastName, String phone, String addressLine1, String addressLine2, String city, String state, String postalCode, String country, Integer salesRepEmployeeID, Double creditLimit) {
        this.customerName = customerName;
        this.contactFirstName = contactFirstName;
        this.contactLastName = contactLastName;
        this.phone = phone;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.salesRepEmployeeID = salesRepEmployeeID;
        this.creditLimit = creditLimit;
    }
}