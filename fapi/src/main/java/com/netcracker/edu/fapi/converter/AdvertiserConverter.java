package com.netcracker.edu.fapi.converter;

import com.netcracker.edu.fapi.models.*;
import com.netcracker.edu.fapi.service.AdvertiserDataService;
import com.netcracker.edu.fapi.service.WalletDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class AdvertiserConverter {

    @Autowired
    private AdvertiserDataService advertiserDataService;

    @Autowired
    private WalletDataService walletDataService;

    @RequestMapping("/api/advertiser/byNameAsc")
    @GetMapping
    public ResponseEntity<List<ConvertAdvertiser>> getAllAdvertiserByNameAsc() {
        List<AdvertiserViewModel> advertiser = advertiserDataService.getAllByNameAsc();
        List<ConvertAdvertiser> convertAdvertisers = fillConvertModel(advertiser);
        return ResponseEntity.ok(convertAdvertisers == null ? Collections.emptyList() : convertAdvertisers);
    }

    public List<ConvertAdvertiser> fillConvertModel(List<AdvertiserViewModel> advertiser){
        List<ConvertAdvertiser> convertAdvertisers = new ArrayList<>();
        for (AdvertiserViewModel item: advertiser ) {
            ConvertAdvertiser a = new ConvertAdvertiser();
            WalletViewModel walletViewModel = walletDataService.getUserWalletById(item.getWalletId());
            a.setId(item.getId());
            a.setName(item.getName());
            a.setWalletId(item.getWalletId());
            a.setUserDetailsId(item.getUserDetailsId());
            a.setBalance(walletViewModel.getBalance());
            convertAdvertisers.add(a);
            }
        return convertAdvertisers;
    }
}
