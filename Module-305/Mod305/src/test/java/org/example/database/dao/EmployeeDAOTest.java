package org.example.database.dao;

import org.example.database.dao.CustomerDAO;
import org.example.database.dao.EmployeeDAO;
import org.example.database.entity.Customer;
import org.example.database.entity.Employee;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

public class EmployeeDAOTest {
    private static EmployeeDAO employeeDAO = new EmployeeDAO();

    @BeforeAll
    public static void beforeAll() {
        List<Employee> employees = employeeDAO.findByFirstName("Mangoes");
        for (Employee employee : employees) {
            employeeDAO.delete(employee);
        }
    }

    @AfterAll
    public static void afterAll() {
        List<Employee> employees = employeeDAO.findByFirstName("Mangoes");
        for (Employee employee : employees) {
            employeeDAO.delete(employee);
        }
    }

    @Test
    public void findByIdTest() {
        // given
        Integer empID = 1724;

        // when
        Employee employee = employeeDAO.findById(empID);

        // then
        Assertions.assertNotNull(employee);
        Assertions.assertEquals(empID, employee.getId());
        Assertions.assertEquals("Cruella", employee.getFirstname());
    }

    @Test
    public void findByIdInvalidTest() {
        // given
        Integer empID = 101;

        // when
        Employee employee = employeeDAO.findById(empID);

        // then
        Assertions.assertNull(employee);
    }

    @ParameterizedTest
    @CsvSource(
            {
         //basically like given
            "Diane",
            "Mary"
      }
    )
public void findByFirstNameTest(String firstName) {
        // when
        List<Employee> employees = employeeDAO.findByFirstName(firstName);

        // then
        Assertions.assertTrue(employees.size() > 0);
        for (Employee employee : employees) {
            Assertions.assertEquals(firstName, employee.getFirstname());
        }
    }

    @Test
    public void findByFirstNameInvalidTest () {
        // given
        String firstName = "gjkflnklsfd76";

        // when
        List<Employee> employees = employeeDAO.findByFirstName(firstName);

        // then
        Assertions.assertTrue(employees.isEmpty()); //Value of the list won't be null, but it will be empty.
    }

    @Test
    public void createNewEmployee () {
        //given
        Employee given = new Employee(1, "Mangoes", "the mango", "sodelicious@fruitygoodness.org",
                "Food", "x101");

        //when
        employeeDAO.insert(given);

        //then
        //For now, find by ID would not work. Every time this is run, it doesn't roll back auto_increment, so ID gets larger everytime.
        List<Employee> employees = employeeDAO.findByFirstName("Mangoes");
        Assertions.assertEquals("Mangoes", employees.get(0).getFirstname());

    }
}
