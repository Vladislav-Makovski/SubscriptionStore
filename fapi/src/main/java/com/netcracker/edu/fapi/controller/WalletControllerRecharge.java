package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.WalletViewModel;
import com.netcracker.edu.fapi.service.WalletDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/recharge")
public class WalletControllerRecharge {

    @Autowired
    private WalletDataService walletDataService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<WalletViewModel> saveBalanceRecharge(@RequestBody WalletViewModel wallet) {
        return ResponseEntity.ok(walletDataService.saveBalanceRecharge(wallet));
    }
}
