package com.example.springboot.controller;

import com.example.springboot.database.dao.OrderDAO;
import com.example.springboot.database.dao.OrderDetailDAO;
import com.example.springboot.database.dao.ProductDAO;
import com.example.springboot.database.entity.Order;

import com.example.springboot.database.entity.OrderDetail;
import com.example.springboot.form.OrderDetailsBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private OrderDetailDAO orderDetailDAO;

    @Autowired
    private ProductDAO productDAO;

    @GetMapping("/list")
    public ModelAndView employeeDetails(@RequestParam(required = false) String customerId) {

        ModelAndView response = new ModelAndView("order/orderList");

        List<Order> orders = orderDAO.findByCustomerId(Integer.valueOf(customerId));

        response.addObject("orders", orders);

        return response;
    }

    @GetMapping("/detail")
    public ModelAndView orderDetail(@RequestParam(required = false) String orderId) {

        ModelAndView response = new ModelAndView("order/orderDetails");

        List<OrderDetail> orderDetails = orderDetailDAO.findByOrderId(Integer.valueOf(orderId));

        ArrayList<OrderDetailsBean> orderDetailList = new ArrayList<>();
        log.info(orderDetailList.toString());

        response.addObject("order", orderDetails.get(0).getOrder());

        DecimalFormat df = new DecimalFormat("#,###.00");
        Double orderTotal = 0.00;

        for (OrderDetail od : orderDetails) {
            OrderDetailsBean orderDetailsBean = new OrderDetailsBean();

            orderDetailsBean.setOrderId(od.getOrderID());
            orderDetailsBean.setProductId(od.getProductID());
            orderDetailsBean.setQuantityOrdered(od.getQuantityOrdered());
            orderDetailsBean.setPriceEach(od.getPriceEach());
            orderDetailsBean.setProductName(od.getProduct().getProductName());

            // Calculate product total $
            Double total = od.getQuantityOrdered() * od.getPriceEach();
            orderDetailsBean.setTotal(df.format(total));

            // Calculate order total $
            orderTotal += total;

            orderDetailList.add(orderDetailsBean);
        }

        log.info(orderDetailList.toString());

        response.addObject("orderDetailList", orderDetailList);
        response.addObject("orderTotal", df.format(orderTotal));

        return response;
    }


    @GetMapping("/order/orderdetail")
    public ModelAndView orderDetail(@RequestParam Integer orderId) {
        ModelAndView response = new ModelAndView("order/orderdetail");

        List<Map<String, Object>> orderDetails = orderDAO.getOrderDetails(orderId);
        response.addObject("orderDetails", orderDetails);

        return response;
    }


}
