package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.*;

public interface AdvertiserDataService {

    AdvertiserViewModel saveNewAdvertiser(RegistrationAdvertiserViewModel inf, WalletViewModel wallet, UserDetailsViewModel userDetails);
}
