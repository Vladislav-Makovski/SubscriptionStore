package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.User;
import com.netcracker.edu.fapi.models.UserDetailsViewModel;
import com.netcracker.edu.fapi.models.UserSignatureViewModel;

public interface UserInformationService {

    UserDetailsViewModel getUserByUsername(String username);
}
