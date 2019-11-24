package com.netcracker.edu.fapi.converter;

import com.netcracker.edu.fapi.models.ConverterStatusWallet;
import com.netcracker.edu.fapi.models.StatusWalletViewModel;
import com.netcracker.edu.fapi.models.WalletViewModel;
import com.netcracker.edu.fapi.service.WalletDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/walletById")
public class WalletAndStatus {

    @Autowired
    private WalletDataService walletDataService;

    @RequestMapping(value = "/{id}")
    @GetMapping
    public ResponseEntity<ConverterStatusWallet> convertStatusToWallet(@PathVariable String id) throws InterruptedException {
        Integer walletId = Integer.valueOf(id);
        WalletViewModel myWallet = walletDataService.getUserWalletById(walletId);
        List<StatusWalletViewModel> walletStatus = walletDataService.getWalletStatus();
        ConverterStatusWallet convertStatus = fillConvertModel(myWallet,walletStatus);
        return ResponseEntity.ok(convertStatus);
    }

    public ConverterStatusWallet fillConvertModel(WalletViewModel myWallet,List<StatusWalletViewModel> walletStatus){
        ConverterStatusWallet converterStatusWallet = new ConverterStatusWallet();
        converterStatusWallet.setId(myWallet.getId());
        converterStatusWallet.setBalance(myWallet.getBalance());
        for (StatusWalletViewModel item: walletStatus  ) {
         if(myWallet.getStatusWalletId() == item.getId()){
             converterStatusWallet.setStatus(item.getName());
         }
        }
        return converterStatusWallet;
    }
}
