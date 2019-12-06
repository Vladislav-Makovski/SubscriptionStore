package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Customer;
import com.netcracker.edu.backend.entity.Organization;
import com.netcracker.edu.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer/")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "new/create",method = RequestMethod.POST)
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @RequestMapping("nameAsc")
    @GetMapping
    public Iterable<Customer> getAllCustomerByNameAsc()
    {
        return customerService.getAllCustomerByNameAsc();
    }
}
