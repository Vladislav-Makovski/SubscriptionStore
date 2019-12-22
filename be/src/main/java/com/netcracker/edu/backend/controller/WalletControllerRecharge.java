package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Wallet;
import com.netcracker.edu.backend.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/wallet/")
public class WalletControllerRecharge {

    private WalletService walletService;

    @Autowired
    public WalletControllerRecharge(WalletService walletService) {
        this.walletService = walletService;
    }

    @RequestMapping(value = "recharge",method = RequestMethod.POST)
    public Wallet saveBalanceRecharge(@RequestBody Wallet wallet) {
        if(wallet.getBalance() >= 0) {
            return walletService.saveBalanceRecharge(wallet);
        }else {
            return null;
        }
    }
}
