package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Category;
import com.netcracker.edu.backend.entity.StatusWallet;
import com.netcracker.edu.backend.service.StatusWalletService;
import com.netcracker.edu.backend.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/walletStatus/")
public class StatusWalletController {

    private StatusWalletService statusWalletService;

    @Autowired
    public StatusWalletController(StatusWalletService statusWalletService) {
        this.statusWalletService = statusWalletService;
    }

    @GetMapping
    public Iterable<StatusWallet> getAll() {
        return statusWalletService.getAll();
    }
}
