package com.griddynamics.conversion.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "exchange_rates")
public class CurrencyConversionRate {

    @EmbeddedId
    private CurrencyId currency;

    @Column(name = "exchange_rate")
    private BigDecimal exchangeRate;

    public CurrencyId getCurrency() {
        return currency;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public CurrencyConversionRate setCurrency(CurrencyId currency) {
        this.currency = currency;
        return this;
    }

    public CurrencyConversionRate setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
        return this;
    }
}
