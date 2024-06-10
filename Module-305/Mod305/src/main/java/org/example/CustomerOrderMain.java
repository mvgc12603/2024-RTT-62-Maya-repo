package org.example;

import org.example.database.dao.OrderDAO;
import org.example.database.dao.CustomerDAO;
import org.example.database.entity.Order;
import org.example.database.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class CustomerOrderMain {

    // Class Variables
    private Scanner scan = new Scanner(System.in);
    private OrderDAO orderDAO = new OrderDAO();


    // Runner
    public void run() {

        // Search for order list via customer ID
//        Integer customerID = promptUserForID("Customer");
//        List<Order> orders = orderDAO.findByCustomerID(customerID);
//        printOrders(orders);

        //Search for single order via orderID
        Integer orderID = promptUserForID("Order");
        Order order = orderDAO.findById(orderID);
        printSingleOrder(order);

        //Update Order - add comment and save to DB
        String comment = promptUserForComment();
        order.setComments(comment);
        System.out.println("Updated Order");
        printSingleOrder(order);




    }

    // Prints a list of orders
    public void printOrders(List<Order> orders) {
        if (orders.size() >= 1) {
            System.out.println("\nOrder Status for Customer -- " + orders.get(0).getCustomer().getCustomerName() + "\n");
            System.out.println("ID | Order Date | Status | Customer ID");
            System.out.println("===========================================");
            for (Order order : orders) {
                System.out.println(order.getId() + " | " + order.getOrderDate() + " | " + order.getStatus() + " | " + order.getCustomerID());
            }
        } else {
            System.out.println("No orders associated with given Customer ID");
        }
    }

    // Similar to print orders, for formated with a single result in mind.
    public void printSingleOrder(Order order) {

        // This causes error - Exception in thread "main" org.hibernate.LazyInitializationException: could not initialize proxy [demo.java.database.entity.Customer#131] - no Session
        // Left out for now.
        // System.out.println("\nOrder Status for Customer -- " + order.getCustomer().getCustomerName() + "\n");

        System.out.println("ID | Order Date | Status | Comments");
        System.out.println("===========================================");
        System.out.println(order.getId() + " | " + order.getOrderDate() + " | " + order.getStatus() + " | " + order.getComments());

    }

    // Handles prompting the user and validating result is an int. "String idOf" allows me to reuse this code for both CustomerID and OrderID
    public Integer promptUserForID(String idOf) {
        while (true) {
            try {
                System.out.print("\nInput " + idOf + " ID: ");
                int result = scan.nextInt();
                return result;
            } catch (Exception e) {
                System.out.println("Please input a valid number");
                scan.nextLine();
            }
        }
    }

    public String promptUserForComment() {
        System.out.print("\nInput Order Comment: ");
        //Have to clear the scanner or the code throws a fit
        scan.nextLine();
        String result = scan.nextLine();
        return result;

    }
    public static void main(String[] args) {
        CustomerOrderMain com = new CustomerOrderMain();
        com.run();
    }


}