package org.example.database.dao;

import org.example.database.dao.CustomerDAO;
import org.example.database.entity.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerDAOTest {
    private CustomerDAO customerDAO = new CustomerDAO();

    @Test
    public void findByIdTest() {
        //given
        Integer userId = 103;
        //when
        Customer customer = customerDAO.findByID(userId);

        //then
        Assertions.assertNotNull(customer);
        // id I want is id it got
        Assertions.assertEquals(userId, customer.getId());
        //customer name I want is customer name associated with that id
        Assertions.assertEquals("Atelier graphique", customer.getCustomerName());
    }

    @Test
    public void findByInavlidIdTest() {
        //given
        Integer userid = 1033333;
        //when
        Customer customer = customerDAO.findByID(userid);

        //then
        Assertions.assertNull(customer);
    }

    @Test
    public void createNewCustomerTest() {
        //given
        Customer given = new Customer();

        given.setCustomerName("Test Customer");
        given.setContactFirstname("Firstname");
        given.setContactLastname("Lastname");
        given.setAddressLine1("address 1");

        //when
        customerDAO.insert(given);

        //then
        Customer actual = customerDAO.findByID(given.getId());
        Assertions.assertEquals(given.getCustomerName(), actual.getCustomerName());
        Assertions.assertEquals(given.getContactFirstname(), actual.getContactFirstname());
    }
}
