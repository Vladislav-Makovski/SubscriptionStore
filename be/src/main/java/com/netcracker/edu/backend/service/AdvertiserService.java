package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Organization;
import com.netcracker.edu.backend.entity.Product;

public interface AdvertiserService {

    Organization saveAdvertiser(Organization org);
    Iterable<Organization> getAllOrganizationByNameAsc();
}
