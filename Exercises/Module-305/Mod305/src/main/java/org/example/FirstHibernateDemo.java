package org.example;

import org.example.database.dao.EmployeeDAO;
import org.example.database.entity.Employee;

import java.util.List;
import java.util.Scanner;

public class FirstHibernateDemo {

    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
//
//        List<Employee> employees = employeeDAO.findByFirstName("Leslie");
//        for (Employee employee : employees) {
//            System.out.println(employee);
//        }

//        // Creates a new employee in the database
//       Employee newEmployee = new Employee();
//       newEmployee.setId(1721);
//        newEmployee.setFirstname("Cruella");
//        newEmployee.setLastname("De Vil");
//        newEmployee.setEmail("puppycoats@hotmail.com");
//        newEmployee.setOfficeId(1);
//        newEmployee.setExtension("101");
//        newEmployee.setJobTitle("Almighty Leader");
//        newEmployee.setVacationHours(365);
//        employeeDAO.insert(newEmployee);

        Employee employee1 = employeeDAO.findById(1056);
        System.out.println(employee1);

        Employee employee2 = employeeDAO.findById(1720);
        System.out.println(employee2);
        employeeDAO.delete(employee2);
    }
}