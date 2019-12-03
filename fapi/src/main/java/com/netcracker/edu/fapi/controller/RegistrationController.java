package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.*;
import com.netcracker.edu.fapi.service.CustomerDataService;
import com.netcracker.edu.fapi.service.UserDetailsDataService;
import com.netcracker.edu.fapi.service.WalletDataService;
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



    @RequestMapping(value = "/api/new/customer", method = RequestMethod.POST)
    public ResponseEntity<UserSignatureViewModel> saveCustomer(@RequestBody RegistrationCustomerViewModel information) {
        WalletViewModel newWallet = new WalletViewModel();
        newWallet.setBalance(information.getBalance());
        newWallet.setStatusWalletId(information.getStatusWalletId());
        WalletViewModel wallet = walletDataService.saveNewWallet(newWallet);
        UserDetailsViewModel userDetailsViewModel = new UserDetailsViewModel();
        userDetailsViewModel.setEmail(information.getEmail());
        userDetailsViewModel.setPassword(information.getPassword());
        userDetailsViewModel.setUsername(information.getUsername());
        userDetailsViewModel.setUserRoleId(information.getUserRoleId());
        UserDetailsViewModel userDetails = userDetailsDataService.saveNewUserDetails(userDetailsViewModel);
        NewCustomerViewModel saveCustomer = new NewCustomerViewModel();
        saveCustomer.setFirstName(information.getFirstName());
        saveCustomer.setSurname(information.getSurname());
        saveCustomer.setUserDetailsId(userDetails.getId());
        saveCustomer.setWalletId(wallet.getId());
        CustomerViewModel customerViewModel = customerDataService.saveNewCustomer(saveCustomer);
        UserSignatureViewModel userSignatureViewModel = new UserSignatureViewModel();
        userSignatureViewModel.setId(customerViewModel.getId());
        userSignatureViewModel.setUserDetailsId(userDetails.getId());
        userSignatureViewModel.setWalletId(wallet.getId());
        userSignatureViewModel.setUserRole(userDetails.getUserRoleId());
        return ResponseEntity.ok(userSignatureViewModel);
    }
}
