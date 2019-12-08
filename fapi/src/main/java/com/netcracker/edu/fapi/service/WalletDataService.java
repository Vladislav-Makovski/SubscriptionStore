package com.netcracker.edu.fapi.service;
import com.netcracker.edu.fapi.models.RegistrationAdvertiserViewModel;
import com.netcracker.edu.fapi.models.RegistrationCustomerViewModel;
import com.netcracker.edu.fapi.models.StatusWalletViewModel;
import com.netcracker.edu.fapi.models.WalletViewModel;

import java.util.List;

public interface WalletDataService {
    List<StatusWalletViewModel> getWalletStatus();
    WalletViewModel getUserWalletById(Integer id);
    WalletViewModel saveBalanceRecharge(WalletViewModel wallet);
    WalletViewModel saveBalanceWithdraw(WalletViewModel wallet);
    WalletViewModel saveNewWalletCustomer(RegistrationCustomerViewModel info);
    WalletViewModel saveNewWalletAdvertiser(RegistrationAdvertiserViewModel info);
    void deleteWalletById(Integer id);
}
