package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Organization;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertiserSortRepository extends PagingAndSortingRepository<Organization, Long> {
}
