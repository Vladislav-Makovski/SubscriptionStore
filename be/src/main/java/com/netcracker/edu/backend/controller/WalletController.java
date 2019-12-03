package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.StatusWallet;
import com.netcracker.edu.backend.entity.Wallet;
import com.netcracker.edu.backend.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/wallet/")
public class WalletController {

    private WalletService walletService;

    @Autowired
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Wallet> getWalletById(@PathVariable(name = "id") Integer id) {
        return walletService.getWalletById(id);
    }

    @RequestMapping(value = "new",method = RequestMethod.POST)
    public Wallet saveNewWallet(@RequestBody Wallet wallet) {
        return walletService.saveNewWallet(wallet);
    }
}
