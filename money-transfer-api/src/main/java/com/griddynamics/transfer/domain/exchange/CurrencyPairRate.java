package com.griddynamics.transfer.domain.exchange;

import java.math.BigDecimal;

public final class CurrencyPairRate {

    private String fromCurrency;

    private String toCurrency;

    private BigDecimal amount;

    public String getFromCurrency() {
        return fromCurrency;
    }

    public CurrencyPairRate setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
        return this;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public CurrencyPairRate setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public CurrencyPairRate setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }
}
