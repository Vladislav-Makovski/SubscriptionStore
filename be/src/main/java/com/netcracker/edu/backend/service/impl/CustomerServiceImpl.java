package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Customer;
import com.netcracker.edu.backend.entity.Organization;
import com.netcracker.edu.backend.repository.CustomerRepository;
import com.netcracker.edu.backend.repository.CustomerSortRepository;
import com.netcracker.edu.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository repository;
    private CustomerSortRepository repositorySort;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository,CustomerSortRepository repositorySort) {
        this.repository = repository;
        this.repositorySort = repositorySort;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        Customer cust = repository.save(customer);
        return cust;
    }

    @Override
    public  Iterable<Customer> getAllCustomerByNameAsc() {
        return repositorySort.findAll(Sort.by("Surname"));
    }
}
