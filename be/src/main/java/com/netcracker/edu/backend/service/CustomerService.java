package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Customer;
import com.netcracker.edu.backend.entity.Wallet;

import java.util.Optional;

public interface CustomerService {

    Customer saveCustomer(Customer customer);
    Iterable<Customer> getAllCustomerByNameAsc();
    void deleteCustomerById(Integer id);
    Optional<Customer> getCustomerById(Integer id);
    Optional<Customer> getCustomerByUserDetailsId(Integer id);
}
