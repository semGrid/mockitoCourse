package com.griddynamics.banksinfo.services;

import com.griddynamics.banksinfo.domain.BankInformation;

import java.math.BigDecimal;
import java.util.Collection;

public interface BanksInformationService {

    String getBankCurrency(String bankCode);

    BigDecimal getBankCommission(String bankCode);

    Collection<BankInformation> getAll();

    BankInformation findByCode(String bankCode);


}
