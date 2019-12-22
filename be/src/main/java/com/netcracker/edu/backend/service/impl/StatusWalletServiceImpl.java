package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.StatusWallet;
import com.netcracker.edu.backend.repository.StatusWalletRepository;
import com.netcracker.edu.backend.service.StatusWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatusWalletServiceImpl implements StatusWalletService {

    private StatusWalletRepository repository;

    @Autowired
    public StatusWalletServiceImpl(StatusWalletRepository repository) {
        this.repository = repository;
    }

    @Override
    public  Iterable<StatusWallet> getAll() {
        return repository.findAll();
    }
}
