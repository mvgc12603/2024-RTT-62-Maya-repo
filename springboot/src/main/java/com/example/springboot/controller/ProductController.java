//package com.example.springboot.controller;
//
//
//import com.example.springboot.database.dao.ProductDAO;
//import com.example.springboot.entity.Product;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.List;
//import java.util.Optional;
//
//@Slf4j
//@Controller
//@RequestMapping("/productSearch")
//class ProductController {
//    @Autowired
//    private ProductDAO productDAO;
//
//    @GetMapping("/")
//
//    public ModelAndView productSearch(@RequestParam(required = false) String search) {
//
//        ModelAndView response = new ModelAndView("productSearch");
//
//        log.debug("The user searched for the term: " + search);
//
//        // add the user input back to the model,
//        // so it displays the search term in the input field
//        response.addObject("search", search);
//
//        List<Product> products = productDAO.findByNameOrCode(search);
//        response.addObject("products", products);
//
//        return response;
//    }
//
////    @GetMapping("/productItem")
////    public ModelAndView productItem(@RequestParam(required = false) int name) {
////        ModelAndView response = new ModelAndView("productItem");
////        Product product = ProductDao.findByNameOrCode(product.id);
////        response.addObject("product", product);
////        response.addObject("name", name);
////        return response;
////    }
//}
