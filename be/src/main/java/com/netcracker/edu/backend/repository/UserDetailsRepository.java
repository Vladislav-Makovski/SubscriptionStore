package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.UserDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetails, Integer> {
}
