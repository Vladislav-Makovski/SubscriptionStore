package com.netcracker.edu.fapi.converter;

import com.netcracker.edu.fapi.models.*;
import com.netcracker.edu.fapi.service.CustomerDataService;
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
public class CustomerConverter {

    @Autowired
    private CustomerDataService customerDataService;

    @Autowired
    private WalletDataService walletDataService;

    @RequestMapping("/api/customer/byNameAsc")
    @GetMapping
    public ResponseEntity<List<ConvertCustomer>> getAllCustomerByNameAsc() {
        List<CustomerViewModel> customer = customerDataService.getAllByNameAsc();
        List<ConvertCustomer> convertCustomer = fillConvertModel(customer);
        return ResponseEntity.ok(convertCustomer == null ? Collections.emptyList() : convertCustomer);
    }

    public List<ConvertCustomer> fillConvertModel(List<CustomerViewModel> customer){
        List<ConvertCustomer> convertCustomer = new ArrayList<>();
        for (CustomerViewModel item: customer ) {
            ConvertCustomer a = new ConvertCustomer();
            WalletViewModel walletViewModel = walletDataService.getUserWalletById(item.getWalletId());
            a.setId(item.getId());
            a.setFirstName(item.getFirstName());
            a.setSurname(item.getSurname());
            a.setWalletId(item.getWalletId());
            a.setUserDetailsId(item.getUserDetailsId());
            a.setBalance(walletViewModel.getBalance());
            convertCustomer.add(a);
        }
        return convertCustomer;
    }
}
