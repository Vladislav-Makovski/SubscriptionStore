package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.CustomerViewModel;
import com.netcracker.edu.fapi.models.NewCustomerViewModel;

public interface CustomerDataService {

    CustomerViewModel saveNewCustomer(NewCustomerViewModel customer);
}
