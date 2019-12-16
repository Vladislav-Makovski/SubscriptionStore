package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdvertiserJpaRepository extends JpaRepository<Organization, Integer> {
    Optional<Organization> findByUserDetailsId(Integer id);
}
