package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.StatusWallet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusWalletRepository extends CrudRepository<StatusWallet, Long> { }
