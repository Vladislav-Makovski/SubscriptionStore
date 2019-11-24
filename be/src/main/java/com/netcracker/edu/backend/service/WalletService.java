package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Wallet;

import java.util.Optional;

public interface WalletService {

    Optional<Wallet> getWalletById(Integer id);

}
