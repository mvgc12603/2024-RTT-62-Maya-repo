package com.example.springboot.controller;


import com.example.springboot.database.dao.EmployeeDAO;
import com.example.springboot.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/employees")
class EmployeeController {
    @Autowired
    private EmployeeDAO employeeDAO;

    @GetMapping("/")
    public ModelAndView Employee(@RequestParam(required = false) String name) {
        ModelAndView response = new ModelAndView("employeeSearch");
        List<Employee> employees = employeeDAO.findByFirstname(name);
        response.addObject("employees", employees);
        response.addObject("name", name);
        return response;
    }
    @GetMapping("/employeeItem")
    public ModelAndView EmployeeItem(@RequestParam(required = false) int name) {
        ModelAndView response = new ModelAndView("employeeItem");
        Employee employee = employeeDAO.findEmployeeById(name);
        response.addObject("employee", employee);
        response.addObject("name", name);
        return response;
    }
}