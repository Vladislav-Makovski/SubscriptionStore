package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.NewUserDetailsViewModel;
import com.netcracker.edu.fapi.models.UserDetailsViewModel;

public interface UserDetailsDataService {

    UserDetailsViewModel saveNewUserDetails(UserDetailsViewModel userDetails);

}
