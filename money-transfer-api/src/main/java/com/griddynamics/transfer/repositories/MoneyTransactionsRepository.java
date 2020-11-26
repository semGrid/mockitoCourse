package com.griddynamics.transfer.repositories;

import com.griddynamics.transfer.domain.TransferTransaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoneyTransactionsRepository extends JpaRepository<TransferTransaction, Integer> {
}
