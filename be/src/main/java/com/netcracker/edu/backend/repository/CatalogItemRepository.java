package com.netcracker.edu.backend.repository;
import com.netcracker.edu.backend.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogItemRepository extends CrudRepository<Product, Long> {
}
