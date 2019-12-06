package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerSortRepository extends PagingAndSortingRepository<Customer, Integer> {
}
