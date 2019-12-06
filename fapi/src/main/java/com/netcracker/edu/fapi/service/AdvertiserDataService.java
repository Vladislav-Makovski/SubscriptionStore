package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.*;

import java.util.List;

public interface AdvertiserDataService {

    AdvertiserViewModel saveNewAdvertiser(RegistrationAdvertiserViewModel inf, WalletViewModel wallet, UserDetailsViewModel userDetails);
    List<AdvertiserViewModel> getAllByNameAsc();
}

