package com.example.springboot.controller;

import com.example.springboot.database.dao.EmployeeDAO;
import com.example.springboot.database.dao.ProductDAO;
import com.example.springboot.entity.Product;
import com.example.springboot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

import lombok.extern.slf4j.*;

@Slf4j
@Controller
public class IndexController {

//    create objects
    @Autowired
    private ProductDAO productDao;
    @Autowired
    private EmployeeDAO employeeDAO;


    // this function is for the home page of the website which is express as just a plain slash "/"
    @GetMapping("/")
    public ModelAndView index(@RequestParam(required = false) Integer id) {
        // by default, the @RequestParam is required, meaning if it is missing in the URL spring will send you to the error page
        // if the id parameter is not present on the URL then the incoming id will be null
        ModelAndView response = new ModelAndView("index");

        Product product = productDao.findById(id);
        response.addObject("productKey", product);

        // by default the logging level is set to info so the debug message will not be printed in the terminal
        log.debug("Debug level");
        log.info("Info level");
        log.warn("Warn level");
        log.error("Error level");

        // NEVER EVER use System.out.println in a spring application
        System.out.println("This is forbidden at all times");

        response.addObject("message", "Hello World!");

        return response;
    }

    @GetMapping("/about")
    public ModelAndView canBeAnyFunctionNameYouWant() {
        // this page is for another page of the website which is express as "/page-url"
        ModelAndView response = new ModelAndView("page2");
        return response;
    }

    @GetMapping("/productSearch")
    public ModelAndView productSearch(@RequestParam(required = false) String search) {

        ModelAndView response = new ModelAndView("productSearch");

        log.debug("The user searched for the term: " + search);

        // add the user input back to the model,
        // so it displays the search term in the input field
        response.addObject("search", search);

        List<Product> products = productDao.findByNameOrCode(search);
        response.addObject("products", products);

        return response;
    }


    @GetMapping("/homework")
    public ModelAndView homework (@RequestParam(required = false) String homework) {
        ModelAndView response = new ModelAndView("homework");
        return response;
    }

    @GetMapping("/index/{id}")
    public ModelAndView indexPathVar(@PathVariable(name = "id") Integer productId) {
        // by default, the @PathVariable is required, meaning if it is missing in the URL spring will send you to the error page
        // by using the name attribute in the @PathVariable annotation, you can change the name of the variable
        // so in this case it is mapping the id in the URL to the productId variable
        ModelAndView response = new ModelAndView("index");

        Product product = productDao.findById(productId);
        response.addObject("productKey", product);

        response.addObject("message", "Hello World!");

        return response;
    }


}
//    @GetMapping("/error")
//public ModelAndView error(){
//    ModelAndView response = new ModelAndView("error")
//        return response;
//    }
