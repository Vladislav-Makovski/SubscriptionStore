package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Customer;
import com.netcracker.edu.backend.entity.Organization;
import com.netcracker.edu.backend.entity.Wallet;
import com.netcracker.edu.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void deleteCustomerById(@PathVariable(name = "id") Integer id) {
        customerService.deleteCustomerById(id);
    }

    @GetMapping
    @RequestMapping(value = "information/{id}", method = RequestMethod.GET)
    public Optional<Customer> getCustomerById(@PathVariable(name = "id") Integer id) {
        return customerService.getCustomerById(id);
    }
}
