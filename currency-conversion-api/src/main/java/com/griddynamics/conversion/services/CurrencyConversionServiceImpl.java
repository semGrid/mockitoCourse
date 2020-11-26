package com.griddynamics.conversion.services;

import com.griddynamics.conversion.entities.CurrencyConversionRate;
import com.griddynamics.conversion.entities.CurrencyId;
import com.griddynamics.conversion.domain.CurrencyConversionRequest;
import com.griddynamics.conversion.repository.CurrencyExchangeRateRepository;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {

    private final CurrencyExchangeRateRepository repository;

    public CurrencyConversionServiceImpl(CurrencyExchangeRateRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<CurrencyConversionRate> getRates() {
        return repository.findAll();
    }

    @Override
    public BigDecimal exchangeCurrency(CurrencyConversionRequest exchangeMoney) {
        if (!Objects.equals(exchangeMoney.getFromCurrency(), exchangeMoney.getToCurrency())) {
            final CurrencyConversionRate currencyConversionRate = repository
                    .findById(new CurrencyId(exchangeMoney.getFromCurrency(), exchangeMoney.getToCurrency()))
                    .orElseThrow(() -> new IllegalArgumentException("Not acceptable currency pair"));

            return exchangeMoney.getAmount().multiply(currencyConversionRate.getExchangeRate());

        }
        return exchangeMoney.getAmount();
    }
}
