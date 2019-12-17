package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.Validator.AdvertiserValidator;
import com.netcracker.edu.fapi.Validator.CustomerValidator;
import com.netcracker.edu.fapi.models.*;
import com.netcracker.edu.fapi.service.*;
import com.netcracker.edu.fapi.service.impl.UserInformationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private WalletDataService walletDataService;

    @Autowired
    private UserDetailsDataService userDetailsDataService;

    @Autowired
    private CustomerDataService customerDataService;

    @Autowired
    private AdvertiserDataService advertiserDataService;

    @Autowired
    private UserInformationService userInformationService;



    @RequestMapping(value = "/api/new/customer", method = RequestMethod.POST)
    public ResponseEntity<UserSignatureViewModel> saveCustomer(@RequestBody RegistrationCustomerViewModel information) {
        CustomerValidator valid = new CustomerValidator();
        UserSignatureViewModel failedUser = new UserSignatureViewModel();
        if(valid.validate(information)) {
            UserDetailsViewModel dublikateUser = userInformationService.getUserByUsername(information.getUsername());
            if(dublikateUser == null){
            WalletViewModel wallet = walletDataService.saveNewWalletCustomer(information);
        UserDetailsViewModel userDetails = userDetailsDataService.saveNewUserDetailsCustomer(information);
        CustomerViewModel customerViewModel = customerDataService.saveNewCustomer(information,wallet,userDetails);
            UserSignatureViewModel userSignatureViewModel = new UserSignatureViewModel();
        userSignatureViewModel.setId(customerViewModel.getId());
        userSignatureViewModel.setUserDetailsId(userDetails.getId());
            userSignatureViewModel.setWalletId(wallet.getId());
        userSignatureViewModel.setUserRole(userDetails.getUserRoleId());
            return ResponseEntity.ok(userSignatureViewModel);
            }
        }

        return ResponseEntity.ok(failedUser);
    }

    @RequestMapping(value = "/api/new/advertiser", method = RequestMethod.POST)
    public ResponseEntity<UserSignatureViewModel> saveAdvertiser(@RequestBody RegistrationAdvertiserViewModel information) {
        AdvertiserValidator valid = new AdvertiserValidator();
        UserSignatureViewModel failedUser = new UserSignatureViewModel();
        if(valid.validate(information)) {
            if(userInformationService.getUserByUsername(information.getUsername()) == null) {
                WalletViewModel wallet = walletDataService.saveNewWalletAdvertiser(information);
        UserDetailsViewModel userDetails = userDetailsDataService.saveNewUserDetailsAdvertiser(information);
        AdvertiserViewModel advertiserViewModel = advertiserDataService.saveNewAdvertiser(information,wallet,userDetails);
                UserSignatureViewModel userSignatureViewModel = new UserSignatureViewModel();
        userSignatureViewModel.setId(advertiserViewModel.getId());
        userSignatureViewModel.setUserDetailsId(userDetails.getId());
                userSignatureViewModel.setWalletId(wallet.getId());
        userSignatureViewModel.setUserRole(userDetails.getUserRoleId());
                return ResponseEntity.ok(userSignatureViewModel);
            }
        }
        return  ResponseEntity.ok(failedUser);
    }
}
