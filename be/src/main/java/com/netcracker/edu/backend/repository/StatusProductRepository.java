package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.StatusProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusProductRepository extends CrudRepository<StatusProduct, Integer> {
}
