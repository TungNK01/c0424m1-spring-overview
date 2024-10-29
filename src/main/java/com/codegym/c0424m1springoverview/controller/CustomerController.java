package com.codegym.c0424m1springoverview.controller;

import com.codegym.c0424m1springoverview.model.Customer;
import com.codegym.c0424m1springoverview.service.CustomerServiceImpl;
import com.codegym.c0424m1springoverview.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/customers")
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


    @GetMapping("/list")
    public String showListCustomers(HttpServletRequest request) {
        List<Customer> customers = customerService.findAll();
        request.setAttribute("customers", customers);
        return "/customers/list";
    }

    @GetMapping("/create")
    public String showCreateForm() {
        return "/customers/create";
    }

    /*@PostMapping("/create")
    public String createCustomer(@RequestParam String name, @RequestParam String email, @RequestParam String address) {
        int id = (int) (Math.random() * 10000);
        Customer customer = new Customer(id, name, email, address);
        customerService.save(customer);
        return "redirect:/customers/list";
    }*/

    @PostMapping("/create")
    public String createCustomerjahfjhafjahfjkahfjkadhfjahdfj(@ModelAttribute Customer customer) {
        int id = (int) (Math.random() * 10000);
        Customer customerObject = new Customer(id, customer.getName(), customer.getEmail(), customer.getAddress());
        customerService.save(customerObject);
        return "redirect:/customers/list";
    }

    @GetMapping("/find/{id}/{name}")
    public String findCustomerById(@PathVariable int id, @PathVariable String name ) {
        return"";
    }




}
