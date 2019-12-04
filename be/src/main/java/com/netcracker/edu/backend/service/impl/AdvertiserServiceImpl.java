package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Organization;
import com.netcracker.edu.backend.repository.AdvertiserRepository;
import com.netcracker.edu.backend.service.AdvertiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdvertiserServiceImpl implements AdvertiserService {

    private AdvertiserRepository repository;

    @Autowired
    public AdvertiserServiceImpl(AdvertiserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Organization saveAdvertiser(Organization organization) {
        Organization org = repository.save(organization);
        return org;
    }
}
