package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.*;

import java.util.List;

public interface CustomerDataService {

    CustomerViewModel saveNewCustomer(RegistrationCustomerViewModel inf, WalletViewModel wallet, UserDetailsViewModel userDetails);
    List<CustomerViewModel> getAllByNameAsc();
    void deleteCustomerById(Integer id);
    CustomerViewModel getCustomerById(Integer id);
    UserSignatureViewModel getCustomerByUserDetailsId(Integer id);
}
