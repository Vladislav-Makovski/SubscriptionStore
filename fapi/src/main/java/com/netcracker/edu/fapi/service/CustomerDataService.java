package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.CustomerViewModel;
import com.netcracker.edu.fapi.models.RegistrationCustomerViewModel;
import com.netcracker.edu.fapi.models.UserDetailsViewModel;
import com.netcracker.edu.fapi.models.WalletViewModel;

public interface CustomerDataService {

    CustomerViewModel saveNewCustomer(RegistrationCustomerViewModel inf, WalletViewModel wallet, UserDetailsViewModel userDetails);
}
