package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Customer;

public interface CustomerService {

    Customer saveCustomer(Customer customer);
    Iterable<Customer> getAllCustomerByNameAsc();
}
