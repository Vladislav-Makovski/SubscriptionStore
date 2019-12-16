package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Wallet;
import com.netcracker.edu.backend.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wallet/")
public class WalletControllerWithdraw {

    private WalletService walletService;

    @Autowired
    public WalletControllerWithdraw(WalletService walletService) {
        this.walletService = walletService;
    }

    @RequestMapping(value = "withdraw" ,method = RequestMethod.POST)
    public Wallet saveBalanceWithdraw(@RequestBody Wallet wallet)
    {
        if(wallet.getBalance()>=0) {
            return walletService.saveBalanceWithdraw(wallet);
        }else {
            return null;
        }
    }
}
