package com.griddynamics.transfer.services;

import com.griddynamics.transfer.domain.TransferTransaction;
import com.griddynamics.transfer.domain.TransferredMoneyResponse;

import java.math.BigDecimal;
import java.util.Collection;

public interface MoneyTransferService {

    void saveTransaction(TransferTransaction transaction);

    TransferredMoneyResponse calculateReceivedAmount(final BigDecimal amount,
                                                     final BigDecimal commissionPercentage,
                                                     final String currency);

    Collection<TransferTransaction> getTransferTransactions();
}
