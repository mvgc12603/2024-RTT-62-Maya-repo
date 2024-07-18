package org.example;

import java.sql.*;
import java.util.Scanner;

//Basically the old style ~2004 way of doing things, as per Eric
public class JDBCDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        String dburl = "jdbc:mysql://localhost:3306/classic_models";
        String user = "root";
        String password = "Password1$";
        System.out.println("-------- MySQL JDBC Connection Demo ------------");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(dburl, user, password);

            //scanner here to take input from the user to search for, eg a specific first name
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the first name of the employee you want to search for: ");
            String input = scanner.nextLine();

            String input2 ="Doe";
            int input3 = 5;

            // Susceptible to SQL injection attack:
            // String selectSQL = "Select * FROM employees where firstname = '" + input + "'";
            // Statement stmt = connection.createStatement();

            String selectSQL = "Select * FROM employees where firstname = ? or lastname = ? or id = ?";
            PreparedStatement stmt = connection.prepareStatement(selectSQL);
            stmt.setString(1, input);
            stmt.setString(2, input2);
            stmt.setInt(3, input3);

            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                String employeeID = result.getString("id");
                String fname = result.getString("firstname");
                String lname = result.getString("lastname");
                String email = result.getString("email");
                String jobTitle = result.getString("job_title");
//System.out.println(employeeID +" | " + fname + " | "+ lname + " | " + email + " | " + jobTitle );
                String format = "%-10s | %-15s | %-15s | %-35s | %-20s%n";
// Use printf to format the output
                System.out.printf(format, employeeID, fname, lname, email, jobTitle);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}