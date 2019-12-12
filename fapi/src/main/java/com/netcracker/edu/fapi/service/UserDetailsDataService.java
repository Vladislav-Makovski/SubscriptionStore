package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.RegistrationAdvertiserViewModel;
import com.netcracker.edu.fapi.models.RegistrationCustomerViewModel;
import com.netcracker.edu.fapi.models.UserDetailsViewModel;

public interface UserDetailsDataService {

//    UserDetailsViewModel saveNewUserDetailsCustomer(RegistrationCustomerViewModel info);
//    UserDetailsViewModel saveNewUserDetailsAdvertiser(RegistrationAdvertiserViewModel info);
    UserDetailsViewModel getUserDetailsById(Integer id);
    void deleteUserDetailsById(Integer id);

}
