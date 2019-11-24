package com.netcracker.edu.fapi.service;
import com.netcracker.edu.fapi.models.StatusWalletViewModel;
import com.netcracker.edu.fapi.models.WalletViewModel;

import java.util.List;

public interface WalletDataService {
    List<StatusWalletViewModel> getWalletStatus();
    WalletViewModel getUserWalletById(Integer id);
}
