package com.griddynamics.transfer.services;

import com.griddynamics.transfer.domain.Recipient;
import com.griddynamics.transfer.domain.TransactionStatus;
import com.griddynamics.transfer.domain.TransferTransaction;
import com.griddynamics.transfer.domain.TransferredMoneyResponse;
import com.griddynamics.transfer.repositories.MoneyTransactionsRepository;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;

@Service
public class MoneyTransferServiceImpl implements MoneyTransferService {

    private final MoneyTransactionsRepository repository;

    public MoneyTransferServiceImpl(MoneyTransactionsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveTransaction(TransferTransaction transaction) {
        repository.save(transaction);
    }

    @Override
    public TransferredMoneyResponse calculateReceivedAmount(final BigDecimal amount,
                                                            final BigDecimal commissionPercentage,
                                                            final String currency) {
        final BigDecimal commission = calculateCommission(amount, commissionPercentage);
        final Recipient recipient = new Recipient()
                .setCurrency(currency)
                .setCommission(commission)
                .setTotal(amount.subtract(commission));

        return new TransferredMoneyResponse()
                .setRecipient(recipient)
                .setStatus(TransactionStatus.SENT);
    }

    @Override
    public Collection<TransferTransaction> getTransferTransactions() {
        return repository.findAll();
    }

    private BigDecimal calculateCommission(BigDecimal amount, BigDecimal commission) {
        return amount.multiply(commission)
                        .divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
    }
}
