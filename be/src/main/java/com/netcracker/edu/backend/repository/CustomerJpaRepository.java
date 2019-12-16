package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Customer;
import com.netcracker.edu.backend.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerJpaRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByUserDetailsId(Integer id);
}
