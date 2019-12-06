package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductAdvertiserRepository extends JpaRepository<Product, Integer> {

    List<Product> findByOrganizationId(Integer id);
}
