package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Wallet;

import java.util.Optional;

public interface WalletService {

    Optional<Wallet> getWalletById(Integer id);
    Wallet saveBalanceRecharge(Wallet wallet);
    Wallet saveBalanceWithdraw(Wallet wallet);
    Wallet saveNewWallet(Wallet wallet);
    void deleteWalletById(Integer id);

}
