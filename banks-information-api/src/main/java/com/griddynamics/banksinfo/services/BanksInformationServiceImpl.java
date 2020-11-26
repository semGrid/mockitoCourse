package com.griddynamics.banksinfo.services;

import com.griddynamics.banksinfo.domain.BankInformation;
import com.griddynamics.banksinfo.repositories.BanksInformationRepository;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;

@Service
public class BanksInformationServiceImpl implements BanksInformationService {

    private final BanksInformationRepository repository;

    public BanksInformationServiceImpl(BanksInformationRepository repository) {
        this.repository = repository;
    }

    @Override
    public String getBankCurrency(String bankCode) {
        return findByCode(bankCode).getCurrency();
    }

    @Override
    public BigDecimal getBankCommission(String bankCode) {
        return findByCode(bankCode).getCommissionPercentage();
    }

    @Override
    public Collection<BankInformation> getAll() {
        return repository.findAll();
    }

    @Override
    public BankInformation findByCode(String bankCode) {
        return repository.findById(bankCode)
                .orElseThrow(() ->
                        new IllegalArgumentException(String.format("Bank with code %s does not exist", bankCode)));
    }
}
