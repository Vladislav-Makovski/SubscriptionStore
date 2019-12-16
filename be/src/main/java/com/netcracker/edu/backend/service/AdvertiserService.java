package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Customer;
import com.netcracker.edu.backend.entity.Organization;
import com.netcracker.edu.backend.entity.Product;

import java.util.Optional;

public interface AdvertiserService {

    Organization saveAdvertiser(Organization org);
    Iterable<Organization> getAllOrganizationByNameAsc();
    void deleteAdvertiserById(Integer id);
    Optional<Organization> getAdvertiserById(Integer id);
    Optional<Organization> getAdvertiserByUserDetailsId(Integer id);
}
