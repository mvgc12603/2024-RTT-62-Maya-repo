package com.example.springboot.controller;

import com.example.springboot.database.dao.CustomerDAO;
import com.example.springboot.database.dao.EmployeeDAO;
import com.example.springboot.database.dao.OfficeDAO;
import com.example.springboot.database.entity.Customer;
import com.example.springboot.database.entity.Employee;
import com.example.springboot.database.entity.Office;
import com.example.springboot.form.CreateEmployeeFormBean;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private OfficeDAO officeDAO;


    @GetMapping("/search")
    public ModelAndView employeeSearch(@RequestParam(required = false) String search) {

        log.info("Search term is: " + search);
        ModelAndView response = new ModelAndView("employeeSearch");
        List<Employee> employees = employeeDAO.findByName(search);
        response.addObject("search", search);
        response.addObject("employees", employees);
        return response;
    }

    @GetMapping("/detail")
    public ModelAndView employeeDeatails(@RequestParam(required = false) String employeeId) {

        ModelAndView response = new ModelAndView("employeeDetails");

        Employee employee = employeeDAO.findById(Integer.valueOf(employeeId));
        response.addObject("employee", employee);

        Office office = officeDAO.findById(employee.getOfficeId());
        response.addObject("employeeOffice", office);


        List<Customer> customers = customerDAO.findByEmployeeId(Integer.valueOf(employeeId));
        response.addObject("customers", customers);

        log.info("employeeId is: " + employeeId);
        log.info("customers is: " + customers.toString());


        return response;
    }

    @GetMapping("/create")
    public ModelAndView createEmployee() {

        ModelAndView response = new ModelAndView("createEmployee");

        List<Employee> employees = employeeDAO.findAll();
        response.addObject("employees", employees);

        List<Office> offices = officeDAO.findAll();
        response.addObject("offices", offices);

        return response;
    }

    @GetMapping("/createSubmit")
    public ModelAndView createEmployeeSubmit(@Valid CreateEmployeeFormBean form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView();

        log.info("form is: " + form.toString());

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.info("Validation error : " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }
            response.addObject("bindingResult", bindingResult);

            List<Employee> employees = employeeDAO.findAll();
            response.addObject("employees", employees);

            List<Office> offices = officeDAO.findAll();
            response.addObject("offices", offices);

            response.setViewName("createEmployee");
            response.addObject("form", form);

            return response;
        } else {


            Employee employee = new Employee();
            employee.setEmail(form.getEmail());
            employee.setFirstname(form.getFirstname());
            employee.setLastname(form.getLastname());
            employee.setReportsTo(form.getReportsTo());
            employee.setExtension(form.getExtension());

            Office office = officeDAO.findById(form.getOfficeId());
            employee.setOffice(office);
            employee.setJobTitle(form.getJobTitle());
            employee.setVacationHours(form.getVacationHours());

            employee = employeeDAO.save(employee);

            response.setViewName("redirect:/employee/detail?employeeId=" + employee.getId());


            return response;
        }

    }
}
