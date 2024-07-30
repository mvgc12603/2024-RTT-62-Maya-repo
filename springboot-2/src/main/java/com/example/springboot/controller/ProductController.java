package com.example.springboot.controller;

import com.example.springboot.database.dao.CustomerDAO;
import com.example.springboot.database.dao.EmployeeDAO;
import com.example.springboot.database.dao.OfficeDAO;
import com.example.springboot.database.dao.ProductDAO;
import com.example.springboot.database.entity.Customer;
import com.example.springboot.database.entity.Employee;
import com.example.springboot.database.entity.Office;
import com.example.springboot.database.entity.Product;
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
@RequestMapping("/product")

public class ProductController {
    @Autowired
    private ProductDAO productDAO;

    @GetMapping("/productSearch")
    public ModelAndView search(@RequestParam(required = false) String search) {

        ModelAndView response = new ModelAndView("product/productSearch");
        List<Product> products = productDAO.findByName(search);
        response.addObject("search", search);
        response.addObject("products", products);
        return response;
    }

        @GetMapping("/create")
        public ModelAndView create() {
            // this method is setting up the view for rendering
            ModelAndView response = new ModelAndView("product/create");
            return response;
        }

        @GetMapping("/edit")
        public ModelAndView edit(@RequestParam(required = false) Integer employeeId) {
            // by setting required = false on the incoming parameter we allow null to enter the controller so that spring does not cause an error page
            // then we check if the input is null before trying to do our query

            // this view is the same for all the methods so far, even tho it is named create and we are using it for edit
            ModelAndView response = new ModelAndView("product/create");
            return response;
        }

}
