package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Organization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertiserRepository  extends CrudRepository<Organization, Integer> {
}
