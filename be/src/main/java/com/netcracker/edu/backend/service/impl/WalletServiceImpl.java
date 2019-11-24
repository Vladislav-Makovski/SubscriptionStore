package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Wallet;
import com.netcracker.edu.backend.repository.WalletRepository;
import com.netcracker.edu.backend.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WalletServiceImpl implements WalletService{

    private WalletRepository walletRepository;

    @Autowired
    public WalletServiceImpl(WalletRepository repository) {
        this.walletRepository = repository;
    }

    @Override
    public Optional<Wallet> getWalletById(Integer id){
        return walletRepository.findById(id);
    }
}