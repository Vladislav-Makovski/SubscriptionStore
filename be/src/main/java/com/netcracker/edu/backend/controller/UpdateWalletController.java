package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Wallet;
import com.netcracker.edu.backend.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/recharge/")
public class UpdateWalletController {
    private WalletService walletService;

    @Autowired
    public UpdateWalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Wallet saveBillingAccount(@RequestBody Wallet wallet) {
        return walletService.saveBalanceRecharge(wallet);
    }
}
