package com.codegym.c0424m1springoverview.controller;

import com.codegym.c0424m1springoverview.model.Customer;
import com.codegym.c0424m1springoverview.service.CustomerServiceImpl;
import com.codegym.c0424m1springoverview.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CustomerController {

    //private ICustomerService customerService = new CustomerServiceImpl();

    /*@Autowired
    private ICustomerService customerService;*/

    /*private CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }*/

    private CustomerServiceImpl customerService;

    @Autowired
    public void setCustomerService(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/customers")
    public String showList(HttpServletRequest request) {
        List<Customer> customers = customerService.findAll();
        request.setAttribute("customers", customers);
        return "customers/list.jsp";
    }
}
