package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Customer;
import com.netcracker.edu.backend.entity.Organization;
import com.netcracker.edu.backend.entity.Wallet;
import com.netcracker.edu.backend.repository.CustomerJpaRepository;
import com.netcracker.edu.backend.repository.CustomerRepository;
import com.netcracker.edu.backend.repository.CustomerSortRepository;
import com.netcracker.edu.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository repository;
    private CustomerSortRepository repositorySort;
    private CustomerJpaRepository repositoryJpa;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository,CustomerSortRepository repositorySort,CustomerJpaRepository repositoryJpa) {
        this.repository = repository;
        this.repositorySort = repositorySort;
        this.repositoryJpa = repositoryJpa;
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

    @Override
    public void deleteCustomerById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Customer> getCustomerById(Integer id){
        return repository.findById(id);
    }

    @Override
    public Optional<Customer> getCustomerByUserDetailsId(Integer id){
        return repositoryJpa.findByUserDetailsId(id);
    }
}
