package com.netcracker.edu.backend.repository;
import com.netcracker.edu.backend.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;

import java.util.List;

@Repository
public interface CatalogItemRepository extends PagingAndSortingRepository<Product, Long> {
}
