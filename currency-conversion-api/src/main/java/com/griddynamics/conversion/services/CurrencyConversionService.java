package com.griddynamics.conversion.services;

import com.griddynamics.conversion.entities.CurrencyConversionRate;
import com.griddynamics.conversion.domain.CurrencyConversionRequest;

import java.math.BigDecimal;
import java.util.Collection;

public interface CurrencyConversionService {

    Collection<CurrencyConversionRate> getRates();

    BigDecimal exchangeCurrency(CurrencyConversionRequest exchangeMoney);
}
