package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Customer;
import com.netcracker.edu.backend.entity.Organization;
import com.netcracker.edu.backend.entity.Product;
import com.netcracker.edu.backend.repository.AdvertiserRepository;
import com.netcracker.edu.backend.repository.AdvertiserSortRepository;
import com.netcracker.edu.backend.service.AdvertiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AdvertiserServiceImpl implements AdvertiserService {

    private AdvertiserRepository repository;
    private AdvertiserSortRepository repositorySort;

    @Autowired
    public AdvertiserServiceImpl(AdvertiserRepository repository, AdvertiserSortRepository repositorySort) {
        this.repository = repository;
        this.repositorySort = repositorySort;
    }

    @Override
    public Organization saveAdvertiser(Organization organization) {
        Organization org = repository.save(organization);
        return org;
    }

    @Override
    public  Iterable<Organization> getAllOrganizationByNameAsc() {
        return repositorySort.findAll(Sort.by("Name"));
    }

    @Override
    public void deleteAdvertiserById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Organization> getAdvertiserById(Integer id){
        return repository.findById(id);
    }

}
