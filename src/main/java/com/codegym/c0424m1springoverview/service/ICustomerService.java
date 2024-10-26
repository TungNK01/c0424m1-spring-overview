package com.codegym.c0424m1springoverview.service;

import com.codegym.c0424m1springoverview.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(int id, Customer customer);

    void remove(int id);
}
